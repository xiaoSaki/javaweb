package com.neuedu.lvcity.service.impl;

import java.sql.Connection;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.TeamDao;
import com.neuedu.lvcity.dao.impl.TeamDaoImpl;
import com.neuedu.lvcity.model.TeamVO;
import com.neuedu.lvcity.service.TeamService;



public class TeamServiceImpl implements TeamService{

	/**
	 * 绫诲疄渚�
	 */
	private static final  TeamService instance = new TeamServiceImpl();

	/**
	 * 鍙栧緱瀹炰緥
	 * @return 瀹炰緥瀵硅薄
	 */
	public static TeamService getInstance() {
		return instance;
	}

	/**
	 * 鏋勯�犳柟娉�
	 */
	private TeamServiceImpl() {
	}

	@Override
	public TeamVO findTeamById(int id) {
		//澹版槑鏁版嵁搴撹繛鎺ュ璞★紝鐢ㄤ簬淇濆瓨鏁版嵁搴撹繛鎺ュ璞�
		Connection conn = null;
		//澹版槑鍙橀噺锛岀敤浜庝繚瀛樻暟鎹簱鏌ヨ缁撴灉
		TeamVO team = new TeamVO();
		try{
			//璋冪敤鏁版嵁搴撳伐鍏风被鐨刧etConnection鏂规硶锛屽彇寰楁暟鎹簱杩炴帴瀵硅薄锛屽苟璧嬪�肩粰鏁版嵁搴撹繛鎺ュ璞″彉閲�
			conn = DBUtils.getConnection();
			//鍒涘缓ArticleDao鐨勫疄鐜扮被瀵硅薄
			TeamDao adminDao = new TeamDaoImpl(conn);
			//璋冪敤dao涓殑findHistoryArticle鏂规硶锛岃繘琛屾暟鎹簱鏌ヨ鎿嶄綔锛岀粨鏋滆祴鍊肩粰鏌ヨ缁撴灉鍙橀噺
			team = adminDao.findTeamById(id);
		
		} catch (Exception e) {
			//灏嗗紓甯稿皝瑁呮垚鑷畾涔夊紓甯稿苟鎶涘嚭
			
		} finally {
			//璋冪敤鏁版嵁搴撳伐鍏风被鐨刢loseConnection鏂规硶锛屽叧闂繛鎺�
			DBUtils.closeConnection(conn);
		}
		//杩斿洖鏁版嵁搴撴煡璇㈢粨鏋�
		return team;
	}

}