package com.petstore.ui;

import com.petstore.animal.Animal;
import com.petstore.exception.InsufficientBalanceException;
import com.petstore.shop.MyAnimalShop;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

/**
 * 进货界面。
 * <p>
 * 每类动物 5 个货位（共 25 个），点击货位按进价买入对应动物。
 *
 * @author pet-store
 */
public class PurchaseDialog extends JDialog {

    private final MyAnimalShop shop;
    private final JButton[][] slotButtons = new JButton[5][5];

    public PurchaseDialog(JFrame owner, MyAnimalShop shop) {
        super(owner, "购买动物（进货）", true);
        this.shop = shop;

        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel hint = new JLabel("点击货位以进价购入该动物（进价 = 售价 ÷ 5）", JLabel.CENTER);
        hint.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        add(hint, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(5, 5, 8, 8));
        for (int r = 0; r < 5; r++) {
            Class<? extends Animal> speciesClass = MyAnimalShop.SPECIES_CLASSES.get(r);
            List<Animal> slots = shop.getCandidateSlots(speciesClass);
            for (int c = 0; c < 5; c++) {
                slotButtons[r][c] = createSlotButton(speciesClass, c, slots.get(c));
                grid.add(slotButtons[r][c]);
            }
        }
        add(grid, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeBtn = new JButton("关闭");
        closeBtn.addActionListener(e -> dispose());
        bottom.add(closeBtn);
        add(bottom, BorderLayout.SOUTH);

        setSize(820, 560);
        setLocationRelativeTo(owner);
    }

    private JButton createSlotButton(Class<? extends Animal> speciesClass, int index, Animal animal) {
        JButton btn = new JButton();
        btn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(140, 80));
        if (animal == null) {
            btn.setText("空");
            btn.setEnabled(false);
            btn.setBackground(new Color(230, 230, 230));
            return btn;
        }
        btn.setText("<html>" + animal.getSpecies() + " " + animal.getName()
                + "<br>" + animal.getGender() + " · " + animal.getAge() + "岁"
                + "<br>进价 ¥" + (int) (animal.getPrice() * MyAnimalShop.PURCHASE_RATIO)
                + "</html>");
        btn.setBackground(new Color(255, 248, 230));
        btn.addActionListener(e -> purchase(speciesClass, index, btn));
        return btn;
    }

    private void purchase(Class<? extends Animal> speciesClass, int index, JButton btn) {
        Animal candidate = shop.takeCandidate(speciesClass, index);
        if (candidate == null) {
            return;
        }
        try {
            shop.buyAnimal(candidate);
            UiUtils.success(this, "成功购入：" + candidate.getName());
            // 买入成功：货位置空
            btn.setText("空");
            btn.setEnabled(false);
            btn.setBackground(new Color(230, 230, 230));
        } catch (InsufficientBalanceException ex) {
            // 余额不足：放回货位
            shop.returnCandidate(speciesClass, index, candidate);
            UiUtils.error(this, ex.getMessage());
        }
    }
}
