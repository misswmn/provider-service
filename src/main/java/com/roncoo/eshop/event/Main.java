package com.roncoo.eshop.event;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:48
 */
public class Main {

    public static void main(String[] args) {
        // 事件源
        Task source = new Task("用户统计", TaskFinishStatus.SUCCEDD);
        // 任务结束事件
        TaskFinishEvent event = new TaskFinishEvent(source);

        // 邮件监听器
        MailTaskFinishListener listener = new MailTaskFinishListener("xxxx@qq.com");
        // 事件发布器
        TaskFinishEventPublisher publisher = new TaskFinishEventPublisher();
        // 注册邮件监听器
        publisher.register(listener);
        // 发布事件
        publisher.publishEvent(event);
    }
}
