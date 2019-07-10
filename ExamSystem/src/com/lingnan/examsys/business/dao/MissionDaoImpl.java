package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class MissionDaoImpl implements MissionDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public MissionDaoImpl(Connection conn) {
		this.conn = conn;
	}
	public boolean insertMission(int exam_id, int user_id) {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into mission(exam_id,user_id) values (?,?)");
			ps.setInt(1, exam_id);
			ps.setInt(2, user_id);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
				System.out.println("第一步：添加试卷任务表成功");
			} else {
				flag = false;
				System.out.println("添加试卷任务表失败");
			}
		} catch (SQLException e) {
			throw new DaoException("1.添加试卷任务表失败", e);
		} finally {
			DBUtils.closeStatement(null, ps);
		}
		return flag;
	}
	
	public int updateMission(int ans_id, int user_id) {
		PreparedStatement prep = null;
		int update = 0;
		try {
			prep = conn.prepareStatement("UPDATE `mission` SET `finish_flag` = '完成' "
					+ "WHERE Exam_id = (SELECT Exam_id FROM answer WHERE ans_id = ?) "
					+ "AND user_id = ?");
			prep.setInt(1, ans_id);
			prep.setInt(2, user_id);
			update = prep.executeUpdate();
			if(update==0) throw new Exception("更新Mission记录失败！");
		}catch(Exception e){
			System.err.println(Ca+e.getMessage());
		}finally{
			DBUtils.closeStatement2(prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return update;
	}
}
