package com.lg.redpacket.biz.syn.queue;

import java.util.Date;

/**
 * <p>
 * description: 队列中值
 * </p>
 *
 * @author leiguang
 * @version 0.1.0
 * @date 2019-02-28 20:20
 */
public class NodeValue<T> {

    private T value;

    public NodeValue next;

    public NodeValue pre;

    /**
     * 数据入队时间
     */
    private Date joinTime;

    public NodeValue(T value){
        this.value = value;
    }

    public NodeValue(T value, Date joinTime) {
        this.value = value;
        this.joinTime = joinTime;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }


}
