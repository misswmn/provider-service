package com.roncoo.eshop.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-03-01 00:29
 */
public class ResponsibilityChain01 {
    private static final String MSG = "欢迎:) <script>, 大家好，fuck 。。。。xxx.com";

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg(MSG);
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter())
                .add(new SensitiveFilter());
//        filterChain.doFilter(msg);


        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new URLFilter())
                .add(new FaceFilter());

        filterChain2.add(filterChain);
        filterChain2.doFilter(msg);

        System.out.println(msg);
    }
}

class Msg {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String message = msg.getMsg();
        message = message.replaceAll("<", "[");
        message = message.replaceAll(">", "]");
        message = message.replaceAll(">", "]");
        msg.setMsg(message);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String message = msg.getMsg();
        message = message.replaceAll("fuck", "");
        msg.setMsg(message);
        return true;
    }
}

class URLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String message = msg.getMsg();
        message = message.replaceAll("xxx.com", "http://hello.com");
        msg.setMsg(message);
        return true;
    }
}

class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String message = msg.getMsg();
        message = message.replaceAll(":\\)", "^V^");
        msg.setMsg(message);
        return true;
    }
}

class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                break;
            }
        }
        return true;
    }
}
