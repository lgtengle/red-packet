package com.lg.redpacket.model;

import java.math.BigDecimal;

/**
 * <p>
 * description:
 * </p>
 * Created on 2019/2/16 21:09
 *
 * @author leiguang
 */
public class RedPacket {

    private int id;

    private Integer personId;

    private String personName;

    /**
     * 红包金额
     */
    private BigDecimal amount;

    /**
     * 红包余额
     */
    private BigDecimal leftAmount;

    /**
     * 红包个数
     */
    private Integer num;


    /**
     * 红包剩下的个数
     */
    private Integer leftNum;
    /**
     * 红包描述
     */
    private String desc;



    public RedPacket(){}


    public RedPacket(int id, Integer personId, String personName, BigDecimal amount, BigDecimal leftAmount, Integer num, String desc) {
        this.id = id;
        this.personId = personId;
        this.personName = personName;
        this.amount = amount;
        this.leftAmount = leftAmount;
        this.num = num;
        this.desc = desc;
        this.leftNum = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(BigDecimal leftAmount) {
        this.leftAmount = leftAmount;
    }

    public Integer getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    @Override
    public String toString() {
        return "RedPacket{" +
                "id=" + id +
                ", personId=" + personId +
                ", personName='" + personName + '\'' +
                ", amount=" + amount +
                ", leftAmount=" + leftAmount +
                ", num=" + num +
                ", leftNum=" + leftNum +
                ", desc='" + desc + '\'' +
                '}';
    }
}
