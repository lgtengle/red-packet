package com.lg.redpacket;

import com.lg.redpacket.biz.ISnatch;
import com.lg.redpacket.biz.RedPacketService;
import com.lg.redpacket.biz.syn.SynchConsumer;
import com.lg.redpacket.biz.syn.SynchSendSnatch;
import com.lg.redpacket.common.BigDecimalUtils;
import com.lg.redpacket.common.SpringContextUtil;
import com.lg.redpacket.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@Component
public class RedPacketApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedPacketApplication.class, args);

        RedPacketApplication redPacketApplication = (RedPacketApplication) SpringContextUtil.getBean("redPacketApplication");
        try {
            redPacketApplication.synchRun();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Resource(name = "synchSendSnatch")
    ISnatch snatch;

    @Autowired
    RedPacketService redPacketService;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    public void synchRun() throws Exception {
        Person p1 = new Person(1, "王五", BigDecimalUtils.get(100));

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person(1, "测试人"+i, BigDecimal.ZERO);
            //new SynchConsumer(p, snatch).run();
            personList.add(p);
            threadPoolExecutor.submit(new SynchConsumer(p, snatch));
        }

        for (int i = 1; i < 11; i++) {
            System.err.println("--------------------------------" + i + ">>>>>");
            Thread.sleep(5000);
            redPacketService.create(BigDecimalUtils.get(i), 5, "发红包喽" + i, p1);
            Thread.sleep(5000);
            System.err.println(p1);

            System.out.println("一共抢了 " + personList.stream()
                    .mapToDouble(w -> w.getAmount().doubleValue()).sum());
            System.err.println("--------------------------------" + i + "<<<<<");
        }
    }
}

