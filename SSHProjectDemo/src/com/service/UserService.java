package com.service;
import com.dao.UserDAO;
import com.entity.UserEntity;
import java.util.List;

public class UserService{
    UserDAO userDAO;
    public void setUserDAO(com.dao.UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public List login(UserEntity condition)
    {
        return userDAO.search(condition);
    }
}
