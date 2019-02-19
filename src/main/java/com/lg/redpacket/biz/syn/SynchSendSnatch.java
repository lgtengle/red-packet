package com.lg.redpacket.biz.syn;

import com.lg.redpacket.biz.ISend;
import com.lg.redpacket.biz.ISnatch;
import com.lg.redpacket.biz.RedPacketService;
import com.lg.redpacket.model.Person;
import com.lg.redpacket.model.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    RedPacketService redPacketService;

    @Override
    public boolean send(RedPacket redPacket) {
        redPacketMap.put(redPacket.getId(), redPacket);
        return true;
    }

    @Override
    public BigDecimal snatch(RedPacket redPacket) {
        if (redPacket.getLeftAmount().compareTo(MIN_MONEY) >= 0) {
            synchronized (redPacket) {
                if (redPacket.getLeftAmount().compareTo(MIN_MONEY) >= 0) {
                    BigDecimal divide = divide(redPacket.getLeftAmount(), redPacket.getLeftNum());
                    redPacket.setLeftAmount(redPacket.getLeftAmount().subtract(divide));
                    redPacket.setLeftNum(redPacket.getLeftNum()-1);
                    return divide;
                }else
                    return null;
            }
        }
        return null;
    }
}
