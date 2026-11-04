package com.petstore.ui;

import com.petstore.customer.Customer;
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
import java.time.LocalDate;

/**
 * 顾客纪念册弹窗（全部历史顾客）。
 * <p>
 * 姓名列使用固定显示宽度左对齐，使"到店次数"、"最新到店"等后续字段
 * 在等宽字体下整齐排列，便于扫读。
 *
 * @author pet-store
 */
public class CustomerAlbumDialog extends JDialog {

    /**
     * 顾客姓名字段的固定显示宽度。
     * <p>
     * 名字池中最长的名字是"匿名用户109"（4 个中文 + 3 个数字
     * = 显示宽度 4×2 + 3 = 11），取 16 留有余量，新增更长名字时也不会撑破列宽。
     */
    private static final int NAME_WIDTH = 16;

    public CustomerAlbumDialog(JFrame owner, MyAnimalShop shop) {
        super(owner, "顾客纪念册", true);
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("纪念册（共 " + shop.getCustomerList().size() + " 位顾客）", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        // ------------------------------------------------------------
        // 列表数据准备：对每位顾客构造一行格式化字符串
        // 格式：顾客{姓名=<左对齐填充的名字>, 到店次数=N, 最新到店=日期}
        // ------------------------------------------------------------
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Customer c : shop.getCustomerList()) {
            // 用固定宽度 NAME_WIDTH 左对齐补齐顾客名字
            // 这样"到店次数="在所有行里都从同一列开始，整齐排列
            String paddedName = UiUtils.padRight(c.getName(), NAME_WIDTH);

            LocalDate date = c.getLatestVisitDate();
            String dateStr = (date == null) ? "无" : date.toString();

            model.addElement("顾客{姓名=" + paddedName
                    + ", 到店次数=" + c.getVisitCount()
                    + ", 最新到店=" + dateStr + "}");
        }

        JList<String> list = new JList<>(model);
        // 使用宋体（SimSun）——Windows 自带的 CJK 等宽字体，
        // 既能正常显示中文，又能让 padRight 按显示宽度对齐生效
        list.setFont(new Font("SimSun", Font.PLAIN, 16));
        add(new JScrollPane(list), BorderLayout.CENTER);

        setSize(620, 420);
        setLocationRelativeTo(owner);
    }
}