package com.petstore.ui;

import com.petstore.animal.Animal;
import com.petstore.animal.Gender;
import com.petstore.customer.Customer;
import com.petstore.shop.MyAnimalShop;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 营业界面叠加层。
 * <p>
 * 显示当前顾客信息（头像、姓名、要求），右上角显示游戏内时间与歇业按钮。
 *
 * @author pet-store
 */
public class BusinessPanel extends JPanel {

    private static final String[] SPECIES = {"中华田园犬", "猫猫", "小香猪", "鹦鹉", "金丝熊仓鼠"};
    private static final Color BG_COLOR = new Color(255, 244, 230);

    private final MyAnimalShop shop;
    private final PetStoreFrame frame;

    private List<String> customerNames;
    private int currentIndex;
    private int currentMinutes;

    private String reqSpecies;
    private Gender reqGender;
    private int reqAge;
    private Customer currentCustomer;
    private boolean customerServed;

    private final JLabel timeLabel;
    private final JLabel avatarLabel;
    private final JLabel nameLabel;
    private final JLabel requirementLabel;
    private final JButton haveBtn;
    private final JButton noBtn;
    private final JButton nextBtn;

    public BusinessPanel(MyAnimalShop shop, PetStoreFrame frame) {
        this.shop = shop;
        this.frame = frame;
        setBackground(BG_COLOR);
        setBorder(BorderFactory.createLineBorder(new Color(210, 180, 140), 2));
        setLayout(new BorderLayout(10, 10));

        // 右上角：时间 + 歇业
        JPanel topRight = new JPanel();
        topRight.setLayout(new javax.swing.BoxLayout(topRight, javax.swing.BoxLayout.Y_AXIS));
        topRight.setOpaque(false);
        timeLabel = new JLabel("--:--", SwingConstants.RIGHT);
        timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 28));
        timeLabel.setAlignmentX(RIGHT_ALIGNMENT);
        JButton closeBtn = new JButton("歇业");
        closeBtn.setAlignmentX(RIGHT_ALIGNMENT);
        closeBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        closeBtn.addActionListener(e -> {
            if (UiUtils.confirm(this, "确定要提前歇业吗？")) {
                frame.closeBusiness();
            }
        });
        topRight.add(timeLabel);
        topRight.add(closeBtn);
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(topRight, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // 中部：顾客信息
        JPanel center = new JPanel();
        center.setLayout(new javax.swing.BoxLayout(center, javax.swing.BoxLayout.Y_AXIS));
        center.setOpaque(false);

        avatarLabel = new JLabel();
        avatarLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel = new JLabel(" ", SwingConstants.CENTER);
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        requirementLabel = new JLabel(" ", SwingConstants.CENTER);
        requirementLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        requirementLabel.setAlignmentX(CENTER_ALIGNMENT);

        center.add(javax.swing.Box.createVerticalGlue());
        center.add(avatarLabel);
        center.add(javax.swing.Box.createVerticalStrut(10));
        center.add(nameLabel);
        center.add(javax.swing.Box.createVerticalStrut(8));
        center.add(requirementLabel);
        center.add(javax.swing.Box.createVerticalGlue());
        add(center, BorderLayout.CENTER);

        // 底部：按钮
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        bottom.setOpaque(false);
        haveBtn = createActionButton("有的");
        noBtn = createActionButton("没有");
        nextBtn = createActionButton("下一位顾客");
        nextBtn.setEnabled(false);

        haveBtn.addActionListener(e -> onHave());
        noBtn.addActionListener(e -> onNo());
        nextBtn.addActionListener(e -> advance());

        bottom.add(haveBtn);
        bottom.add(noBtn);
        bottom.add(nextBtn);
        add(bottom, BorderLayout.SOUTH);
    }

    private JButton createActionButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(140, 45));
        btn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    /**
     * 开始一天的营业。
     */
    public void startDay(List<String> names) {
        this.customerNames = names;
        this.currentIndex = 0;
        this.currentMinutes = MyAnimalShop.OPEN_HOUR * 60;
        loadCustomer();
    }

    private void loadCustomer() {
        if (currentIndex >= customerNames.size()) {
            frame.closeBusiness();
            return;
        }
        String name = customerNames.get(currentIndex);
        reqSpecies = SPECIES[ThreadLocalRandom.current().nextInt(SPECIES.length)];
        Gender[] genders = Gender.values();
        reqGender = genders[ThreadLocalRandom.current().nextInt(genders.length)];
        reqAge = ThreadLocalRandom.current().nextInt(1, 5); // 1~4

        currentCustomer = new Customer(name, 0, null);
        customerServed = false;

        avatarLabel.setIcon(new AvatarIcon(name, 90));
        nameLabel.setText(name);
        requirementLabel.setText(String.format("想要一只：%s · %s · %d岁", reqSpecies, reqGender, reqAge));
        timeLabel.setText(formatTime(currentMinutes));

        haveBtn.setEnabled(true);
        noBtn.setEnabled(true);
        nextBtn.setEnabled(false);
    }

    private void onHave() {
        List<Animal> matching = shop.findMatchingAnimals(reqSpecies, reqGender, reqAge);
        if (matching.isEmpty()) {
            UiUtils.info(this, "没有符合条件的动物");
            shop.visitOnly(currentCustomer);
        } else {
            String[] options = matching.stream().map(Animal::toString).toArray(String[]::new);
            int choice = JOptionPane.showOptionDialog(this,
                    "请选择要出售的动物：", "选择动物",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (choice >= 0) {
                Animal selected = matching.get(choice);
                if (shop.sellToCustomer(currentCustomer, selected)) {
                    UiUtils.success(this, "交易成功！售出 " + selected.getName());
                    frame.refreshBalance();
                }
            } else {
                return; // 用户取消，不推进
            }
        }
        finishCustomer();
    }

    private void onNo() {
        shop.visitOnly(currentCustomer);
        finishCustomer();
    }

    private void finishCustomer() {
        customerServed = true;
        haveBtn.setEnabled(false);
        noBtn.setEnabled(false);
        nextBtn.setEnabled(true);
    }

    private void advance() {
        currentIndex++;
        currentMinutes += MyAnimalShop.MINUTES_PER_CUSTOMER;
        if (currentIndex >= customerNames.size() || currentMinutes >= MyAnimalShop.CLOSE_HOUR * 60) {
            frame.closeBusiness();
            return;
        }
        loadCustomer();
    }

    private String formatTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}
