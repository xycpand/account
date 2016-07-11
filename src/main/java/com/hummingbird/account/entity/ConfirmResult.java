package com.hummingbird.account.entity;

import java.util.Date;

/**
 * 对账结果
 */
public class ConfirmResult {
    private Integer id;

    /**
     * 商户账号
     */
    private String accountno;

    /**
     * 对账时间
     */
    private Date confirmtime;

    /**
     * 对账结果
     */
    private String confirmresult;

    /**
     * 交易币种
     */
    private String tradecurrency;

    /**
     * 交易类型
     */
    private String tradetype;

    /**
     * 交易笔数
     */
    private Integer tradenum;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 手续费
     */
    private Long charge;

    /**
     * 资金清算差额
     */
    private Long clearingbalance;

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
     * @return 商户账号
     */
    public String getAccountno() {
        return accountno;
    }

    /**
     * @param accountno 
	 *            商户账号
     */
    public void setAccountno(String accountno) {
        this.accountno = accountno == null ? null : accountno.trim();
    }

    /**
     * @return 对账时间
     */
    public Date getConfirmtime() {
        return confirmtime;
    }

    /**
     * @param confirmtime 
	 *            对账时间
     */
    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    /**
     * @return 对账结果
     */
    public String getConfirmresult() {
        return confirmresult;
    }

    /**
     * @param confirmresult 
	 *            对账结果
     */
    public void setConfirmresult(String confirmresult) {
        this.confirmresult = confirmresult == null ? null : confirmresult.trim();
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
     * @return 交易笔数
     */
    public Integer getTradenum() {
        return tradenum;
    }

    /**
     * @param tradenum 
	 *            交易笔数
     */
    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
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
     * @return 手续费
     */
    public Long getCharge() {
        return charge;
    }

    /**
     * @param charge 
	 *            手续费
     */
    public void setCharge(Long charge) {
        this.charge = charge;
    }

    /**
     * @return 资金清算差额
     */
    public Long getClearingbalance() {
        return clearingbalance;
    }

    /**
     * @param clearingbalance 
	 *            资金清算差额
     */
    public void setClearingbalance(Long clearingbalance) {
        this.clearingbalance = clearingbalance;
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
        ConfirmResult other = (ConfirmResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccountno() == null ? other.getAccountno() == null : this.getAccountno().equals(other.getAccountno()))
            && (this.getConfirmtime() == null ? other.getConfirmtime() == null : this.getConfirmtime().equals(other.getConfirmtime()))
            && (this.getConfirmresult() == null ? other.getConfirmresult() == null : this.getConfirmresult().equals(other.getConfirmresult()))
            && (this.getTradecurrency() == null ? other.getTradecurrency() == null : this.getTradecurrency().equals(other.getTradecurrency()))
            && (this.getTradetype() == null ? other.getTradetype() == null : this.getTradetype().equals(other.getTradetype()))
            && (this.getTradenum() == null ? other.getTradenum() == null : this.getTradenum().equals(other.getTradenum()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCharge() == null ? other.getCharge() == null : this.getCharge().equals(other.getCharge()))
            && (this.getClearingbalance() == null ? other.getClearingbalance() == null : this.getClearingbalance().equals(other.getClearingbalance()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountno() == null) ? 0 : getAccountno().hashCode());
        result = prime * result + ((getConfirmtime() == null) ? 0 : getConfirmtime().hashCode());
        result = prime * result + ((getConfirmresult() == null) ? 0 : getConfirmresult().hashCode());
        result = prime * result + ((getTradecurrency() == null) ? 0 : getTradecurrency().hashCode());
        result = prime * result + ((getTradetype() == null) ? 0 : getTradetype().hashCode());
        result = prime * result + ((getTradenum() == null) ? 0 : getTradenum().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCharge() == null) ? 0 : getCharge().hashCode());
        result = prime * result + ((getClearingbalance() == null) ? 0 : getClearingbalance().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}