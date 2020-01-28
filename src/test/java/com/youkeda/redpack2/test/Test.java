package com.youkeda.redpack2.test;

import com.youkeda.redpack2.model.Redpack;
import com.youkeda.redpack2.model.User;
import com.youkeda.redpack2.service.GrabRedpackService;


public class Test {
    private GrabRedpackService grabRedpackService = new GrabRedpackService();

    private static Redpack redpack = new Redpack(500, 7,1);

    @org.junit.jupiter.api.Test
    void test01() {
        User user = new User();
        user.setId(1);
        user.setName("xiaoming");
        user.setWallet(1000);
        grabRedpackService.grabRedpack(redpack,user);
    }

    @org.junit.jupiter.api.Test
    void test02() {
        User user = new User();
        user.setId(2);
        user.setName("xiaohong");
        user.setWallet(900);
        grabRedpackService.grabRedpack(redpack,user);
    }

    @org.junit.jupiter.api.Test
    void test03() {
        User user = new User();
        user.setId(3);
        user.setName("xiaogang");
        user.setWallet(800);
        grabRedpackService.grabRedpack(redpack,user);
    }

    @org.junit.jupiter.api.Test
    void test04() {
        User user = new User();
        user.setId(4);
        user.setName("xiaofang");
        user.setWallet(700);
        grabRedpackService.grabRedpack(redpack,user);
    }

    @org.junit.jupiter.api.Test
    void test05() {
        User user = new User();
        user.setId(5);
        user.setName("xiaoping");
        user.setWallet(600);
        grabRedpackService.grabRedpack(redpack,user);
    }

    @org.junit.jupiter.api.Test
    void test06() {
        User user = new User();
        user.setId(6);
        user.setName("xiaoli");
        user.setWallet(500);
        grabRedpackService.grabRedpack(redpack,user);
    }

}
