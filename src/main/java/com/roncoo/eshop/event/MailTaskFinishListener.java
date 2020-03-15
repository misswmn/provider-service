package com.roncoo.eshop.event;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 20:44
 */
public class MailTaskFinishListener implements TaskFinishEventListener {
    private String email;

    public MailTaskFinishListener(String email) {
        this.email = email;
    }

    @Override
    public void onTaskFinish(TaskFinishEvent event) {
        System.out.println("事件结束发送邮件 => " + email + " 》》》》》》》》》》》》》》》》");
    }
}
