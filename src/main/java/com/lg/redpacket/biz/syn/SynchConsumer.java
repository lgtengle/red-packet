package com.lg.redpacket.biz.syn;

import com.lg.redpacket.biz.ISnatch;
import com.lg.redpacket.model.Person;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * <p>
 * description: 红包消费者
 * </p>
 *
 * @author leiguang
 * @version 0.1.0
 * @date 2019-02-19 16:06
 */
public class SynchConsumer implements Runnable{

    private HashSet<Integer> snatched = new HashSet();

    private Person person;

    ISnatch iSnatch;

    public SynchConsumer(Person person, ISnatch iSnatch) {
        this.person = person;
        this.iSnatch = iSnatch;
    }

    @Override
    public void run() {
        while (true){
            //System.err.println("===我要抢了。。。" + person.getName());
            //查询是否存在没有被抢的红包
            SynchSendSnatch.redPacketMap.forEach((k,v)->{
                if (!snatched.contains(k)){
                    BigDecimal snatch = iSnatch.snatch(v);
                    if (null != snatch) {
                        person.setAmount(person.getAmount().add(snatch));
                        System.out.println(person);
                        snatched.add(k);
                    }
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
