package com.lingnan.examsys.business.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.RecordVO;
import com.lingnan.examsys.common.constant.MyType;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class RecordDaoImpl implements RecordDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public RecordDaoImpl(Connection conn) {
		this.conn = conn;
	}
	public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Ans_RecordVO> list = new ArrayList<Ans_RecordVO>();
		int user_id=user.getUser_id();
		String user_name=user.getUser_name();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select r.user_id user_id,user_name,que_content,r.error_flag error_flag,r.time time"
					+ "					from record r,user u,question_bank qb"
					+ "					where r.user_id=u.user_id and r.que_id=qb.que_id"
					+ "					and r.user_id=? and user_name=?");
			//给问号赋值
			prep.setInt(1, user_id);
			prep.setString(2, user_name);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				Ans_RecordVO ans_Record = new Ans_RecordVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				ans_Record.setUser_id(user_id);
				ans_Record.setUser_name(user_name);
				ans_Record.setQue_content(rs.getString("que_content"));
				ans_Record.setError_flag(rs.getInt("error_flag"));
				ans_Record.setTime(rs.getDate("time"));
				list.add(ans_Record); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询排名信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	public int createChapterTestRecord(int user_id, int exam_id, int chapter) {
		//预编译对象：运行存储过程使用CallableStatement
		CallableStatement  stmt = null;
		//结果集
		ResultSet res;
		int que_id;						//返回的第一题id
		try {
			//设置插入语句：执行存储过程用prepareCall()方法
			stmt = conn.prepareCall("CALL `p_chaptertestcreate_on_record`(?, ?, ?, ?, ?)");
			//设置参数
			stmt.setInt(1, user_id);
			stmt.setInt(2, exam_id);
			stmt.setInt(3, chapter);
			stmt.setInt(4, MyType.CHAPTER_TEST_NUM);
			stmt.registerOutParameter(5, Types.INTEGER);		//输出参数的类型设置
			//执行:使用存储过程是用execute()方法
			stmt.execute();
			que_id = stmt.getInt(5);
			if(que_id == 0) {
				System.err.println(Ca+"Procedure wrong");
			}
		}catch(SQLException e) {
			throw new DaoException("考试信息查询异常", e);
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return que_id;
	}
	@Override
	public RecordVO getLastQueidByExamidAndUserid(int exam_id, int user_id) {
		PreparedStatement  prep = null;
		ResultSet rs = null;
		RecordVO vo = null;
		try {
			//设置插入语句：执行存储过程用prepareCall()方法
			prep = conn.prepareCall("SELECT `user_id`, `Exam_id`, `Que_id`, `Error_flag`, `time`, `seq_num` "
					+ "FROM `record` "
					+ "WHERE user_id = ? AND Exam_id = ? AND time <'2000-01-01 01:01:01' "						//以时间少于2000年以前的题目为未答题
					+ "ORDER BY seq_num "
					+ "LIMIT 1");
			//设置参数
			prep.setInt(1, user_id);
			prep.setInt(2, exam_id);
			rs = prep.executeQuery();
			if(rs.next()) {
				vo = new RecordVO();
				
				vo.setQue_id(rs.getInt("Que_id"));
				vo.setError_flag(rs.getInt("Error_flag"));
				vo.setExam_id(exam_id);
				vo.setSeq_num(rs.getInt("seq_num"));
				vo.setTime(rs.getTimestamp("time"));
				vo.setUser_id(user_id);
			}else {
				throw new Exception("获取上次未完成答题的答题记录为空");
			}
		}catch(Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeStatement(rs, prep);
		}
		return vo;
	}
	@Override
	public int[] createExamRecord(int user_id, int exam_id) {
		//预编译对象：运行存储过程使用CallableStatement
		CallableStatement  stmt = null;
		//输出结果数组int[0]：考试题目总数、int[1]：第一题que_id
		int[] num = new int[2];																				
		try {
			//设置插入语句：执行存储过程用prepareCall()方法
			stmt = conn.prepareCall("CALL `p_examcreate_on_record`(?, ?, ?, ?)");
			//设置参数
			stmt.setInt(1, user_id);
			stmt.setInt(2, exam_id);
			stmt.registerOutParameter(3, Types.INTEGER);
			stmt.registerOutParameter(4, Types.INTEGER);
			//执行:使用存储过程是用execute()方法
			stmt.execute();
			num[0] = stmt.getInt(3);
			num[1] = stmt.getInt(4);
		}catch(SQLException e) {
			throw new DaoException("考试信息查询异常", e);
		}finally {
			DBUtils.closeStatement2(stmt);
		}
		return num;
	}
	@Override
	public int getNumOfAnswer(int ans_id) {
		PreparedStatement  prep = null;
		ResultSet rs = null;
		int num = 0;
		try {
			//设置插入语句：执行存储过程用prepareCall()方法
			prep = conn.prepareCall("SELECT COUNT(1) "
					+ "FROM `record` r, answer a "
					+ "WHERE  a.ans_id = ? "
					+ "AND a.Exam_id = r.exam_id "
					+ "AND a.user_id = r.user_id");
			//设置参数
			prep.setInt(1, ans_id);
			rs = prep.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}else {
				throw new Exception("获取答题题目数量为空");
			}
		}catch(Exception e) {
			System.err.println(Ca+e.getMessage());
		}finally {
			DBUtils.closeStatement(rs, prep);
		}
		return num;
	}
}
