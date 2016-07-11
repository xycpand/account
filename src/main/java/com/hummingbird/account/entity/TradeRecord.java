package com.hummingbird.account.entity;

import java.util.Date;

/**
 * 系统资金交易记录
 */
public class TradeRecord {
    private Integer id;

    /**
     * 流水号
     */
    private String serialno;

    /**
     * 支付账号
     */
    private String payno;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 交易时间
     */
    private Date tradetime;

    /**
     * 交易类型
     */
    private String tradetype;

    /**
     * 交易币种
     */
    private String tradecurrency;

    /**
     * 插入时间
     */
    private Date inserttime;

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
     * @return 支付账号
     */
    public String getPayno() {
        return payno;
    }

    /**
     * @param payno 
	 *            支付账号
     */
    public void setPayno(String payno) {
        this.payno = payno == null ? null : payno.trim();
    }

    /**
     * @return 交易金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            交易金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return 交易时间
     */
    public Date getTradetime() {
        return tradetime;
    }

    /**
     * @param tradetime 
	 *            交易时间
     */
    public void setTradetime(Date tradetime) {
        this.tradetime = tradetime;
    }

    /**
     * @return 交易类型
     */
    public String getTradetype() {
        return tradetype;
    }

    /**
     * @param tradetype 
	 *            交易类型
     */
    public void setTradetype(String tradetype) {
        this.tradetype = tradetype == null ? null : tradetype.trim();
    }

    /**
     * @return 交易币种
     */
    public String getTradecurrency() {
        return tradecurrency;
    }

    /**
     * @param tradecurrency 
	 *            交易币种
     */
    public void setTradecurrency(String tradecurrency) {
        this.tradecurrency = tradecurrency == null ? null : tradecurrency.trim();
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
        TradeRecord other = (TradeRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getPayno() == null ? other.getPayno() == null : this.getPayno().equals(other.getPayno()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getTradetime() == null ? other.getTradetime() == null : this.getTradetime().equals(other.getTradetime()))
            && (this.getTradetype() == null ? other.getTradetype() == null : this.getTradetype().equals(other.getTradetype()))
            && (this.getTradecurrency() == null ? other.getTradecurrency() == null : this.getTradecurrency().equals(other.getTradecurrency()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getPayno() == null) ? 0 : getPayno().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getTradetime() == null) ? 0 : getTradetime().hashCode());
        result = prime * result + ((getTradetype() == null) ? 0 : getTradetype().hashCode());
        result = prime * result + ((getTradecurrency() == null) ? 0 : getTradecurrency().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        return result;
    }
}