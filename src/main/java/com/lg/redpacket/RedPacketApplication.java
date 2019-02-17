package com.lg.redpacket;

import com.lg.redpacket.biz.ISnatch;
import com.lg.redpacket.biz.RedPacketService;
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

    @Resource(name = "synchSnatchImpl")
    ISnatch snatch;

    @Autowired
    RedPacketService redPacketService;

    public void synchRun() throws Exception {
        Person p1 = new Person(1, "王五", BigDecimalUtils.get(100));

        int id = redPacketService.create(BigDecimalUtils.get(0.05), 5, "发红包喽", p1);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            Person p = new Person(1, "测试"+i, BigDecimal.ZERO);
            BigDecimal snatch = this.snatch.snatch(id);
            if (null != snatch)
                p.setAmount(p.getAmount().add(snatch));
            personList.add(p);
            System.out.println(p);
        }

        System.out.println(p1);
    }
}

