package com.liu.domain;

import java.util.List;

public class UserVO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userList=" + userList +
                '}';
    }
}
