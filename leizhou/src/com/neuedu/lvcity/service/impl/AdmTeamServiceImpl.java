package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdmTeamDao;
import com.neuedu.lvcity.dao.impl.AdmTeamDaoImpl;
import com.neuedu.lvcity.model.TeamVO;
import com.neuedu.lvcity.service.AdmNoticeTypeService;
import com.neuedu.lvcity.service.AdmTeamService;
import com.neuedu.lvcity.service.ArticleService;

public class AdmTeamServiceImpl implements AdmTeamService{

	@Override
	public List<TeamVO> findTeamVO() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<TeamVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmTeamDao admTeamVODao = new AdmTeamDaoImpl(conn);
			list  = admTeamVODao.findTeam();
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有team错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return list;				
	}

	@Override
	public boolean deleteTeamVO(int teamid) {
		boolean flag = false;
		Connection conn = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmTeamDao admTeamVODao = new AdmTeamDaoImpl(conn);
			flag = admTeamVODao.deleteTeam(teamid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("删除所有team错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean addTeamVO(TeamVO teamVO) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmTeamDao admTeamVODao = new AdmTeamDaoImpl(conn);
			flag = admTeamVODao.addTeam(teamVO);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加所有Team错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	

	@Override
	public boolean updateTeamVO(TeamVO teamVO ) {
		Connection conn = null;
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmTeamDao admTeamVODao = new AdmTeamDaoImpl(conn);
			flag = admTeamVODao.updateTeam(teamVO);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新所有team错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public TeamVO findTeamVOByid(int teamid) {
		Connection conn = null;
		TeamVO teamVo = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdmTeamDao admTeamVODao = new AdmTeamDaoImpl(conn);
			teamVo = admTeamVODao.findTeamByid(teamid);
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询team错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		return teamVo;
	}

}
