package com.lg.redpacket.biz;

import com.lg.redpacket.common.BigDecimalUtils;
import com.lg.redpacket.model.RedPacket;

import java.math.BigDecimal;
import java.util.Random;

/**
 * <p>
 * description: 抢红包接口
 * </p>
 * Created on 2019/2/16 21:39
 *
 * @author leiguang
 */
public interface ISnatch {

    BigDecimal MIN_MONEY  = BigDecimalUtils.get(0.01);

    /**
     *
     * @param redPacket 红包
     * @return 返回抢到的金额，如果为null，表示没有抢到
     */
    BigDecimal snatch(RedPacket redPacket);

    /** 分钱
     * @param amount 金额
     * @return 计算本次抢到红包的个数
     */
    default BigDecimal divide(BigDecimal amount){

        if (amount.compareTo(MIN_MONEY) == 0)
            return MIN_MONEY;
        else {

            Random random = new Random();
            double max = amount.doubleValue();
            double i = random.nextDouble();
            if (i == 0)
                return MIN_MONEY;
            else
                return BigDecimalUtils.get(max * i);

        }

    }

}

