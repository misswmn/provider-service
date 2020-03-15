package com.roncoo.eshop.event;

import java.util.EventListener;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:42
 */
public interface TaskFinishEventListener extends EventListener {

    void onTaskFinish(TaskFinishEvent event);
}
