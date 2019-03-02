package com.lg.redpacket.biz.syn.queue;

import java.util.Date;

/**
 * <p>
 * description:
 * </p>
 *
 * @author leiguang
 * @version 0.1.0
 * @date 2019-02-28 20:28
 */
public class RedPacketQueue<T> {

    private NodeValue<T> head;

    private NodeValue<T> tail;

    public void add(T val){
        NodeValue<T> node = new NodeValue<>(val);
        if (null == head){
            node.next = null;
            node.pre = null;
            head = node;
        }else {
            NodeValue<T> temp = tail;
            tail = node

            ;
            temp.next = tail;
            tail.pre = temp;

        }
    }
}
