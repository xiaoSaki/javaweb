package po;

public class Bom {
    private String mid;

    private String productmid;

    private Integer type;

    private Double pnum;

    private Integer layer;

    private Integer procno;

    private String procname;

    private String place;

    private Double maketime;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getProductmid() {
        return productmid;
    }

    public void setProductmid(String productmid) {
        this.productmid = productmid == null ? null : productmid.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getPnum() {
        return pnum;
    }

    public void setPnum(Double pnum) {
        this.pnum = pnum;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getProcno() {
        return procno;
    }

    public void setProcno(Integer procno) {
        this.procno = procno;
    }

    public String getProcname() {
        return procname;
    }

    public void setProcname(String procname) {
        this.procname = procname == null ? null : procname.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Double getMaketime() {
        return maketime;
    }

    public void setMaketime(Double maketime) {
        this.maketime = maketime;
    }
}