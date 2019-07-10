package po;

import java.util.Date;

public class Orders {
    private String oid;

    private String mid;

    private String eid;

    private Integer num;

    private Double omeney;

    private String buyer;

    private String handlerx;

    private String tel;

    private Date buydate;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getOmeney() {
        return omeney;
    }

    public void setOmeney(Double omeney) {
        this.omeney = omeney;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getHandlerx() {
        return handlerx;
    }

    public void setHandlerx(String handlerx) {
        this.handlerx = handlerx == null ? null : handlerx.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }
}