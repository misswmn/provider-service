package com.roncoo.eshop.event;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:41
 */
public class Task {
    private String name;

    private TaskFinishStatus status;

    public Task(String name, TaskFinishStatus status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskFinishStatus getStatus() {
        return status;
    }

    public void setStatus(TaskFinishStatus status) {
        this.status = status;
    }
}
