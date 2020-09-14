package com.qfedu.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @description
 * @className: Trade
 * @package: com.qfedu.entity
 * @author: Stephen Shen
 * @date: 2020/9/14 下午5:07
 */
public class Trade {
    private Integer id;
    private Integer uid;
    private Integer otherUid;
    private Double money;
    private Date createTime;
    private Double balance;
    private String comment;
    private String consumType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equals(id, trade.id) &&
                Objects.equals(uid, trade.uid) &&
                Objects.equals(otherUid, trade.otherUid) &&
                Objects.equals(money, trade.money) &&
                Objects.equals(createTime, trade.createTime) &&
                Objects.equals(balance, trade.balance) &&
                Objects.equals(comment, trade.comment) &&
                Objects.equals(consumType, trade.consumType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, otherUid, money, createTime, balance, comment, consumType);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOtherUid() {
        return otherUid;
    }

    public void setOtherUid(Integer otherUid) {
        this.otherUid = otherUid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
