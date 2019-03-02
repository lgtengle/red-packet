package com.lg.redpacket.biz.syn.queue;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

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

    private ReentrantLock lock = new ReentrantLock();

    private NodeValue<T> head;

    private NodeValue<T> tail;

    public void add(T val){
        NodeValue<T> node = new NodeValue<>(val);
        NodeValue<T> temp = tail;
        tail = node;
        if (null == head){
            node.next = null;
            node.pre = null;
            head = node;
        }else {
            if (temp != null)
                temp.next = tail;

            tail.pre = temp;
        }
    }
}
