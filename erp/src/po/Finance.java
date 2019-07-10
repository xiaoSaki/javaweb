package po;

import java.math.BigDecimal;
import java.util.Date;

public class Finance {
    private String fid;

    private String detail;

    private BigDecimal fmoney;

    private Date fdate;

    private String earnorpay;

    private String type;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public BigDecimal getFmoney() {
        return fmoney;
    }

    public void setFmoney(BigDecimal fmoney) {
        this.fmoney = fmoney;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getEarnorpay() {
        return earnorpay;
    }

    public void setEarnorpay(String earnorpay) {
        this.earnorpay = earnorpay == null ? null : earnorpay.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}