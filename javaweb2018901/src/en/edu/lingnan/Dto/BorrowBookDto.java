package en.edu.lingnan.Dto;

public class BorrowBookDto {
	public String BorrowBookid;
	public String Bbid;
	public String Bcid;
	public String Borrowtime;
	public String Breturntime;
	public String Bduetime;
	public String Breturnstate;
	public int bbflag;
	public int Bmun;
	public double bfine;
	
	public String getBorrowBookid() {
		return BorrowBookid;
	}
	public void setBorrowBookid(String borrowBookid) {
		BorrowBookid = borrowBookid;
	}
	public String getBbid() {
		return Bbid;
	}
	public void setBbid(String bbid) {
		Bbid = bbid;
	}
	public String getBcid() {
		return Bcid;
	}
	public void setBcid(String bcid) {
		Bcid = bcid;
	}
	public String getBorrowtime() {
		return Borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		Borrowtime = borrowtime;
	}
	public String getBreturntime() {
		return Breturntime;
	}
	public void setBreturntime(String breturntime) {
		Breturntime = breturntime;
	}
	public String getBduetime() {
		return Bduetime;
	}
	public void setBduetime(String bduetime) {
		Bduetime = bduetime;
	}
	public String getBreturnstate() {
		return Breturnstate;
	}
	public void setBreturnstate(String breturnstate) {
		Breturnstate = breturnstate;
	}
	public int getBbflag() {
		return bbflag;
	}
	public void setBbflag(int bbflag) {
		this.bbflag = bbflag;
	}
	public int getBmun() {
		return Bmun;
	}
	public void setBmun(int bmun) {
		Bmun = bmun;
	}
	public double getBfine() {
		return bfine;
	}
	public void setBfine(double bfine) {
		this.bfine = bfine;
	}
	
	
	
}

