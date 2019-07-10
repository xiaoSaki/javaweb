package po;

public class Material {
    private String mid;

    private String mname;

    private String size;

    private String place;

    private Double perprice;

    private Integer num;

    private Integer isbuy;

    private Integer issell;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Double getPerprice() {
        return perprice;
    }

    public void setPerprice(Double perprice) {
        this.perprice = perprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIsbuy() {
        return isbuy;
    }

    public void setIsbuy(Integer isbuy) {
        this.isbuy = isbuy;
    }

    public Integer getIssell() {
        return issell;
    }

    public void setIssell(Integer issell) {
        this.issell = issell;
    }
}