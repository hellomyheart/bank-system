package com.qfedu.vo;

import java.util.Date;
import java.util.Objects;

/**
 * @description
 * @className: VTradeInfo
 * @package: com.qfedu.vo
 * @author: Stephen Shen
 * @date: 2020/9/9 下午3:41
 */
public class VTradeInfo {
    private Date createTime;
    private Double pay;
    private Double income;
    private Double balance;
    private String comment;
    private String consumType;

    @Override
    public String toString() {
        return "VTradeInfo{" +
                "createTime=" + createTime +
                ", pay=" + pay +
                ", income=" + income +
                ", balance=" + balance +
                ", comment='" + comment + '\'' +
                ", consumType='" + consumType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VTradeInfo that = (VTradeInfo) o;
        return Objects.equals(createTime, that.createTime) &&
                Objects.equals(pay, that.pay) &&
                Objects.equals(income, that.income) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(consumType, that.consumType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createTime, pay, income, balance, comment, consumType);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConsumType() {
        return consumType;
    }

    public void setConsumType(String consumType) {
        this.consumType = consumType;
    }
}
