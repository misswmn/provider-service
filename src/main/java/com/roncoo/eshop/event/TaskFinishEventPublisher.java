package com.roncoo.eshop.event;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件发布器
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:44
 */
public class TaskFinishEventPublisher {
    private List<TaskFinishEventListener> listeners = new ArrayList<>();

    /**
     * 注册监听器
     *
     * @param listener 监听器
     * @description:
     * @return:
     * @author: wangmeng
     * @time: 2020-03-09 20:46
     */
    public synchronized void register(TaskFinishEventListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    //移除监听器
    public synchronized boolean remove(TaskFinishEventListener listner) {
        return listeners.remove(listner);
    }

    // 发布事件
    public void publishEvent(TaskFinishEvent event) {
        for (TaskFinishEventListener listener : listeners) {
            listener.onTaskFinish(event);
        }
    }
}
