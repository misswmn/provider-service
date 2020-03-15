package com.roncoo.eshop.event;

import java.util.EventObject;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:42
 */
public class TaskFinishEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TaskFinishEvent(Object source) {
        super(source);
    }
}
