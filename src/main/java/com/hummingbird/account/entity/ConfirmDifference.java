package com.hummingbird.account.entity;

import java.util.Date;

/**
 * 记录对账差异
 */
public class ConfirmDifference {
    private Integer id;

    /**
     * 流水号
     */
    private String serialno;

    /**
     * 差异类型
     */
    private String differencetype;

    /**
     * 差异金额
     */
    private Long differenceamount;

    /**
     * 插入时间
     */
    private Date inserttime;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * @param serialno 
	 *            流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    /**
     * @return 差异类型
     */
    public String getDifferencetype() {
        return differencetype;
    }

    /**
     * @param differencetype 
	 *            差异类型
     */
    public void setDifferencetype(String differencetype) {
        this.differencetype = differencetype == null ? null : differencetype.trim();
    }

    /**
     * @return 差异金额
     */
    public Long getDifferenceamount() {
        return differenceamount;
    }

    /**
     * @param differenceamount 
	 *            差异金额
     */
    public void setDifferenceamount(Long differenceamount) {
        this.differenceamount = differenceamount;
    }

    /**
     * @return 插入时间
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * @param inserttime 
	 *            插入时间
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ConfirmDifference other = (ConfirmDifference) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getDifferencetype() == null ? other.getDifferencetype() == null : this.getDifferencetype().equals(other.getDifferencetype()))
            && (this.getDifferenceamount() == null ? other.getDifferenceamount() == null : this.getDifferenceamount().equals(other.getDifferenceamount()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getDifferencetype() == null) ? 0 : getDifferencetype().hashCode());
        result = prime * result + ((getDifferenceamount() == null) ? 0 : getDifferenceamount().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}