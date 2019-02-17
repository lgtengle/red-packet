package com.lg.redpacket.model;

import java.math.BigDecimal;

/**
 * <p>
 * description:
 * </p>
 * Created on 2019/2/16 21:08
 *
 * @author leiguang
 */
public class Person {

    /**
     * id
     */
    private Integer id;

    /**
     * 人名
     */
    private String name;

    /**
     * 余额
     */
    private BigDecimal amount;

    public Person(){}

    public Person(Integer id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount.setScale(2, BigDecimal.ROUND_DOWN) +
                '}';
    }
}
