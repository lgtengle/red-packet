package com.lg.redpacket.biz;

import com.lg.redpacket.model.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * description: Java同步方式抢红包实现类
 * </p>
 * Created on 2019/2/16 21:41
 *
 * @author leiguang
 */
@Service
public class SynchSnatchImpl implements ISnatch {


    @Autowired
    RedPacketService redPacketService;

    @Override
    public BigDecimal snatch(Integer id) {
        RedPacket redPacket = redPacketService.get(id);

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
