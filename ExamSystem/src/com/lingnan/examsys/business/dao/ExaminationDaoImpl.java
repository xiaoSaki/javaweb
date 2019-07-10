package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lingnan.examsys.business.domain.ExamInfoPOJO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.common.constant.MyType;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class ExaminationDaoImpl implements ExaminationDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public ExaminationDaoImpl(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 统计完成人数
	 */
	public int findFinishSt(int exam_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		int num=0;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select count(user_id) count from mission  where exam_id=? and finish_flag='完成'");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, exam_id);

			rs = prep.executeQuery();
			while(rs.next()){	
				num= rs.getInt("count");
			}
			
		}catch(Exception e){
			System.out.println("查找试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return num;
	}
	/**
	 * 查找试卷
	 */
	public List<ExaminationVO> findExamByUid(int user_id,String class_name){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select examination.*,b.a a from examination,(select exam_id,count(m.user_id) a "
					+ "from mission m,stu_class st,class c where m.user_id=st.user_id and st.class_id=c.class_id "
					+ "and c.class_name=? group by exam_id) b where  user_id=? and b.exam_id=examination.exam_id "
					+ " ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setString(1, class_name);
			prep.setInt(2, user_id);

			rs = prep.executeQuery();
			while(rs.next()){
				ExaminationVO ExaminationShow = new ExaminationVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				 int exam_id=rs.getInt("exam_id");
				ExaminationShow.setExam_id(exam_id);
				int numb = findFinishSt(exam_id);
				ExaminationShow.setUser_id(numb);
				ExaminationShow.setExam_name(rs.getString("exam_name"));
				ExaminationShow.setExam_begin(rs.getTimestamp("exam_begin"));
				ExaminationShow.setExam_end(rs.getTimestamp("exam_end"));
				list.add(ExaminationShow); //将对象放入集合中
				
			}
			
		}catch(Exception e){
			System.out.println("查找试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 查找学生完成情况
	 */
	public List<StuFinishStatusVO> findStuStatus(int exam_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<StuFinishStatusVO> list = new ArrayList<StuFinishStatusVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select user_name,m.user_id,finish_flag "
					+ "from user,(select user_id,finish_flag from mission where exam_id=?) m "
					+ "where m.user_id=user.user_id");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量

			prep.setInt(1, exam_id);

			rs = prep.executeQuery();
			while(rs.next()){
				StuFinishStatusVO ExaminationShow = new StuFinishStatusVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				ExaminationShow.setUser_id(rs.getInt("user_id"));
				ExaminationShow.setUser_name(rs.getString("user_name"));
				
				ExaminationShow.setStatus(rs.getString("finish_flag"));
				list.add(ExaminationShow); //将对象放入集合中
				
			}
			
		}catch(Exception e){
			System.out.println("查找学生完成情况时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 麦诗卉
	 */

	/**
	 * 2018/10/28 mai
	 * 教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间，user_id从页面取）,返回exam_id
	 */
	public int insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end) {
//		boolean flag = false;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		int exam_id = 0;
		try {
			ps = conn.prepareStatement("insert into examination(user_id,exam_name,exam_begin,exam_end) values (?,?,?,?)");
			ps.setInt(1, user_id);
			ps.setString(2, exam_name);		
			ps.setDate(3, new java.sql.Date(exam_begin.getTime()));
			ps.setDate(4, new java.sql.Date(exam_end.getTime()));
			int i = ps.executeUpdate();
			if (i > 0) {
				ps1 = conn.prepareStatement("select * from examination where user_id=? and exam_name=? ");
				ps1.setInt(1, user_id);
				ps1.setString(2, exam_name);
				rs1 = ps1.executeQuery();
				while(rs1.next()){
					exam_id = rs1.getInt("exam_id");
				}
//				flag = true;
				System.out.println("1.exam_id:"+exam_id);
				System.out.println("第一步：教师添加试卷信息完善成功");
			} else {
//				flag = false;
				System.out.println("教师添加试卷第一步失败");
			}
		} catch (SQLException e) {
			throw new DaoException("1.教师添加试卷信息完善失败", e);
		} finally {
			DBUtils.closeStatement(null, ps);
		}
		return exam_id;
	}
	
	/**
	 * add mai
	 * 查询该教师出过的试卷
	 */
	@Override
	public List<ExaminationVO> findExamByid(int user_id) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from examination where user_id = ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			while(rs.next()){
				ExaminationVO ExaminationShow = new ExaminationVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
//				int exam_id=rs.getInt("exam_id");
				ExaminationShow.setExam_id(rs.getInt("exam_id"));
				ExaminationShow.setExam_name(rs.getString("exam_name"));
				ExaminationShow.setExam_begin(rs.getTimestamp("exam_begin"));
				ExaminationShow.setExam_end(rs.getTimestamp("exam_end"));
				list.add(ExaminationShow); //将对象放入集合中				
			}			
		}catch(Exception e){
			System.out.println("查找试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * add mai
	 * 根据试卷名模糊查询试卷
	 */
	@Override
	public List<ExaminationVO> findExamByName(int user_id,String exam_name) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from examination where user_id = ? and Exam_name like ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			prep.setString(2, "%"+exam_name+"%");
			rs = prep.executeQuery();
			while(rs.next()){
				ExaminationVO ExaminationShow = new ExaminationVO(); //创建一个新用户对象，赋值给用户对象变量
				ExaminationShow.setExam_id(rs.getInt("exam_id"));
				ExaminationShow.setExam_name(rs.getString("exam_name"));
				ExaminationShow.setExam_begin(rs.getTimestamp("exam_begin"));
				ExaminationShow.setExam_end(rs.getTimestamp("exam_end"));
				list.add(ExaminationShow); //将对象放入集合中				
			}
//			System.out.println("cs:"+exam_name);
		}catch(Exception e){
			System.out.println("模糊查询试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	

	/**
	 * add mai
	 * 根据试卷id查找试题id
	 */
	@Override
	public List<Que_ExamVO> findQueByexam_id(int exam_id) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Que_ExamVO> list = new ArrayList<Que_ExamVO>();
		try{
			prep = conn.prepareStatement("select * from que_exam where exam_id = ? ");
			prep.setInt(1, exam_id);
			rs = prep.executeQuery();
			while(rs.next()){
				Que_ExamVO Que_ExamVO = new Que_ExamVO(); //创建一个新用户对象，赋值给用户对象变量
//				Que_ExamVO.setExam_id(rs.getInt("exam_id"));
				Que_ExamVO.setQue_id(rs.getInt("que_id"));
				list.add(Que_ExamVO); //将对象放入集合中				
			}
			System.out.println("cs:"+exam_id);
		}catch(Exception e){
			System.out.println("根据试卷id查找试题id出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	
	/**
	 * add mai
	 * 根据试卷id查找到的试题id去查询试题详情
	 */
	@Override
	public List<Question_bankVO> findQueByque_id(int a[]) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Question_bankVO> list = new ArrayList<Question_bankVO>();
		String b=String.valueOf(a[0]);  //把整型转换成字符串
		for (int i = 1; i < 50; i++) {
			if (a[i] == 0) {
				break;
			}
			b = b + ',' + String.valueOf(a[i]);
		}
//		System.out.println(b);
		try{
			prep = conn.prepareStatement("select * from question_bank where que_id in ("+b+")");			
			rs = prep.executeQuery();
			while(rs.next()){
				Question_bankVO que_bankVO = new Question_bankVO(); //创建一个新用户对象，赋值给用户对象变量
				que_bankVO.setUser_id(rs.getInt("user_id"));
				que_bankVO.setQue_id(rs.getInt("que_id"));
				que_bankVO.setQue_charpter(rs.getInt("que_chapter"));  //章节
				que_bankVO.setQue_type(rs.getString("que_type"));  //单选或者多选
				que_bankVO.setQue_content(rs.getString("que_content"));  //试题内容
				que_bankVO.setQue_options(rs.getString("que_options"));  //试题选项内容
				que_bankVO.setQue_answer(rs.getString("que_answer"));  //试题答案
				list.add(que_bankVO); //将对象放入集合中				
			}
		}catch(Exception e){
			System.out.println("根据试卷id查找到的试题id去查询试题详情出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * add mai
	 * 删除试卷中的试题(que_exam表)
	 */
	@Override
	public boolean delExam_Que(int exam_id, int que_id) {
		boolean flag = false;
		PreparedStatement prep = null;
		try{
			prep = conn.prepareStatement("delete from que_exam where exam_id = ? and que_id = ? ");
			prep.setInt(1, exam_id);
			prep.setInt(2, que_id);
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("删除试卷中的试题时出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	
	/**
	 * add mai
	 * 更新修改试题
	 */
	@Override
	public boolean updateQue_bank(Question_bankVO Que_bankVO) {
		boolean flag = false;
		PreparedStatement prep = null;
//		int user_id = Que_bankVO.getQue_id();
		int Que_id = Que_bankVO.getQue_id();
		int Que_charpter = Que_bankVO.getQue_charpter();
		String Que_type = Que_bankVO.getQue_type();
		String Que_content = Que_bankVO.getQue_content();
		String Que_options = Que_bankVO.getQue_options();
		String Que_answer = Que_bankVO.getQue_answer();
		System.out.println("dao测试:"+Que_id+Que_charpter+Que_type+Que_content+Que_options+Que_answer);
		try{
			prep = conn.prepareStatement("update question_bank set Que_chapter = ?,Que_type = ?,Que_content = ?,"
					+ "Que_options = ? ,Que_answer = ? where que_id = ? ");
			prep.setInt(1, Que_charpter);
			prep.setString(2, Que_type);
			prep.setString(3, Que_content);
			prep.setString(4, Que_options);
			prep.setString(5, Que_answer);
			prep.setInt(6, Que_id);
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("更新修改试题时出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	
	/**
	 * add mai
	 * 根据试题id查询一道试题
	 */
	@Override
	public List<Question_bankVO> findQueByid(int que_id) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Question_bankVO> list = new ArrayList<Question_bankVO>();
		try{
			prep = conn.prepareStatement("select * from question_bank where que_id = ? ");	
			prep.setInt(1, que_id);
			rs = prep.executeQuery();
			if(rs.next()){
				Question_bankVO Que_bankVO = new Question_bankVO();
				Que_bankVO.setUser_id(rs.getInt("user_id"));
				Que_bankVO.setQue_id(rs.getInt("que_id"));
				Que_bankVO.setQue_charpter(rs.getInt("que_chapter"));  //章节
				Que_bankVO.setQue_type(rs.getString("que_type"));  //单选或者多选
				Que_bankVO.setQue_content(rs.getString("que_content"));  //试题内容
				Que_bankVO.setQue_options(rs.getString("que_options"));  //试题选项内容
				Que_bankVO.setQue_answer(rs.getString("que_answer"));  //试题答案
				list.add(Que_bankVO);
			}
		}catch(Exception e){
			System.out.println("根据试题id查询一道试题出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * add mai
	 * 题库添加试卷试题
	 */
	@Override
	public boolean insertQueByid(int exam_id,int que_id) {
		boolean flag = false;
		PreparedStatement prep = null;
		try{
			prep = conn.prepareStatement("insert into que_exam values (?,?) ");
			prep.setInt(1, que_id);	
			prep.setInt(2, exam_id);
					
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("题库添加试卷试题时出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	/** 
	 * add mai
	 * add 2018/11/17
	 * 根据exam_id删除试卷
	 */
	@Override
	public boolean delExamByid(int exam_id) {
		boolean flag = false;
		PreparedStatement prep = null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("delete from examination where exam_id = ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, exam_id);
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("删除试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	
	/** 
	 * add mai
	 * add 2018/11/17
	 * 根据exam_id删除试题记录
	 */
	@Override
	public boolean delQue_ExamByid(int exam_id) {
		boolean flag = false;
		PreparedStatement prep = null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("delete from que_exam where exam_id = ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, exam_id);
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("根据exam_id删除试题记录出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	
	/**
	 * add mai
	 * add 2018/11/17
	 * 更新试卷信息
	 */
	@Override
	public boolean updateExam(ExaminationVO ExamVO) {
		boolean flag = false;
		PreparedStatement prep = null;
//		int user_id = ExamVO.getUser_id();
		int Exam_id = ExamVO.getExam_id();
		String Exam_name = ExamVO.getExam_name();
		Date Exam_begin = ExamVO.getExam_begin();
		Date Exam_end = ExamVO.getExam_end();
		System.out.println("dao测试:"+Exam_id+" "+Exam_name+" "+Exam_begin+" "+Exam_end);
		try{
			prep = conn.prepareStatement("update examination set Exam_name = ?,Exam_begin = ?,Exam_end = ? where Exam_id = ? ");
			prep.setString(1, Exam_name);
			prep.setDate(2, new java.sql.Date(Exam_begin.getTime()));
			prep.setDate(3, new java.sql.Date(Exam_end.getTime()));
			prep.setInt(4, Exam_id);
			prep.executeUpdate();
			flag = true;
		}catch(Exception e){
			System.out.println("更新修改试卷时出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(null, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	
	/**
	 * add mai
	 * add 2018/11/17
	 * 根据exam_id查找试卷
	 */
	@Override
	public List<ExaminationVO> findExamByexam_id(int exam_id) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from examination where Exam_id = ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, exam_id);
			rs = prep.executeQuery();
			while(rs.next()){
				ExaminationVO ExaminationShow = new ExaminationVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
//				int exam_id=rs.getInt("exam_id");
				ExaminationShow.setExam_id(rs.getInt("exam_id"));
				ExaminationShow.setExam_name(rs.getString("exam_name"));
				ExaminationShow.setExam_begin(rs.getTimestamp("exam_begin"));
				ExaminationShow.setExam_end(rs.getTimestamp("exam_end"));
				list.add(ExaminationShow); //将对象放入集合中				
			}			
		}catch(Exception e){
			System.out.println("查找试卷出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * qi
	 */
	public ArrayList<ExaminationVO> getExamByPage(int pageNo, int pageSize) {
		//考试信息集合
		ArrayList<ExaminationVO> list = new ArrayList<ExaminationVO>();
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		try {
			//计算出分页查询间距
			int No = (pageNo-1)*pageSize;
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT exam_id,user_id,exam_name,exam_begin,exam_end FROM examination ORDER BY exam_begin DESC LIMIT ?,?");
			prestmt.setInt(1,No);
			prestmt.setInt(2,pageSize);
			
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			
			//判断结果集是否为空，不为空则提取查询结果集内容
			while(rs.next()) {
				//数据库模型
				ExaminationVO vo = new ExaminationVO();
				vo.setExam_id(rs.getInt("exam_id"));
				vo.setUser_id(rs.getInt("user_id"));
				vo.setExam_name(rs.getString("exam_name"));
				vo.setExam_begin(rs.getTimestamp("exam_begin"));
				vo.setExam_end(rs.getTimestamp("exam_end"));
				list.add(vo);
			}
		}catch(SQLException e) {
			throw new DaoException("考试信息查询异常", e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return list;
	}

	@Override
	public int getMaxpageByPagesize(int pageSize) {
		//返回最大页码
		int maxPage = 0;
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT CEILING(COUNT(*)/?) maxpage FROM examination");
			prestmt.setInt(1,pageSize);
			
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				maxPage = rs.getInt("maxpage");
			}
		}catch(SQLException e) {
			throw new DaoException("考试信息查询异常", e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return maxPage;
	}
	
	
	@SuppressWarnings("resource")
	@Override
	public ExaminationVO addExam(int chapter) {
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet res;
		ExaminationVO vo = new ExaminationVO();
		try {
			//设置插入语句
			prestmt = conn.prepareStatement("INSERT INTO `examination`(`exam_id`, `user_id`, `Exam_name`, `Exam_begin`, `Exam_end`, `chapter`) VALUES (null,1,?,?,?,?);");
			//设置测试开始和结束时间，examination与answer的开始时间需一致故使用共享时间对象
			Timestamp exam_begin = new Timestamp(System.currentTimeMillis());
			Timestamp exam_end = new Timestamp(exam_begin.getTime() + MyType.CHAPTER_TEST_TIME);
			//设置参数
			prestmt.setString(1, "第"+chapter+"章节随机测试");
			prestmt.setTimestamp(2, exam_begin);
			prestmt.setTimestamp(3, exam_end);
			prestmt.setInt(4, chapter);
			//执行插入语句接收插入更新条目数
			int ins = prestmt.executeUpdate();
			if(ins == 0) {
				System.err.println("更新值为0");
			}
			//再执行查询语句查询插入的自增id
			prestmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			//执行插入语句再利用结果集接收查询结果
			res = prestmt.executeQuery();
			if(res.next()) {
				int exam_id = res.getInt("LAST_INSERT_ID()");
				vo.setUser_id(1);
				vo.setExam_id(exam_id);
				vo.setExam_name("章节随机测试");
				vo.setExam_begin(exam_begin);
				vo.setExam_end(exam_end);
				vo.setChapter(chapter);
			}else {
				System.err.println(Ca+"Not random ID created ");
			}
		}catch(SQLException e) {
			throw new DaoException("考试信息查询异常", e);
		}finally {
			try {
				prestmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		ExaminationDao dao = new ExaminationDaoImpl(conn);
		dao.addExam(6);
		DBUtils.closeConnection(conn);
	}
	@Override
	public ExaminationVO getExamById(int exam_id) {
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		ExaminationVO vo = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT `exam_id`, `user_id`, `Exam_name`, `Exam_begin`, `Exam_end`, `chapter` FROM `examination` WHERE exam_id = ?");
			prestmt.setInt(1,exam_id);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				//数据库模型
				vo = new ExaminationVO();
				vo.setExam_id(rs.getInt("exam_id"));
				vo.setUser_id(rs.getInt("user_id"));
				vo.setExam_name(rs.getString("exam_name"));
				vo.setExam_begin(rs.getTimestamp("exam_begin"));
				vo.setExam_end(rs.getTimestamp("exam_end"));
				vo.setChapter(rs.getInt("chapter"));
			}else {
				throw new Exception("查询考试的不存在");
			}
		}catch(Exception e) {
			System.err.println(Ca+e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return vo;
	}
	@Override
	public ExaminationVO getExamByAnsid(int ans_id) {
		//预编译对象
		PreparedStatement prestmt = null;
		//结果集
		ResultSet rs = null;
		ExaminationVO vo = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("SELECT e.exam_id, e.user_id, e.Exam_name, e.Exam_begin, "
					+ "e.Exam_end, e.chapter "
					+ "FROM examination e,answer a "
					+ "WHERE e.exam_id = a.Exam_id AND a.ans_id = ?");
			prestmt.setInt(1,ans_id);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空，不为空则提取查询结果集内容
			if(rs.next()) {
				//数据库模型
				vo = new ExaminationVO();
				vo.setExam_id(rs.getInt("exam_id"));
				vo.setUser_id(rs.getInt("user_id"));
				vo.setExam_name(rs.getString("exam_name"));
				vo.setExam_begin(rs.getTimestamp("exam_begin"));
				vo.setExam_end(rs.getTimestamp("exam_end"));
				vo.setChapter(rs.getInt("chapter"));
			}else {
				throw new Exception("查询考试的不存在");
			}
		}catch(Exception e) {
			System.err.println(Ca+e);
		}finally {
			DBUtils.closeStatement(rs, prestmt);
		}
		return vo;
	}
	
	@Override
	public List<ExamInfoPOJO> getExaminfoByUserid(int user_id) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		List<ExamInfoPOJO> list = new ArrayList<ExamInfoPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT e.exam_id, e.Exam_name, e.Exam_begin, e.Exam_end, IFNULL( m.finish_flag,'未完成') "
					+ "FROM examination e "
					+ "LEFT JOIN mission m "
					+ "ON m.exam_id = e.exam_id AND m.user_id = ? "
					+ "WHERE e.user_id != 1");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			while(rs.next()) {
				ExamInfoPOJO vo = new ExamInfoPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setExam_name(rs.getString(2));
				vo.setExam_begin(rs.getTimestamp(3));
				vo.setExam_end(rs.getTimestamp(4));
				vo.setFinish_flag(rs.getString(5));
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
	public List<ExamInfoPOJO> getExaminfoWithPage(int user_id, int pageNo, int pageSize) {
		PreparedStatement prep = null;
		//结果集
		ResultSet rs = null;
		List<ExamInfoPOJO> list = new ArrayList<ExamInfoPOJO>();
		try{
			//获取随机生成的试卷对象
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("SELECT e.exam_id, e.Exam_name, e.Exam_begin, e.Exam_end, IFNULL( m.finish_flag,'未完成') "
					+ "FROM examination e "
					+ "LEFT JOIN mission m "
					+ "ON m.exam_id = e.exam_id AND m.user_id = ? "
					+ "WHERE e.user_id != 1 "
					+ "LIMIT ?,?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);									
			prep.setInt(2, (pageNo-1)*pageSize);												
			prep.setInt(3, pageNo*pageSize);
			rs = prep.executeQuery();
			while(rs.next()) {
				ExamInfoPOJO vo = new ExamInfoPOJO();
				vo.setExam_id(rs.getInt(1));
				vo.setExam_name(rs.getString(2));
				vo.setExam_begin(rs.getTimestamp(3));
				vo.setExam_end(rs.getTimestamp(4));
				vo.setFinish_flag(rs.getString(5));
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
