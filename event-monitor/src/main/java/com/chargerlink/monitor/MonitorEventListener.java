package com.chargerlink.monitor;


import com.chargerlink.monitor.event.MonitorEvent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: ZhangHeng zhanghenggoog@gmail.com
 * @Date: Created on 11:19 2018/11/20.
 */
public abstract class MonitorEventListener<T extends MonitorEvent> {

    /**
     * 监听的事件对象
     */
    final private T monitorEvent;

    /**
     * 线程执行标识
     */
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 初始化监听对象
     *
     * @param monitorEvent
     */
    public MonitorEventListener(T monitorEvent) {
        this.monitorEvent = monitorEvent;
    }

    /**
     * 监听回调方法
     *
     * @param monitorEvent
     */
    protected abstract void callBack(T monitorEvent);

    /**
     * 监听超时的回调
     *
     * @param monitorEvent
     */
    protected void timeOutCallBack(T monitorEvent){

    }

    /**
     * 处理异常时的回调
     *
     * @param e
     */
    protected void failureCallBack(T monitorEvent, Exception e){

    }

    /**
     * 获取事件唯一标识
     *
     * @return
     */
    String getEventFlag() {
        return monitorEvent.getEventFlag();
    }

    /**
     * 获取事件
     *
     * @return
     */
    public MonitorEvent getMonitorEvent() {
        return monitorEvent;
    }
}
