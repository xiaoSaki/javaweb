package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdmTeamDao;
import com.neuedu.lvcity.dao.TeamDao;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.TeamVO;



public class AdmTeamDaoImpl implements AdmTeamDao{

	private Connection conn;
	
	public AdmTeamDaoImpl(Connection conn){
		
		this.conn = conn;
	}

	@Override
	public TeamVO findTeamByid(int teamid) {
		
		ResultSet rs = null;
	
		PreparedStatement pstam = null;

		TeamVO teamvo  =null;
		try {
			
			pstam = conn.prepareStatement("select * from team where teamid = ? ");
			pstam.setInt(1, teamid);
			rs = pstam.executeQuery();
			while(rs.next()){
				teamvo = new TeamVO();
				teamvo.setTeamid(rs.getInt("teamid"));
				teamvo.setContent(rs.getString("content"));
			}
		} 
	
		catch (SQLException e) {
			System.out.println("鍦ㄦ煡璇indTeamById淇℃伅鏃跺嚭閿欎簡锛岄敊璇俊鎭槸锛�" + e.getMessage());
	
			
		}finally{
		
			DBUtils.closeStatement(rs, pstam);
		}

		return teamvo;
	}

	@Override
	public List<TeamVO> findTeam() {
		ResultSet rs = null;
		List<TeamVO> list  = new ArrayList<TeamVO>();
		PreparedStatement pstam = null;

		TeamVO teamvo =null;
		try {
			
			pstam = conn.prepareStatement("select * from team ");
			rs = pstam.executeQuery();
			while(rs.next()){
				teamvo = new TeamVO();
				teamvo.setTeamid(rs.getInt("teamid"));
				teamvo.setContent(rs.getString("content"));
				list.add(teamvo);
			}
		} 
	
		catch (SQLException e) {
			System.out.println("在查询队伍的时候出错了.错误信息是 ：" + e.getMessage());			
	
			
		}finally{
		
			DBUtils.closeStatement(rs, pstam);
		}

		return list;
	}

	@Override
	public boolean deleteTeam(int teamid) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("delete from team where teamid = ?");
			pstam.setInt(1, teamid);
			int i =pstam.executeUpdate();
			if(i>0)
				flag=true;
			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在删除队伍team的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	@Override
	public boolean addTeam(TeamVO teamVO) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("insert into team (content) values(?) ");
			pstam.setString(1, teamVO.getContent());
			int i = pstam.executeUpdate();
			if(i>0){
				flag = true;
			}
//			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}

	
	@Override
	public boolean updateTeam(TeamVO TeamVO) {
		boolean flag = false;
		PreparedStatement pstam = null;
		try {
			pstam = conn.prepareStatement("update team set content=? where teamid=? ");
			pstam.setString(1, TeamVO.getContent());
			pstam.setInt(2, TeamVO.getTeamid());
			int i = pstam.executeUpdate();
			System.out.print("kkkkkk"+i);
			if(i>0){
				flag = true;
			}
			System.out.println("i值测试"+i);
		} catch (SQLException e) {
			System.out.println("在更新队伍Team的时候出错了.错误信息是 ：" + e.getMessage());
		} finally {
			DBUtils.closeStatement(null, pstam);
		}
		return flag;
	}
}

