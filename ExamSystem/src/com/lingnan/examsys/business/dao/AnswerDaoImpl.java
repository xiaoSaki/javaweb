package com.lingnan.examsys.business.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.AnswerVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.AnswerRecordPOJO;
import com.lingnan.examsys.common.constant.MyType;
import com.lingnan.examsys.common.util.DBUtils;

public class AnswerDaoImpl implements AnswerDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;

	public AnswerDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@SuppressWarnings("resource")
	@Override
	public AnswerVO chapterTest(int user_id,int chapter) {
		PreparedStatement prep = null;
		AnswerVO ans_vo = new AnswerVO();
		//结果集
		ResultSet rs = null;
		try{
			//获取随机生成的试卷对象
			ExaminationDao exam_dao = new ExaminationDaoImpl(conn);
			ExaminationVO exam_vo = exam_dao.addExam(chapter);
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("INSERT INTO `answer`"
					+ "(`user_id`, `Exam_id`, `ans_id`, `ans_begin`, `ans_end`, `error_sum`) "
					+ "VALUES (?,?,NULL,?,?,?)");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);													
			prep.setInt(2, exam_vo.getExam_id());
			prep.setTimestamp(3, exam_vo.getExam_begin());
			prep.setTimestamp(4, exam_vo.getExam_end());
			prep.setInt(5, 0);
			int ins = prep.executeUpdate();
			if(ins == 0) {
				System.err.println("更新值为0");
			}
			prep = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			//执行查询语句再利用结果集接收查询结果
			rs = prep.executeQuery();
			if(rs.next()) {
				int ans_id = rs.getInt("LAST_INSERT_ID()");
				System.out.println("ans_id:"+ans_id);
				ans_vo.setAns_id(ans_id);
				ans_vo.setUser_id(user_id);
				ans_vo.setExam_id(exam_vo.getExam_id());
				ans_vo.setAns_begin(exam_vo.getExam_begin());
				ans_vo.setAns_end(exam_vo.getExam_end());
				ans_vo.setError_sum(0);
			}else {
				System.err.println(Ca+"Not random ID created ");
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return ans_vo;
	}

	@Override
	public int getErrorsumById(int ans_id) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		int error_sum = 0;
		try {
			prep = conn.prepareStatement("SELECT * FROM `answer` WHERE ans_id = ?"); 
			prep.setInt(1, ans_id);
			rs = prep.executeQuery();
			if(rs.next()) {
				error_sum = rs.getInt("error_sum");
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return error_sum;
	}

	@Override
	public int setErrorsumById(int ans_id,int set) {
		PreparedStatement prep = null;
		int rs = 0;
		try {
			prep = conn.prepareStatement("UPDATE `answer` SET `error_sum` = ? WHERE `ans_id`= ?");
			prep.setInt(1, set);
			prep.setInt(2, ans_id);
			rs = prep.executeUpdate();
			if(rs==0) throw new Exception("更新失败");
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return rs;
	}

	@Override
	public int setEndtimeById(int ans_id, Timestamp endtime) {
		PreparedStatement prep = null;
		int rs = 0;
		try {
			prep = conn.prepareStatement("UPDATE `answer` SET `ans_end` = ? WHERE `ans_id`= ?");
			prep.setTimestamp(1, endtime);
			prep.setInt(2, ans_id);
			rs = prep.executeUpdate();
			if(rs==0) throw new Exception("更新失败");
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return rs;
	}

	@Override
	public int updateTimeOnRecordByAns_Id(int ans_id, int user_id, int seq_num,Timestamp time) {
		CallableStatement call = null;
		int update = 1;
		try {
			call = conn.prepareCall("CALL p_updateTimeFromAnswer_on_record(?,?,?,?)");
			call.setInt(1, ans_id);
			call.setInt(2, user_id);
			call.setInt(3, seq_num);
			call.setTimestamp(4, time);
			call.execute();	
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(call); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return update;
	}

	@SuppressWarnings("resource")
	@Override
	public int getAndPlusErrorsumById(int ans_id) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		int error_sum = 0;
		try {
			prep = conn.prepareStatement("UPDATE answer SET error_sum = 1 + error_sum  WHERE ans_id = ?");
			prep.setInt(1, ans_id);
			if(prep.executeUpdate() == 0) {
				throw new Exception("更新条目为空");
			}else {
				prep = conn.prepareStatement("SELECT error_sum FROM answer where ans_id = ?");
				prep.setInt(1, ans_id);
				rs = prep.executeQuery();
				if(rs.next()) {
					error_sum = rs.getInt("error_sum");
				}else {
					throw new Exception("查询条目为空");
				}
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return error_sum;
	}

	@Override
	public int getNextQuetion(int ans_id, int user_id, int seq_num) {
		CallableStatement call = null;
		ResultSet rs = null;
		int que_id = 1;
		try {
			call = conn.prepareCall("CALL p_getnextquetion_on_Answer(?, ?, ?, ?)");
			call.setInt(1, ans_id);
			call.setInt(2, user_id);
			call.setInt(3, seq_num);
			call.registerOutParameter(4, Types.INTEGER);
			call.execute();	
			que_id = call.getInt(4);
			if(que_id == 0) {
				throw new Exception("获取下一题错误");
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(call); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return que_id;
	}

	@Override
	public int updateError_flagOnRecordByAns_Id(int ans_id, int user_id, int seq_num, int value) {
		CallableStatement call = null;
		ResultSet rs = null;
		int update = 1;
		try {
			call = conn.prepareCall("CALL `p_updateErrorFalgFromAnswer_on_record`(?, ?, ?, ?);");
			call.setInt(1, ans_id);
			call.setInt(2, user_id);
			call.setInt(3, seq_num);
			call.setInt(4, value);
			call.execute();	
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(call); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return update;
	}

	@Override
	public int ifExistAnswering(int user_id) {
		CallableStatement call = null;
		int ans_id = 0;
		try {
			call = conn.prepareCall("CALL `p_ifexistanswering_on_answer`(?, ?);");
			call.setInt(1, user_id);
			call.registerOutParameter(2, Types.INTEGER);
			call.execute();	
			ans_id = call.getInt(2);
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(call); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return ans_id;
	}

	@Override
	public AnswerVO getAnswerById(int ans_id) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		AnswerVO vo = null;
		try {
			prep = conn.prepareStatement("SELECT `user_id`, `Exam_id`, `ans_id`, `ans_begin`, `ans_end`, `error_sum` FROM `answer` WHERE ans_id = ?"); 
			prep.setInt(1, ans_id);
			rs = prep.executeQuery();
			if(rs.next()) {
				vo = new AnswerVO();
				vo.setUser_id(rs.getInt("user_id"));
				vo.setExam_id(rs.getInt("Exam_id"));
				vo.setError_sum(rs.getInt("error_sum"));
				vo.setAns_id(rs.getInt("ans_id"));
				vo.setAns_end(rs.getTimestamp("ans_end"));
				vo.setAns_begin(rs.getTimestamp("ans_begin"));
			}else {
				throw new Exception("查询结果为空");
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return vo;
	}

	@Override
	public int getTypeOfAnswerById(int ans_id) {
		CallableStatement call = null;
		int user_id = 0;
		try {
			call = conn.prepareCall("CALL `p_getanswertype_on_answer`(?,?);");
			call.setInt(1, ans_id);
			call.registerOutParameter(2, Types.INTEGER);
			call.execute();	
			user_id = call.getInt(2);
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(call); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return user_id;
	}

	@SuppressWarnings("resource")
	@Override
	public AnswerVO examTest(int user_id,int exam_id) {
		PreparedStatement prep = null;
		AnswerVO ans_vo = new AnswerVO();
		//结果集
		ResultSet rs = null;
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("INSERT INTO `answer`"
					+ "(`user_id`, `Exam_id`, `ans_id`, `ans_begin`, `ans_end`, `error_sum`) "
					+ "VALUES (?,?,NULL,?,?,?)");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);													
			prep.setInt(2, exam_id);
			Timestamp exam_begin = new Timestamp(System.currentTimeMillis());
			Timestamp exam_end = new Timestamp(exam_begin.getTime() + MyType.CHAPTER_TEST_TIME);
			prep.setTimestamp(3, exam_begin);
			prep.setTimestamp(4, exam_end);
			prep.setInt(5, 0);
			int update = prep.executeUpdate();
			if(update == 0) {
				throw new Exception("考试答题记录插入失败");
			}else {
				prep = conn.prepareStatement("SELECT LAST_INSERT_ID()");
				//执行查询语句再利用结果集接收查询结果
				rs = prep.executeQuery();
				if(rs.next()) {
					int ans_id = rs.getInt("LAST_INSERT_ID()");
					System.out.println("ans_id:"+ans_id);
					ans_vo.setAns_id(ans_id);
					ans_vo.setUser_id(user_id);
					ans_vo.setExam_id(exam_id);
					ans_vo.setAns_begin(exam_begin);
					ans_vo.setAns_end(exam_end);
					ans_vo.setError_sum(0);
				}else {
					throw new Exception("获取考试答题记录失败");
				}
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return ans_vo;
	}

	/*SELECT a.Exam_id, a.ans_id, a.ans_begin, a.ans_end, a.error_sum,e.exam_name,e.user_id,u.user_name FROM answer a,examination e,user u WHERE e.user_id != 1 AND a.user_id = 2016834102 AND e.exam_id = a.exam_id AND u.user_id = e.user_id*/
	
	@Override
	public ArrayList<AnswerRecordPOJO> getExamRecordWithPage(int user_id,int pageNo,int pageSize) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		ArrayList<AnswerRecordPOJO> list = new ArrayList<AnswerRecordPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT a.Exam_id, a.ans_id, MAX(a.ans_begin), a.ans_end, a.error_sum,e.exam_name,e.user_id,u.user_name "
					+ "FROM answer a,examination e,user u "
					+ "WHERE e.user_id != 1 "
					+ "AND a.user_id = ? "
					+ "AND e.exam_id = a.exam_id "
					+ "AND u.user_id = e.user_id "
					+ "GROUP BY a.Exam_id "
					+ "LIMIT ?,?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);													
			prep.setInt(2, (pageNo-1)*pageSize);												
			prep.setInt(3, pageNo*pageSize);
			rs = prep.executeQuery();
			while(rs.next()) {
				AnswerRecordPOJO vo = new AnswerRecordPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setAns_id(rs.getInt(2));
				vo.setAns_begin(rs.getTimestamp(3));
				vo.setAns_end(rs.getTimestamp(4));
				vo.setError_sum(rs.getInt(5));
				vo.setExam_name(rs.getString(6));
				vo.setTeacher_id(rs.getInt(7));
				vo.setTeacher_name(rs.getString(8));
				list.add(vo);
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public List<AnswerRecordPOJO> getChapterRecordWithPage(int user_id, int pageNo, int pageSize) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		ArrayList<AnswerRecordPOJO> list = new ArrayList<AnswerRecordPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT a.Exam_id, a.ans_id, a.ans_begin, a.ans_end, a.error_sum,e.exam_name,e.user_id,u.user_name "
					+ "FROM answer a,examination e,user u "
					+ "WHERE e.user_id = 1 "
					+ "AND a.user_id = ? "
					+ "AND e.exam_id = a.exam_id "
					+ "AND u.user_id = e.user_id "
					+ "ORDER BY ans_begin "
					+ "DESC LIMIT ?,?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);													
			prep.setInt(2, (pageNo-1)*pageSize);												
			prep.setInt(3, pageNo*pageSize);
			rs = prep.executeQuery();
			while(rs.next()) {
				AnswerRecordPOJO vo = new AnswerRecordPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setAns_id(rs.getInt(2));
				vo.setAns_begin(rs.getTimestamp(3));
				vo.setAns_end(rs.getTimestamp(4));
				vo.setError_sum(rs.getInt(5));
				vo.setExam_name(rs.getString(6));
				vo.setTeacher_id(rs.getInt(7));
				vo.setTeacher_name(rs.getString(8));
				list.add(vo);
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public List<AnswerRecordPOJO> getExamRecordByUserid(int user_id) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		List<AnswerRecordPOJO> list = new ArrayList<AnswerRecordPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT a.Exam_id, a.ans_id, MAX(a.ans_begin), a.ans_end, a.error_sum,e.exam_name "
					+ "FROM answer a,examination e "
					+ "WHERE e.user_id != 1 AND a.user_id = ? AND e.exam_id = a.exam_id "
					+ "GROUP BY a.Exam_id");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			while(rs.next()) {
				AnswerRecordPOJO vo = new AnswerRecordPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setAns_id(rs.getInt(2));
				vo.setAns_begin(rs.getTimestamp(3));
				vo.setAns_end(rs.getTimestamp(4));
				vo.setError_sum(rs.getInt(5));
				vo.setExam_name(rs.getString(6));
				list.add(vo);
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public List<AnswerRecordPOJO> getChapterRecordByUserid(int user_id) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		List<AnswerRecordPOJO> list = new ArrayList<AnswerRecordPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT a.Exam_id, a.ans_id, a.ans_begin, a.ans_end, a.error_sum,e.exam_name "
					+ "FROM answer a,examination e "
					+ "WHERE e.user_id = 1 "
					+ "AND a.user_id = ? "
					+ "AND e.exam_id = a.exam_id;");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			while(rs.next()) {
				AnswerRecordPOJO vo = new AnswerRecordPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setAns_id(rs.getInt(2));
				vo.setAns_begin(rs.getTimestamp(3));
				vo.setAns_end(rs.getTimestamp(4));
				vo.setError_sum(rs.getInt(5));
				vo.setExam_name(rs.getString(6));
				list.add(vo);
			}
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
}
