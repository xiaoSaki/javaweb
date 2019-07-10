package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;
import com.lingnan.examsys.common.util.MyUtils;

public class Question_bankDaoImpl implements  Question_bankDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public Question_bankDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public boolean checkQuestion(int num){
		boolean flag = false;
		return flag;
	}
	//分页查看题库所有题目 2018/10/14 mai
		@Override
		public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize,int user_id) {
			System.out.println("分页查询dao");
			ResultSet rs = null;
			ResultSet rs1 = null;
			PreparedStatement ps = null;		
			PreparedStatement ps1 = null;
			Vector<Question_bankVO> v = new Vector<Question_bankVO>();
			try {
				/*firstIndex:起始索引
				 * pageSize:每页显示的数量
				 * orderColumn:排序的字段名
				 * sql:可以是简单的单表查询语句，也可以是复杂的多表联合查询语句
				 * rownum:行号
				 */
				int count = -1; //初始化数据库中数据的数量
				System.out.println("分页查询dao3");
				ps = conn.prepareStatement("select count(*) as count from question_bank where user_id=?");
				ps.setInt(1, user_id);
				rs = ps.executeQuery();
				if(rs.next()){
					count = rs.getInt("count"); //计算出数据的总数量
				}
//				System.out.println("count:"+count);
				int a = count % pageSize;  //看是否有余数，有的话加一页
				int allPageNum = -1;  //allPageNum指的是一共分了多少页，PageNum指的是当前页数
				if(a==0){
					allPageNum = count/pageSize;
				}else{
					allPageNum = (count/pageSize)+1;
				}
				if(pageNum>allPageNum){
					System.out.println("没有该页数，请重新输入1~"+allPageNum+"之间的页数");
				}
//				System.out.println("PageNum:"+pageNum+" "+"pageSize:"+pageSize);
				ps1 = conn.prepareStatement(" select * from question_bank where user_id=? order by Que_chapter limit ?,?");  //limit 0, 10 表示从第0条开始，一共找10条
				ps1.setInt(1, user_id);
				ps1.setInt(2, (pageNum-1)*pageSize);
				ps1.setInt(3, pageSize);			
				rs1 = ps1.executeQuery();		
				while (rs1.next()) {
					Question_bankVO que_bankVO = new Question_bankVO();
//					que_bankVO.setUser_id(rs1.getInt("user_id"));
					que_bankVO.setQue_id(rs1.getInt("que_id"));
					que_bankVO.setQue_charpter(rs1.getInt("que_chapter"));  //章节
					que_bankVO.setQue_type(rs1.getString("que_type"));  //单选或者多选
					que_bankVO.setQue_content(rs1.getString("que_content"));  //试题内容
					que_bankVO.setQue_options(rs1.getString("que_options"));  //试题选项内容
					que_bankVO.setQue_answer(rs1.getString("que_answer"));  //试题答案
					v.add(que_bankVO);
				}
//				System.out.println("count:"+count+" "+"allPageNum:"+allPageNum);
			} catch (SQLException e) {
				// 将异常封装成自定义异常
				throw new DaoException("分页查询试题失败", e);
			} finally {
				// 调用数据库工具类，关闭结果集对象和声明对象
				DBUtils.closeStatement(rs, ps);
				DBUtils.closeStatement(rs1, ps1);
			}
			return v;
		}
	   
		//模糊查询试题(根据试题内容) 2018/10/28 mai
		@Override
		public Vector<Question_bankVO> findQuestion_bankByContent(String Que_content) {
			ResultSet rs = null;
			PreparedStatement ps = null;		
			Vector<Question_bankVO> v = new Vector<Question_bankVO>();
			try {
				ps = conn.prepareStatement("select * from question_bank where Que_content like ? order by Que_chapter");
				ps.setString(1,"%"+Que_content+"%");  //预编译模糊查询
				rs = ps.executeQuery();
				while(rs.next()){
					Question_bankVO que_bankVO = new Question_bankVO();
//					que_bankVO.setUser_id(rs1.getInt("user_id"));
					que_bankVO.setQue_id(rs.getInt("que_id"));
					que_bankVO.setQue_charpter(rs.getInt("que_chapter"));  //章节
					que_bankVO.setQue_type(rs.getString("que_type"));  //单选或者多选
					que_bankVO.setQue_content(rs.getString("que_content"));  //试题内容
					que_bankVO.setQue_options(rs.getString("que_options"));  //试题选项内容
					que_bankVO.setQue_answer(rs.getString("que_answer"));  //试题答案
					v.add(que_bankVO);
				}
			} catch (SQLException e) {
				throw new DaoException("模糊查询试题失败", e);
			}finally {
				DBUtils.closeStatement(rs, ps);
			}
			return v;
		}
		
		//根据试题类型查询试题 2018/10/28 mai
		@Override
		public Vector<Question_bankVO> findQuestion_bankByType(String Que_type) {
			ResultSet rs = null;
			PreparedStatement ps = null;		
			Vector<Question_bankVO> v = new Vector<Question_bankVO>();
			try {
				ps = conn.prepareStatement("select * from question_bank where Que_type = ? order by Que_chapter");
				ps.setString(1,Que_type);  //预编译模糊查询
				rs = ps.executeQuery();
				while(rs.next()){
					Question_bankVO que_bankVO = new Question_bankVO();
//					que_bankVO.setUser_id(rs1.getInt("user_id"));
					que_bankVO.setQue_id(rs.getInt("que_id"));
					que_bankVO.setQue_charpter(rs.getInt("que_chapter"));  //章节
					que_bankVO.setQue_type(rs.getString("que_type"));  //单选或者多选
					que_bankVO.setQue_content(rs.getString("que_content"));  //试题内容
					que_bankVO.setQue_options(rs.getString("que_options"));  //试题选项内容
					que_bankVO.setQue_answer(rs.getString("que_answer"));  //试题答案
					v.add(que_bankVO);
				}
			} catch (SQLException e) {
				throw new DaoException("根据试题类型查询试题失败", e);
			}finally {
				DBUtils.closeStatement(rs, ps);
			}
			return v;
		}
		
		//根据试题内容和试题类型查询试题 2018/10/28 mai
		@Override
		public Vector<Question_bankVO> findQuestion_bankByContentAndType(
				String Que_content, String Que_type) {
			ResultSet rs = null;
			PreparedStatement ps = null;		
			Vector<Question_bankVO> v = new Vector<Question_bankVO>();
			try {
				ps = conn.prepareStatement("select * from question_bank where Que_content like ? and Que_type = ? order by Que_chapter");
				ps.setString(1,"%"+Que_content+"%");
				ps.setString(2,Que_type);
				rs = ps.executeQuery();
				while(rs.next()){
					Question_bankVO que_bankVO = new Question_bankVO();
//					que_bankVO.setUser_id(rs1.getInt("user_id"));
					que_bankVO.setQue_id(rs.getInt("que_id"));
					que_bankVO.setQue_charpter(rs.getInt("que_chapter"));  //章节
					que_bankVO.setQue_type(rs.getString("que_type"));  //单选或者多选
					que_bankVO.setQue_content(rs.getString("que_content"));  //试题内容
					que_bankVO.setQue_options(rs.getString("que_options"));  //试题选项内容
					que_bankVO.setQue_answer(rs.getString("que_answer"));  //试题答案
					v.add(que_bankVO);
				}
			} catch (SQLException e) {
				throw new DaoException("根据试题内容和试题类型查询试题失败", e);
			}finally {
				DBUtils.closeStatement(rs, ps);
			}
			return v;
		}
		
		//教师端添加试题 2018/10/24 mai
		@Override
		public boolean insertQuestion(Question_bankVO qbVO) {
			PreparedStatement ps = null;
			boolean flag = false;
			try {
				ps = conn.prepareStatement("insert into question_bank(user_id,Que_chapter,Que_type,Que_content,"
						+ "Que_options,Que_answer) values(?,?,?,?,?,?)");
				ps.setInt(1, qbVO.getUser_id());
				ps.setInt(2, qbVO.getQue_charpter());
				ps.setString(3, qbVO.getQue_type());
				ps.setString(4, qbVO.getQue_content());
				ps.setString(5, qbVO.getQue_options());
				ps.setString(6, qbVO.getQue_answer());
				ps.executeUpdate();
				flag = true;
				System.out.println("1.flag:"+flag);
			} catch (SQLException e) {
				throw new DaoException("教师添加试题失败", e);
			} finally {
				DBUtils.closeStatement(null, ps);
			}
			return flag;
		}
		/**
		 * add mai
		 * add 2018/11/17
		 * 删除试题
		 */
		@Override
		public boolean delQueByque_id(int que_id) {
			boolean flag = false;
			PreparedStatement prep = null;
			try{
				prep = conn.prepareStatement("delete from question_bank where que_id = ? ");
				prep.setInt(1, que_id);
				prep.executeUpdate();
				flag = true;
			}catch(Exception e){
				System.out.println("删除试卷时出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag;
		}

		/**
		 * add mai
		 * add 2018/11/17
		 * 根据que_id删除Que_Exam
		 */
		@Override
		public boolean delQue_Exam(int que_id) {
			boolean flag = false;
			PreparedStatement prep = null;
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("delete from que_exam where que_id = ?");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setInt(1, que_id);
				prep.executeUpdate();
				flag = true;
			}catch(Exception e){
				System.out.println("根据que_id删除Que_Exam出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag;
		}

		/**
		 * add mai
		 * add 2018/11/17
		 * 根据que_id删除record
		 */
		@Override
		public boolean delRecord(int que_id) {
			boolean flag = false;
			PreparedStatement prep = null;
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("delete from record where que_id = ?");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setInt(1, que_id);
				prep.executeUpdate();
				flag = true;
			}catch(Exception e){
				System.out.println("根据que_id删除Record出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag;
		}


		/**
		 * zhi：统计教师试题
		 */
		public int maxQuestion(int user_id){
			PreparedStatement ps = null;
			ResultSet rs = null;
			int num=0;
			try {
				ps = conn.prepareStatement("select * from question_bank where user_id=?");
				ps.setInt(1, user_id);
				rs = ps.executeQuery();
				while(rs.next()){
					num++;
				}
			} catch (SQLException e) {
				throw new DaoException("1.统计教师试题失败", e);
			} finally {
				DBUtils.closeStatement(rs, ps);
			}
			return num;
		}
		public Question_bankVO getQuetionById(int que_id) {
			PreparedStatement prep = null;
			ResultSet rs = null;
			Question_bankVO vo = new Question_bankVO();
			try {
				prep = conn.prepareStatement("SELECT `Que_id`, `user_id`, `Que_chapter`, `Que_type`, `Que_content`, `Que_answer`, `Que_url`, `Que_options` "
						+ "FROM `question_bank` "
						+ "WHERE Que_id = ?");
				prep.setInt(1, que_id);
				rs = prep.executeQuery();
				if(rs.next()) {
					vo.setQue_id(rs.getInt("Que_id"));
					vo.setQue_type(rs.getString("Que_type"));
					vo.setUser_id(rs.getInt("user_id"));
					vo.setQue_answer(rs.getString("Que_answer"));
					vo.setQue_charpter(rs.getInt("Que_chapter"));
					vo.setQue_content(rs.getString("Que_content"));
					vo.setQue_options(rs.getString("Que_options"));
					vo.setQue_url(rs.getString("Que_url"));
				}
			}catch(Exception e){
				System.err.println(Ca+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return vo;
		}

		@Override
		public int checkAnswer(int que_id,String answer) {
			PreparedStatement prep = null;
			ResultSet rs = null;
			String answer_real = "";
			try {
				prep = conn.prepareCall("SELECT `Que_answer`FROM `question_bank` WHERE `Que_id` = ?");
				prep.setInt(1, que_id);
				rs = prep.executeQuery();
				if(rs.next()) {
					answer_real = rs.getString("Que_answer");
				}
			}catch(Exception e){
				System.err.println(Ca+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return MyUtils.checkAnswer(answer, answer_real);
		}

		@Override
		public String getAnswerbyId(int que_id) {
			PreparedStatement prep = null;
			ResultSet rs = null;
			String answer_real = "";
			try {
				prep = conn.prepareCall("SELECT `Que_answer`FROM `question_bank` WHERE `Que_id` = ?");
				prep.setInt(1, que_id);
				rs = prep.executeQuery();
				if(rs.next()) {
					answer_real = rs.getString("Que_answer");
				}
			}catch(Exception e){
				System.err.println(Ca+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return answer_real;
		}

		@Override
		public int getMaxChapterNum() {
			PreparedStatement prep = null;
			ResultSet rs = null;
			int num = 0;
			try {
				prep = conn.prepareCall("SELECT MAX(Que_chapter) FROM `question_bank`");
				rs = prep.executeQuery();
				if(rs.next()) {
					num = rs.getInt(1);
				}else {
					throw new Exception("获取最大章节数错误");
				}
			}catch(Exception e){
				System.err.println(Ca+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return num;
		}	
}
