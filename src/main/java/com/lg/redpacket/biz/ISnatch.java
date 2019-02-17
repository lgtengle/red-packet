package com.lg.redpacket.biz;

import com.lg.redpacket.common.BigDecimalUtils;

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
     * @param id 红包ID
     * @return 返回抢到的金额，如果为null，表示没有抢到
     */
    BigDecimal snatch(Integer id);

    /** 分钱
     * @param amount 金额
     * @param num 红包个数
     * @return 计算本次抢到红包的个数
     */
    default BigDecimal divide(BigDecimal amount, int num){
        //先将其他人的最少可以分到的钱预留出来
        BigDecimal ableDivide = amount.subtract(BigDecimalUtils.get((num - 1) * 0.01));

        if (ableDivide.compareTo(MIN_MONEY) == 0)
            return MIN_MONEY;
        else {

            Random random = new Random();
            int i = random.nextInt(ableDivide.multiply(BigDecimalUtils.get(100)).intValue());
            if (i == 0)
                return MIN_MONEY;
            else
                return new BigDecimal(i/100);

        }

    }

}

