package en.edu.lingnan.Dto;

public class UserInformationDTO {
	String UserID=null;
	String UserName=null;
	String UserSex=null;
	String UserPsw=null;
	int UserAuth;
	int UIflag;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserPsw() {
		return UserPsw;
	}
	public void setUserPsw(String userPsw) {
		UserPsw = userPsw;
	}
	public int getUserAuth() {
		return UserAuth;
	}
	public void setUserAuth(int userAuth) {
		UserAuth = userAuth;
	}
	public int getUIflag() {
		return UIflag;
	}
	public void setUIflag(int uIflag) {
		UIflag = uIflag;
	}
	

}
