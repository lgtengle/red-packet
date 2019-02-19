package com.lg.redpacket.biz;

import com.lg.redpacket.common.BigDecimalUtils;
import com.lg.redpacket.model.Person;
import com.lg.redpacket.model.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * description:
 * </p>
 * Created on 2019/2/16 21:42
 *
 * @author leiguang
 */
@Service
public class RedPacketService {

    private AtomicInteger atoRedId = new AtomicInteger(0);

    @Autowired
    ISend iSend;

    /**
     * 创建红包
     * @param amount 发送红包的金额
     * @param num    红包个数
     * @param desc 红包描述
     * @param person 个人信息
     * @return 返回红包ID，大于0表示成功
     */
    public int create(BigDecimal amount, int num, String desc, Person person) throws Exception {


        //判断是否符合发送红包的条件
        if (person.getAmount().compareTo(BigDecimal.ZERO) == 0 ||
                person.getAmount().compareTo(amount) < 0){
            throw new Exception("余额不足");
        }

        //每个人最少分0.01
        if (amount.compareTo(BigDecimalUtils.get(num * 0.01)) < 0){
            throw new Exception("每个人最少分0.01");
        }

        int id = atoRedId.incrementAndGet();
        try {
            //以下应该是原子操作

            //生成红包记录
            RedPacket redPacket = new RedPacket(id, person.getId(), person.getName(), amount, amount, num, desc);
            if (iSend.send(redPacket)) {
                //减去发红包人账户中的钱
                person.setAmount(person.getAmount().subtract(amount));
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        //TODO 通知所有人抢红包了

        return id;
    }

}
