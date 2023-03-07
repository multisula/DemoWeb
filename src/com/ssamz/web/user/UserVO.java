package com.ssamz.web.user;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVO implements HttpSessionBindingListener{
    private String id;
    private String password;
    private String name;
    private String role;

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("---> UserVO 객체가 세션에 등록됨");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("---> UserVO 객체가 세션에서 제됨");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
