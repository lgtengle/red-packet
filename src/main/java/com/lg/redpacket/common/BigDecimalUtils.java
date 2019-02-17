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

    public static final MathContext mc = new MathContext(5, RoundingMode.DOWN);

    public static BigDecimal get(int i){
        return new BigDecimal(i, mc);
    }

    public static BigDecimal get(double i){
        return new BigDecimal(i, mc);
    }


}
