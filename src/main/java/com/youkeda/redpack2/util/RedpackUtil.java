package com.youkeda.redpack2.util;

import com.youkeda.redpack2.model.Redpack;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
public class RedpackUtil {

    public Integer randomRepackIndex(Redpack redpack) {
        List<Integer> amountList = redpack.getAmountList();
        Random random = new Random();
        Integer repackIndex;
        do {
            repackIndex = random.nextInt(amountList.size());
        } while (amountList.get(repackIndex) == 0);
        return repackIndex;
    }

    //检验是否有两个运气王
    public static boolean haveTwoLuck(List<Integer> list) {
        List<Integer> copy = new ArrayList<Integer>(list);
        boolean isTwoLuck = true;
        Collections.sort(copy);
        Integer luck = copy.get(copy.size() - 1);
        if (copy.indexOf(luck) == copy.size() - 1) {
            isTwoLuck = false;
        }
        return isTwoLuck;
    }

    //线段分割法
    public static List<Integer> divide(int money, int n) {
        //放 板子
        List<Integer> boards;
        //放 红包所有金额
        List<Integer> list;
        do {
            //验证参数合理校验
            //为了使用random.nextInt(Integer)方法不得不先把红包金额放大100倍，最后在main函数里面再除以100
            //这样就可以保证每个人抢到的金额都可以精确到小数点后两位
            int fen = money;
            if (fen < n || n < 1) {
                System.out.println("红包个数必须大于0，并且最小红包不少于1分");
            }
            boards = new ArrayList<Integer>();
            boards.add(0);
            boards.add(fen);
            //红包个数和板砖个数的关系
            while (boards.size() <= n) {
                int index = new Random().nextInt(fen - 1) + 1;
                if (boards.contains(index)) {
                    //保证板子的位置不相同
                    continue;
                }
                boards.add(index);
            }
            //计算每个红包的金额，将两个板子之间的钱加起来
            Collections.sort(boards);
            list = new CopyOnWriteArrayList<>();
            for (int i = 0; i < boards.size() - 1; i++) {
                Integer e = boards.get(i + 1) - boards.get(i);
                list.add(e);
            }
        } while (RedpackUtil.haveTwoLuck(list));
        return list;
    }

}
