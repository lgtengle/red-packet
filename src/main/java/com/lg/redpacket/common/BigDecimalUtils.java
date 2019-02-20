package com.lg.redpacket.common;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * <p>
 * description: bigdecimal工具类
 * </p>
 * Created on 2019/2/17 12:13
 *
 * @author leiguang
 */
public class BigDecimalUtils {

    public static final MathContext mc = new MathContext(2, RoundingMode.DOWN);

    public static BigDecimal get(int i){
        return new BigDecimal(i);
    }

    public static BigDecimal get(double i){
        return BigDecimal.valueOf(i);
    }


    public static BigDecimal get(BigDecimal bigDecimal){
        return bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public static void main(String[] args){
        System.out.println(BigDecimalUtils.get((4 - 1) * 0.01));
    }
}
