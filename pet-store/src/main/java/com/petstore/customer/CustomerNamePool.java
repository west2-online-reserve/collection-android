package com.petstore.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 顾客名字池（用户提供的名字集合）。
 * <p>
 * 每天从池中随机抽取若干名字，保证同日不重名。
 *
 * @author pet-store
 */
public final class CustomerNamePool {

    private static final List<String> NAMES = List.of(
            "琳佳佳", "临织织", "鱼嘉嘉", "洁羽羽", "静依依", "怡玥玥", "瑶诗诗", "颖思思",
            "橘居居", "莹笑笑", "雪瑞瑞", "敏香香", "珉珉知", "康永永", "程晓晓", "莹晚晚",
            "康晓晓", "京姜姜", "如依依", "黎黎", "波波皮", "楚楚嘟", "雯叶叶", "豆土土",
            "阳浩浩", "知知", "阿贝贝", "抹抹", "晟闻闻", "泽润润", "延只只", "言末末",
            "颜声声", "砚迟迟", "羊懒懒", "允画画", "翊凝凝", "朔越越", "昇朝朝", "笙初初",
            "绵伊伊", "眠北北", "越木木", "尘季季", "瓦瓦", "乐乐", "闹闹", "奶龙大王", "萌萌奶娃",
            "乔治宝宝", "奇佩佩", "大熊熊", "二熊熊", "人人颜", "二西西", "匿名用户99",
            "匿名用户32", "匿名用户109", "匿名用户67", "匿名用户52", "匿名用户26", "匿名用户31",
            "匿名用户55", "匿名用户88", "匿名用户42", "匿名用户49", "匿名用户39", "匿名用户58",
            "匿名用户17", "匿名用户30", "匿名用户98", "匿名用户11",
            "匿名用户22", "匿名用户73", "匿名用户13", "匿名用户56", "匿名用户45"
    );
    //List.of方法是为了契合final含义，生成真正不可变的集合
    //创建后任何add，remove操作都会跑出操作一次，且不允许null元素的存在

    private CustomerNamePool() {
    }

    //下方注释格式是为方法和类写注释说明的格式，可以被Java特殊识别
    //鼠标悬停时在方法上时可看见介绍
    //param表示形参

    /**
     * 随机抽取指定数量的名字，且不重复。
     *
     * @param count 需要的数量
     * @return 不重复的名字列表
     * @throws IllegalArgumentException 如果需要的名字数量超过池子大小
     */
    public static List<String> pickRandom(int count) {
        if (count > NAMES.size()) {
            throw new IllegalArgumentException("需要的名字数量超过池子大小: " + count);
        }
        List<String> shuffled = new ArrayList<>(NAMES);
        Collections.shuffle(shuffled);
        return new ArrayList<>(shuffled.subList(0, count));
        //由于NAMES不可改，所以先拷贝一份list（shuffled）
        //collection.shuffle方法表示打乱数组
        //list名字.sublist方法表示显示该数组该范围内的视图

    }

    public static int size() {
        return NAMES.size();
    }
}
