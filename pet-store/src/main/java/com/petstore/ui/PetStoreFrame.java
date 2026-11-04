package com.petstore.ui;

import com.petstore.customer.CustomerNamePool;
import com.petstore.shop.MyAnimalShop;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

/**
 * 宠物店主窗口（JFrame 子类）。
 * <p>
 * 窗口布局分为两层（使用 JLayeredPane 实现）：
 * <pre>
 * ┌─────────────────────────────────────────┐
 * │  JLayeredPane（自定义 ContentPane）      │
 * │  ┌─────────────────────────────────────┐│
 * │  │  DEFAULT_LAYER: mainPanel            ││
 * │  │  ┌─────────────────────────────┐     ││
 * │  │  │ NORTH: 顶栏（余额 + 按钮）  │     ││  ← 始终可见
 * │  │  ├─────────────────────────────┤     ││
 * │  │  │ CENTER: 下半区按钮          │     ││  ← 开业前显示
 * │  │  │ [开业] [购买动物]            │     ││
 * │  │  └─────────────────────────────┘     ││
 * │  ├─────────────────────────────────────┤│
 * │  │  PALETTE_LAYER: businessPanel       ││  ← 开业后覆盖下半区
 * │  │  ┌─────────────────────────────┐     ││
 * │  │  │ 营业界面（顾客/交易）       │     ││
 * │  │  └─────────────────────────────┘     ││
 * │  └─────────────────────────────────────┘│
 * └─────────────────────────────────────────┘
 * </pre>
 * 上半区（顶栏）始终可见；下半区初始显示"开业""购买动物"按钮，
 * 点击"开业"后被 BusinessPanel 叠加层覆盖，进入营业状态。
 *
 * @author pet-store
 */
public class PetStoreFrame extends JFrame {

    // ==================== 常量 ====================

    /** 主窗口宽度（像素） */
    private static final int FRAME_WIDTH = 900;
    /** 主窗口高度（像素） */
    private static final int FRAME_HEIGHT = 600;
    /** 整体背景色：暖米色 (R=252, G=248, B=240) */
    private static final Color BG_COLOR = new Color(252, 248, 240);

    // ==================== 成员字段 ====================

    /** 宠物店业务模型：提供余额、动物列表、顾客列表、交易处理等所有业务数据和逻辑 */
    private final MyAnimalShop shop;
    /**
     * 分层面板（JLayeredPane）：
     * 替换默认的 ContentPane，实现"主面板在底层、营业界面在高层"的叠加效果。
     * DEFAULT_LAYER 放 mainPanel（基础 UI），PALETTE_LAYER 放 businessPanel（营业界面）。
     */
    private final JLayeredPane layeredPane;
    /**
     * 主面板（BorderLayout 布局）：
     * NORTH 区域放 topPanel（余额 + 两个按钮），
     * CENTER 区域放 lowerPanel（开业 / 购买动物按钮）。
     */
    private final JPanel mainPanel;
    /**
     * 下半区面板（初始可见）：
     * 包含 [开业] 和 [购买动物] 两个大按钮。
     * 开业后，businessPanel 会叠加覆盖此区域。
     */
    private final JPanel lowerPanel;
    /** 顶部余额标签：显示当前宠物店余额，每次交易后调用 refreshBalance() 更新 */
    private final JLabel balanceLabel;
    /**
     * 营业界面面板（初始隐藏）：
     * 包含顾客列表、交易操作区等完整营业 UI。
     * 开业时显示，叠加覆盖 lowerPanel 区域。
     */
    private final BusinessPanel businessPanel;

    // ==================== 构造器 ====================

    /**
     * 构造主窗口：初始化两层面板，搭建顶栏、下半区按钮组、营业叠加层。
     * <p>
     * 完整流程：
     * <ol>
     *   <li>创建 JLayeredPane 并设为 ContentPane</li>
     *   <li>构建 mainPanel（BorderLayout），内部放 topPanel + lowerPanel</li>
     *   <li>将 mainPanel 加到 DEFAULT_LAYER</li>
     *   <li>构建 businessPanel（初始隐藏），加到 PALETTE_LAYER</li>
     *   <li>设置窗口大小、位置、关闭行为</li>
     *   <li>注册窗口缩放监听，实时调整叠加层位置</li>
     * </ol>
     *
     * @param shop 宠物店业务对象，负责提供数据和处理交易逻辑
     */
    public PetStoreFrame(MyAnimalShop shop) {
        super("My Pet Store");   // 调用 JFrame 构造器：设置窗口标题栏显示文字
        this.shop = shop;

        // ─── 步骤 1：替换 ContentPane ───
        // 默认 ContentPane 是 JPanel（BorderLayout），
        // 这里换成 JLayeredPane 才能实现"两层叠加"效果
        layeredPane = new JLayeredPane();
        setContentPane(layeredPane);

        // ═══════════════════════════════════════════
        // 步骤 2：构建 mainPanel（DEFAULT_LAYER 的基础面板）
        // ═══════════════════════════════════════════
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BG_COLOR);

        // ─── 2.1 顶栏 topPanel（放 NORTH）─┐
        // BoxLayout.Y_AXIS 让组件从上到下垂直排列
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new javax.swing.BoxLayout(topPanel, javax.swing.BoxLayout.Y_AXIS));
        topPanel.setBackground(BG_COLOR);
        // 四周留白：上 20px、左 30px、下 10px、右 30px，避免内容贴边
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        // 余额标签：22 号加粗微软雅黑，水平居中
        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        balanceLabel.setAlignmentX(CENTER_ALIGNMENT);  // 在 BoxLayout 中水平居中对齐
        refreshBalance();  // 从 shop 对象读取初始余额并格式化为 "余额：¥xxx.xx"
        topPanel.add(balanceLabel);
        // 在余额标签和下方按钮组之间插入 15px 的竖向间距
        topPanel.add(javax.swing.Box.createVerticalStrut(15));

        // 顶栏右侧按钮组（透明面板，FlowLayout 默认左到右排列）
        JPanel topButtons = new JPanel();
        topButtons.setOpaque(false);  // 透明：让背景色从父面板透出，不覆盖
        JButton animalsBtn = createButton("所拥有动物", 130, 40);
        JButton albumBtn = createButton("顾客纪念册", 130, 40);
        // 点击 [所拥有动物] → 弹出 AnimalsDialog
        animalsBtn.addActionListener(e -> showAnimals());
        // 点击 [顾客纪念册] → 弹出 CustomerAlbumDialog
        albumBtn.addActionListener(e -> showCustomerAlbum());
        topButtons.add(animalsBtn);
        topButtons.add(albumBtn);
        topPanel.add(topButtons);  // 按钮组加到 topPanel 底部

        // 顶栏整体放到 mainPanel 的 NORTH（上）区域
        mainPanel.add(topPanel, BorderLayout.NORTH);
        // ──────────────────────────────────────┘

        // ─── 2.2 下半区 lowerPanel（放 CENTER）─┐
        // 开业/购买动物两个大按钮，同样用 BoxLayout 垂直排列
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new javax.swing.BoxLayout(lowerPanel, javax.swing.BoxLayout.Y_AXIS));
        lowerPanel.setBackground(BG_COLOR);
        // 上下留白各 40px，左右 0（让水平居中生效）
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 40, 0));

        // [开业] 按钮：220×70 大尺寸，24 号加粗字体
        JButton openBtn = createButton("开业", 220, 70);
        openBtn.setFont(new Font("微软雅黑", Font.BOLD, 24));
        openBtn.addActionListener(e -> openBusiness());// 点击进入营业状态
        openBtn.setAlignmentX(CENTER_ALIGNMENT);
        lowerPanel.add(openBtn);
        lowerPanel.add(javax.swing.Box.createVerticalStrut(30));  // 两个大按钮之间 30px 间距

        // [购买动物] 按钮：同样大尺寸
        JButton purchaseBtn = createButton("购买动物", 220, 70);
        purchaseBtn.setFont(new Font("微软雅黑", Font.BOLD, 24));
        purchaseBtn.addActionListener(e -> showPurchase());  // 点击弹出进货界面
        purchaseBtn.setAlignmentX(CENTER_ALIGNMENT);
        lowerPanel.add(purchaseBtn);
        lowerPanel.add(javax.swing.Box.createVerticalStrut(50));

        JLabel JLabel1 = new JLabel("记得先购买动物再开业哦");
        JLabel JLabel2 = new JLabel("tip：可以先购买一种年龄的动物，以防记不住自己有什么");
        JLabel1.setFont(new Font("微软雅黑", Font.BOLD, 24));
        JLabel2.setFont(new Font("微软雅黑", Font.BOLD, 24));
        JLabel1.setAlignmentX(CENTER_ALIGNMENT);
        JLabel2.setAlignmentX(CENTER_ALIGNMENT);
        lowerPanel.add(JLabel1);
        lowerPanel.add(JLabel2);

        // 下半区整体放到 mainPanel 的 CENTER（中）区域，会吃掉剩余全部空间
        mainPanel.add(lowerPanel, BorderLayout.CENTER);
        // ──────────────────────────────────────┘

        // ═══════════════════════════════════════════
        // 步骤 3：将 mainPanel 加到分层面板的 DEFAULT_LAYER（底层）
        // ═══════════════════════════════════════════
        layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);

        // ═══════════════════════════════════════════
        // 步骤 4：构建 businessPanel（营业叠加层，初始隐藏）
        // ═══════════════════════════════════════════
        businessPanel = new BusinessPanel(shop, this);
        businessPanel.setVisible(false);  // 初始不可见，开业时才显示
        // PALETTE_LAYER 在 DEFAULT_LAYER 之上，所以显示时会覆盖 lowerPanel 区域
        layeredPane.add(businessPanel, JLayeredPane.PALETTE_LAYER);

        // ═══════════════════════════════════════════
        // 步骤 5：设置窗口属性
        // ═══════════════════════════════════════════
        setSize(FRAME_WIDTH, FRAME_HEIGHT);          // 固定大小 900×600
        setLocationRelativeTo(null);                  // null = 相对整个屏幕居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);      // 点 × → 整个 JVM 退出（而非仅仅隐藏窗口）
        getContentPane().setBackground(BG_COLOR);      // ContentPane（即 layeredPane）也设背景色

        // ═══════════════════════════════════════════
        // 步骤 6：注册窗口缩放监听
        // ═══════════════════════════════════════════
        // 当用户拖动窗口边角改变大小时，叠加层的位置需要重新计算，
        // 否则 businessPanel 会和 lowerPanel 错位
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                layoutOverlay();
            }
        });
        // 窗口首次显示后，也立即定位一次叠加层
        // invokeLater 把任务丢到 EDT（事件分发线程）队列末尾，
        // 确保组件布局完成后再执行 layoutOverlay
        SwingUtilities.invokeLater(this::layoutOverlay);
    }

    // ==================== 工具方法 ====================

    /**
     * 刷新余额显示。
     * <p>
     * 从 shop 对象读取当前余额，格式化为 "余额：¥xxx.xx" 显示到 balanceLabel 上。
     * 买入动物、卖出动物、歇业结算等操作后都会调用此方法。
     */
    public void refreshBalance() {
        String text = String.format("余额：¥%.2f", shop.getBalance());
        balanceLabel.setText(text);
    }

    /**
     * 定位叠加层（businessPanel）到 lowerPanel 的精确区域。
     * <p>
     * JLayeredPane 中的组件需要手动 setBounds 绝对定位（它不使用布局管理器），
     * 所以需要把 lowerPanel  面板  在 BorderLayout 中的位置"翻译"为 layeredPane 窗格 的坐标。
     * <p>
     * 执行两步：
     * <ol>
     *   <li>先让 mainPanel 填满整个 ContentPane 内容窗格 并触发 BorderLayout 重新布局
     *   <li>计算 lowerPanel 在 layeredPane 分层窗格 坐标系中的矩形位置，应用到 businessPanel</li>
     * </ol>
     */
    private void layoutOverlay() {
        // ① mainPanel 必须先显式设为占满整个 ContentPane，
        //    否则 BorderLayout 边界布局 不会正确计算子组件（lowerPanel）的位置
        mainPanel.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
        // revalidate() 通知 Swing "布局管理器，快重新计算位置！"
        mainPanel.revalidate();

        // ② 坐标转换：把 lowerPanel 相对于它父容器（mainPanel）的 bounds，
        //    转换成相对于 layeredPane 的绝对坐标
        Rectangle lowerBounds = SwingUtilities.convertRectangle(
                lowerPanel.getParent(),    // 源坐标系：lowerPanel 的父容器（即 mainPanel）
                lowerPanel.getBounds(),    // lowerPanel 在父容器中的位置和大小
                layeredPane);              // 目标坐标系：layeredPane

        // ③ 将 businessPanel 精确放到 lowerPanel 的位置上 → 实现"视觉覆盖"
        businessPanel.setBounds(lowerBounds);
    }

    /**
     * 工厂方法：创建一个风格统一的 JButton。
     * <p>
     * 设置了 preferredSize 和 maximumSize 双重限制，确保按钮在 BoxLayout 中
     * 保持指定宽高不被拉伸；关闭了 focusPainted（去掉选中时的虚线圈）。
     *
     * @param text 按钮上显示的文字
     * @param w    按钮宽度（像素）
     * @param h    按钮高度（像素）
     * @return 配置好的 JButton 实例
     */
    private JButton createButton(String text, int w, int h) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(w, h));  // 期望尺寸
        btn.setMaximumSize(new Dimension(w, h));    // 最大尺寸（防止 BoxLayout 拉伸）
        btn.setFont(new Font("微软雅黑", Font.PLAIN, 16));  // 普通 16 号微软雅黑
        btn.setFocusPainted(false);  // 去掉获得焦点时的虚线边框，UI 更干净
        return btn;
    }

    // ==================== 业务动作（按钮回调） ====================

    /**
     * 点击 [开业] 按钮时触发。
     * <p>
     * 完整营业启动流程：
     * <ol>
     *   <li>检查是否已在营业中（防止重复点击）</li>
     *   <li>从顾客名字池随机抽取今日顾客名单</li>
     *   <li>调用 shop.open() 切换到营业状态</li>
     *   <li>初始化 BusinessPanel 的顾客列表</li>
     *   <li>显示 businessPanel 叠加层</li>
     *   <li>把叠加层移到最前面（保险操作）</li>
     *   <li>重新定位叠加层（确保位置准确）</li>
     * </ol>
     */
    private void openBusiness() {
        // 防止重复开业：如果已经在营业中，弹提示并返回
        if (shop.isOpen()) {
            UiUtils.info(this, "已经在营业中啦");
            return;
        }
        // 从顾客名字池中随机抽取今日顾客名单（数量 = 每日最大顾客数）
        List<String> names = CustomerNamePool.pickRandom(MyAnimalShop.MAX_CUSTOMERS_PER_DAY);
        // 让宠物店进入营业状态（初始化今日日期、清空今日顾客名单等）
        shop.open();
        // 将顾客名单交给营业界面，让它开始逐一接待
        businessPanel.startDay(names);
        // 显示叠加层（JLayeredPane 的 PALETTE_LAYER 盖住 DEFAULT_LAYER 的下半区）
        businessPanel.setVisible(true);
        // 显式把叠加层移到最前（保险操作，防止其他组件遮挡）
        layeredPane.moveToFront(businessPanel);
        // 重新计算叠加层精确位置
        layoutOverlay();
    }

    /**
     * 歇业：由营业界面（BusinessPanel）在所有顾客都接待完后主动调用。
     * <p>
     * 完整歇业流程：
     * <ol>
     *   <li>隐藏营业叠加层</li>
     *   <li>调用 shop.close() 生成今日日报</li>
     *   <li>刷新余额（交易中余额有变化）</li>
     *   <li>弹出 SettlementDialog 显示日报</li>
     * </ol>
     */
    public void closeBusiness() {
        // 隐藏营业界面叠加层，露出下方原始的 lowerPanel
        businessPanel.setVisible(false);
        // 歇业结算：shop.close() 返回 DailyReport 对象（包含今日营收/支出/接待人数等）
        com.petstore.shop.DailyReport report = shop.close();
        // 歇业后余额可能因为交易变化，刷新顶栏显示
        refreshBalance();
        // 弹出结算对话框展示日报
        new SettlementDialog(this, report).setVisible(true);
    }

    /**
     * 弹出 AnimalsDialog：查看当前拥有的所有动物列表。
     * JDialog 以 this（主窗口）为 owner，模态显示。
     */
    private void showAnimals() {
        new AnimalsDialog(this, shop).setVisible(true);
    }

    /**
     * 弹出 CustomerAlbumDialog：查看顾客纪念册（所有历史顾客及其到店次数）。
     */
    private void showCustomerAlbum() {
        new CustomerAlbumDialog(this, shop).setVisible(true);
    }

    /**
     * 弹出 PurchaseDialog：从进货渠道购买新动物。
     * 对话框关闭后刷新顶栏余额（因为买动物花了钱）。
     */
    private void showPurchase() {
        new PurchaseDialog(this, shop).setVisible(true);
        // 进货可能成功（花了钱）也可能取消，但余额刷新无副作用
        refreshBalance();
    }
}