package com.lg.redpacket.biz;

import com.lg.redpacket.model.RedPacket;

/**
 * <p>
 * description: 发送红包接口
 * </p>
 *
 * @author leiguang
 * @version 0.1.0
 * @date 2019-02-19 15:45
 */
public interface ISend {

    /**
     * 发送红包接口
     * @param redPacket 红包信息
     * @return true表示发送成功
     */
    boolean send(RedPacket redPacket);
}
