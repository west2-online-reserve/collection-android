package com.petstore.ui;

import com.petstore.customer.Customer;
import com.petstore.shop.DailyReport;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

/**
 * 歇业结算画面。
 *
 * @author pet-store
 */
public class SettlementDialog extends JDialog {

    public SettlementDialog(JFrame owner, DailyReport report) {
        super(owner, "歇业结算", false);
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().setBackground(new Color(252, 248, 240));

        JLabel title = new JLabel("宠物店已关门", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        StringBuilder sb = new StringBuilder();
        sb.append("营业日：").append(report.getDate()).append("\n\n");
        sb.append("今日光顾顾客（").append(report.getVisitors().size()).append("位）：\n");
        if (report.getVisitors().isEmpty()) {
            sb.append("  （无）\n");
        } else {
            for (Customer c : report.getVisitors()) {
                sb.append("  • ").append(c.getName())
                        .append("（累计到店").append(c.getVisitCount()).append("次）\n");
            }
        }
        sb.append(String.format("成交金额：¥%.2f%n", report.getSales()));

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        area.setBackground(new Color(252, 248, 240));
        add(new JScrollPane(area), BorderLayout.CENTER);

        setSize(500, 420);
        setLocationRelativeTo(owner);
    }
}
