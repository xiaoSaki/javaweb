package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.TeamDao;
import com.neuedu.lvcity.model.TeamVO;



public class TeamDaoImpl implements TeamDao{
	/**
	 * 鏁版嵁搴撹繛鎺�
	 */
	private Connection conn;
	
	/**
	 * 鏋勯�犳柟娉曪紝浼犻�掓暟鎹簱杩炴帴瀵硅薄
	 * @param conn 鏁版嵁搴撹繛鎺ュ璞�
	 */
	public TeamDaoImpl(Connection conn){
		//缁欏睘鎬ц祴鍒濆鍖栧��
		this.conn = conn;
	}

	@Override
	public TeamVO findTeamById(int id) {
		//澹版槑缁撴灉闆嗗璞″彉閲忥紝鐢ㄤ簬淇濆瓨鏁版嵁搴撴煡璇㈢粨鏋�
		ResultSet rs = null;
		//澹版槑棰勭紪璇戠殑澹版槑瀵硅薄鍙橀噺锛岀敤浜庤繘琛屾暟鎹簱鎿嶄綔鐨勮浇浣�
		PreparedStatement pstam = null;
		//澹版槑Banar鍙橀噺锛岀敤浜庝繚瀛樼粨鏋滈泦涓彁鍙栧嚭鏉ョ殑鏁版嵁
		TeamVO teamvo =null;
		try {
			//璋冪敤杩炴帴瀵硅薄鐨凱reparedStatement鏂规硶锛屽緱鍒伴缂栬瘧瀵硅薄锛岃祴鍊肩粰棰勭紪璇戝璞″彉閲�
			pstam = conn.prepareStatement("select * from team where teamid = ? ");
			pstam.setInt(1, id);
			//璋冪敤棰勭紪璇戝璞＄殑executeQuery鏂规硶锛屾墽琛屾煡璇㈡搷浣滐紝杩斿洖鏌ヨ缁撴灉锛岃祴鍊肩粰缁撴灉闆嗗璞″彉閲�
			rs = pstam.executeQuery();
			//濡傛灉鏌ヨ缁撴灉涓嶄负绌猴紝灏嗗彇鍑虹粨鏋滈泦涓殑鍚勪釜瀛楁锛屽皝瑁呭湪鐢ㄦ埛瀵硅薄鐨勫悇涓睘鎬т腑
			while(rs.next()){
				//鍒涘缓涓�涓柊鐢ㄦ埛瀵硅薄锛岃祴鍊肩粰鐢ㄦ埛瀵硅薄鍙橀噺
				teamvo = new TeamVO();
				/*
				 * 璋冪敤缁撴灉闆嗗璞＄殑getXxx鏂规硶锛屽彇鍑哄悇涓瓧娈电殑鍊�
				 * 鐒跺悗鍐嶈皟鐢ㄧ敤鎴峰璞＄殑setXxx鏂规硶锛岀粰灞炴�ц祴鍊�
				 * 鏈�鍚庢柊鍒涘缓鐨勫璞′腑鍖呭惈浜嗘煡璇㈢粨鏋滀腑鐨勬墍鏈夊瓧娈电殑鍊�
				 */
				teamvo.setTeamid(rs.getInt("teamid"));
				teamvo.setContent(rs.getString("content"));
			}
		} 
		//缁撴灉鍑虹幇寮傚父锛岃緭鍑哄紓甯镐俊鎭�
		catch (SQLException e) {
			System.out.println("鍦ㄦ煡璇indTeamById淇℃伅鏃跺嚭閿欎簡锛岄敊璇俊鎭槸锛�" + e.getMessage());
			// 灏嗗紓甯稿皝瑁呮垚鑷畾涔夊紓甯�
			
		}finally{
			//璋冪敤鏁版嵁搴撳伐鍏风被锛屽叧闂粨鏋滈泦瀵硅薄鍜屽０鏄庡璞�
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 鏈�鍚庯紝杩斿洖鐢ㄦ埛瀵硅薄锛屽鏋滄煡璇㈢粨鏋滀笉涓虹┖锛岃瀵硅薄涓皝瑁呬簡鏌ヨ缁撴灉涓殑鏁版嵁
		 * 濡傛灉鏌ヨ缁撴灉涓虹┖锛岃瀵硅薄涓虹┖鍊糿ull
		 */
		return teamvo;
	}
}

