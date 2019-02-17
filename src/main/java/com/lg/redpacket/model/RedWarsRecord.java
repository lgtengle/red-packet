package com.lg.redpacket.model;

import java.math.BigDecimal;

/**
 * <p>
 * description:
 * </p>
 * Created on 2019/2/16 21:15
 *
 * @author leiguang
 */
public class RedWarsRecord {

    private Integer redPacketId;

    private Integer personId;

    /**
     * 抢到的金额
     */
    private BigDecimal amount;

    @Override
    public String toString() {
        return "RedWarsRecord{" +
                "redPacketId=" + redPacketId +
                ", personId=" + personId +
                ", amount=" + amount +
                '}';
    }
}
