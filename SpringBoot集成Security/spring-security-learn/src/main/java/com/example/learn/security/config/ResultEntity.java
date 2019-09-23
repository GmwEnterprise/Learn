package com.example.learn.security.config;

public class ResultEntity<E> {
    private int state;
    private String msg;
    private E data;

    private ResultEntity() {
    }

    public static <E> ResultEntity<E> pack(int state, String msg, E data) {
        ResultEntity<E> entity = new ResultEntity<>();
        entity.setState(state);
        entity.setMsg(msg);
        entity.setData(data);
        return entity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
