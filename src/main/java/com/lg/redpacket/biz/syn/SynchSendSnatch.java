package com.lg.redpacket.biz.syn;

import com.lg.redpacket.biz.ISend;
import com.lg.redpacket.biz.ISnatch;
import com.lg.redpacket.biz.RedPacketService;
import com.lg.redpacket.common.BigDecimalUtils;
import com.lg.redpacket.model.Person;
import com.lg.redpacket.model.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>
 * description:
 * </p>
 *
 * @author leiguang
 * @version 0.1.0
 * @date 2019-02-19 15:48
 */
@Service
public class SynchSendSnatch implements ISnatch, ISend {

    public static Map<Integer, RedPacket> redPacketMap = new HashMap<>();

    /**
     * 红包阻塞队列
     */
    public static BlockingDeque<Integer> REDPACKET_MESSAGE = new LinkedBlockingDeque<>();

    @Autowired
    RedPacketService redPacketService;

    @Override
    public boolean send(RedPacket redPacket) {
        int id = redPacket.getId();
        redPacketMap.put(id, redPacket);
        REDPACKET_MESSAGE.add(id);
        return true;
    }

    @Override
    public BigDecimal snatch(RedPacket redPacket) {
        if (redPacket.getLeftAmount().compareTo(MIN_MONEY) >= 0) {
            synchronized (redPacket) {
                Integer leftNum = redPacket.getLeftNum();
                if (redPacket.getLeftAmount().compareTo(MIN_MONEY) >= 0 && leftNum > 0) {
                    BigDecimal divide = null;
                    if (leftNum != 1){
                        //先将其他人的最少可以分到的钱预留出来
                        BigDecimal ableDivide = redPacket.getLeftAmount().subtract(BigDecimalUtils.get((leftNum - 1) * 0.01));
                        divide = BigDecimalUtils.get(this.divide(ableDivide));
                    }else
                        divide = redPacket.getLeftAmount();

                    redPacket.setLeftAmount(redPacket.getLeftAmount().subtract(divide));
                    redPacket.setLeftNum(leftNum -1);
                    return divide;
                }else
                    return null;
            }
        }
        return null;
    }
}
