package com.petstore.ui;

import com.petstore.animal.Animal;
import com.petstore.animal.ChineseRuralDog;
import com.petstore.shop.MyAnimalShop;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;


//ui表示用户界面

/**
 * 所拥有动物列表弹窗。
 *
 * @author pet-store
 */
public class AnimalsDialog extends JDialog {

    /**
     * 品种标签（如 [中华田园犬]）在列表中的固定显示宽度。
     * <p>
     * 因为在等宽字体中，每个中文字符占 2 个 ASCII 字符的宽度，
     * 而最长的品种标签 "[金丝熊仓鼠]" 有 5 个中文字 + 2 个方括号，
     * 显示宽度 = 5×2 + 2 = 12。把目标宽度定为 12 可以让所有品种标签
     * 恰好左对齐，后面的姓名、年龄、价格等信息就能排成整齐的一列。
     */
    private static final int SPECIES_TAG_WIDTH = 12;

    public AnimalsDialog(JFrame owner, MyAnimalShop shop) {
        //构造方法，创建一个动物列表弹窗
        super(owner, "所拥有动物", true);

        //继承自JDialog，owner表示主窗口，主窗口若关闭本窗口一同消失
        //model表示模态，为true表示该弹窗存在期间主窗口不能被操作

        setLayout(new BorderLayout(10, 10));

        //创建一个布局，BorderLayout为经典的五区域布局，东西南北中
        //该布局为掠夺式布局，若东西南北区域未添加组件则占比为0，中部填满

        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        //（JPanel为强转类型），调用getContentPane方法获取内容面板，setBorder设置边界
        //BOrderFactory为工厂方法，他与new的区别是创建出的东西可载入缓存重复使用，起到节省内存的作用

        JLabel title = new JLabel("店内动物（共 " + shop.getAnimalList().size() + " 只）", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 16));

        //setFont创建字体
        //bold为粗体，plain为普通，italic为斜体

        add(title, BorderLayout.NORTH);

        // ------------------------------------------------------------
        // 列表数据准备：对每只动物构造一行格式化字符串
        // 格式：左对齐的品种标签 + 空格 + 姓名(性别, N岁, ¥价格, 特有信息)
        // ------------------------------------------------------------
        DefaultListModel<String> model = new DefaultListModel<>();

        //创建一个模组，把动物列表的内容存进去

        for (Animal a : shop.getAnimalList()) {
            // 品种标签形如 "[中华田园犬]"
            String tag = "[" + a.getSpecies() + "]";

            // 用固定宽度 SPECIES_TAG_WIDTH 左对齐补齐
            // 注意：不能直接用 String.format("%-12s", tag)，因为它按
            // 字符数填充，而中文字符显示宽度是 ASCII 的 2 倍，会导致对不齐
            String paddedTag = UiUtils.padRight(tag, SPECIES_TAG_WIDTH);

            // 组装完整一行，extraInfo 负责追加子类特有的字段（如狂犬疫苗）
            String line = paddedTag + " "
                    + a.getName() + "("
                    + a.getGender() + ", "
                    + a.getAge() + "岁, ¥"
                    + (int) a.getPrice()
                    + extraInfo(a) + ")";

            model.addElement(line);
            //添加至模组
        }



        JList<String> list = new JList<>(model);

        //调用模组，生成一个JList格式的集合
        //这是swing特有的model-view方式，JList只负责视图，model负责存储
        //JList无法直接添加字符串
        //多个集合可以调用同一个模组

        // 使用宋体（SimSun）——Windows 自带的 CJK 等宽字体，
        // 既能正常显示中文（Consolas 不行），又能让 padRight 按显示宽度对齐生效
        list.setFont(new Font("SimSun", Font.PLAIN, 14));
        add(new JScrollPane(list), BorderLayout.CENTER);

        setSize(560, 400);
        setLocationRelativeTo(owner);

        //setLocalRelative表示位置，owner为主窗口正中，null为整个屏幕正中
        //写成setLocation可以自己添加xy坐标，为绝对位置
    }

    /**
     * 给动物追加子类特有的信息（如中华田园犬的狂犬疫苗字段）。
     * 没有特有字段时返回空串。
     *
     * @param a 动物
     * @return 要追加到括号内尾部的字段字符串（含前导逗号）
     */
    private static String extraInfo(Animal a) {
        // 用 instanceof 判断具体子类，避免在 Animal 抽象类里塞可选字段
        if (a instanceof ChineseRuralDog dog && dog.isVaccineInjected()) {
            return ", 已狂犬疫苗";
        }
        return "";
    }
}