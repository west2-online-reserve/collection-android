package com.petstore.animal;

import java.util.HashMap;
import java.util.Map;

/**
 * 动物个体名字生成器。
 * <p>
 * 每个种类各自维护一个从 1 开始、永不重置的计数器；
 * 名字 = 编号的十进制数字逐位替换为中文数字后拼接。
 * 例如：1→一、10→一零、11→一一、19→一九、101→一零一、480→四八零、807→八零七、999→九九九。
 *
 * @author pet-store
 */
public final class AnimalNameGenerator {

    /** 编号上限 */
    public static final int MAX_INDEX = 999;

    private static final String[] DIGITS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    private final Map<Class<? extends Animal>, Integer> counters = new HashMap<>();
    //该段指的是map由class（类）和整数组成，其中class继承至animal即可。

    /**
     * 为指定品种生成下一个个体名字。
     *
     * @param speciesClass 品种对应的动物类
     * @return 个体名字；若编号已达上限返回 {@code null}
     */
    public String nextName(Class<? extends Animal> speciesClass) {
        //这里（Class<? extends Animal>）为类型，类似于String，int
        // speciesClass为形参，类似于num，a，n，是自己取的名字
        //这个方法的参数只有一个speciesClass，前面那个是他的类型
        int next = counters.merge(speciesClass, 1, Integer::sum);
        //counters是map数组，merge方法的意思为若该动物类型第一次出现，则next为1
        // 若非第一次出现，则next的值为上一次的值+1
        if (next > MAX_INDEX) {
            // 回退计数，保证后续调用仍返回上限值
            counters.put(speciesClass, MAX_INDEX);
            //put相当于add
            return null;
        }
        return toChineseDigits(next);
        //toChineseDigits是一种方法（自己写的），可以将阿拉伯数字转为中文
    }

    /**
     * 获取指定品种下一个可用的编号（不推进计数器）。
     *
     * @param speciesClass 品种对应的动物类
     * @return 下一个编号
     */
    public int peekNextIndex(Class<? extends Animal> speciesClass) {
        return counters.getOrDefault(speciesClass, 0) + 1;
    }

    /**
     * 将数字转换为逐位中文数字拼接的字符串。
     *
     * @param number 数字（1~999）
     * @return 中文数字字符串
     */
    public static String toChineseDigits(int number) {
        if (number < 0 || number > MAX_INDEX) {
            throw new IllegalArgumentException("编号超出范围: " + number);
        }
        StringBuilder sb = new StringBuilder();
        String numStr = String.valueOf(number);
        //String.valueOf()为Java方法，将其他类型变为字符串
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(DIGITS[numStr.charAt(i) - '0']);
            //append意为追加
        }
        return sb.toString();
        //转化为字符串方便后续输出
    }
}
