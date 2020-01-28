package com.youkeda.redpack2.model;


import com.youkeda.redpack2.util.RedpackUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
public class Redpack {
    //红包金额
    private AtomicInteger allAmount;
    //红包数量
    private AtomicInteger num;
    //从哪个用户发出来的
    private Integer fromUserId;
    private CopyOnWriteArrayList<Integer> amountList;

    public Redpack(int allAmount,
                   int num,
                   Integer fromUserId) {
        this.allAmount = new AtomicInteger(allAmount) ;
        this.num = new AtomicInteger(num) ;
        this.fromUserId = fromUserId;
        this.amountList =(CopyOnWriteArrayList<Integer>) RedpackUtil.divide(allAmount,num);
    }


}
