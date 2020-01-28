package com.youkeda.redpack2.service;

import com.youkeda.redpack2.model.Redpack;
import com.youkeda.redpack2.model.User;
import com.youkeda.redpack2.util.RedpackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class GrabRedpackService {

    private RedpackUtil redpackUtil = new RedpackUtil();

    public void grabRedpack(Redpack redpack, User user) {
        if (redpack.getAllAmount().get() == 0) {
            System.out.println(user.getName() + "手慢了，没抢到");
        } else {
            int index = redpackUtil.randomRepackIndex(redpack);
            List<Integer> amountList = redpack.getAmountList();
            int grabAmount = amountList.get(index);
            System.out.println(user.getName() + "原来有" + user.getWallet());
            //钱包多钱了
            user.setWallet(user.getWallet() + grabAmount);
            System.out.println(user.getName() + "抢到了" + grabAmount);
            System.out.println(user.getName() + "现在有" + user.getWallet());
            //红包少钱了
            AtomicInteger remain = new AtomicInteger(redpack.getAllAmount().get() - grabAmount);
            redpack.setAllAmount(remain);
            amountList.set(index, 0);
            System.out.println("红包还剩"+ redpack.getAllAmount());
            for (Integer integer : amountList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
            System.out.println("________________________________");
        }
    }
}
