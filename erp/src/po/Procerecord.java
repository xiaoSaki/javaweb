package po;

import java.util.Date;

public class Procerecord {
    private String prid;

    private String mid;

    private Integer mnum;

    private String allmaterial;

    private Integer procno;

    private Date prdate;

    private Integer producetime;

    private String place;

    private String eid;

    private String grade;

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid == null ? null : prid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getMnum() {
        return mnum;
    }

    public void setMnum(Integer mnum) {
        this.mnum = mnum;
    }

    public String getAllmaterial() {
        return allmaterial;
    }

    public void setAllmaterial(String allmaterial) {
        this.allmaterial = allmaterial == null ? null : allmaterial.trim();
    }

    public Integer getProcno() {
        return procno;
    }

    public void setProcno(Integer procno) {
        this.procno = procno;
    }

    public Date getPrdate() {
        return prdate;
    }

    public void setPrdate(Date prdate) {
        this.prdate = prdate;
    }

    public Integer getProducetime() {
        return producetime;
    }

    public void setProducetime(Integer producetime) {
        this.producetime = producetime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}