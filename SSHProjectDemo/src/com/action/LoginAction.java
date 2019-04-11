package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

import java.util.List;

public class LoginAction extends ActionSupport{

    com.service.UserService userService;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws  Exception
    {
        UserEntity condition = new UserEntity();
        condition.setName(username);
        condition.setPassword(password);

        List list = userService.login(condition);

        if(list.size() > 0)
        {
            return  "success";
        } else
        {
            return "error";
        }
    }
}
