package com.infoshareacademy.searchengine;


import searchengine.dao.UsersRepositoryDaoBean;
import searchengine.domain.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        UsersRepositoryDaoBean dao = new UsersRepositoryDaoBean();
        List<User> list = dao.userList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getSurname());
            System.out.println(list.get(i).getAge());
            System.out.println(list.get(i).getLogin());
            System.out.println("______________________");

        }

    }
}