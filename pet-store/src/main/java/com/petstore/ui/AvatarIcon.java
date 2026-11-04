package com.petstore.ui;

import javax.swing.Icon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * 程序绘制的顾客头像（彩色圆形 + 姓名首字）。
 *
 * @author pet-store
 */
public class AvatarIcon implements Icon {

    private static final Color[] COLORS = {
            new Color(255, 154, 158),
            new Color(255, 196, 132),
            new Color(250, 234, 145),
            new Color(170, 230, 166),
            new Color(133, 210, 230),
            new Color(180, 170, 255),
            new Color(240, 160, 230),
            new Color(160, 210, 200)
    };

    private final int size;
    private final Color color;
    private final String text;

    public AvatarIcon(String name, int size) {
        this.size = size;
        this.color = COLORS[Math.abs(name.hashCode()) % COLORS.length];
        //name.hashCode是把一个字符串转换成一个哈希值
        //在Java中每一个字符串都可以计算得出一个哈希值，且唯一确定
        //Math.abs表示取绝对值，%8最多余7，正好对应0-7索引

        this.text = name.isEmpty() ? "?" : name.substring(0, 1);

        //截取名字的第一个字
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        //Graphics是画笔的意思

        Graphics2D g2 = (Graphics2D) g.create();

        //根据原画笔创建一个副本，避免销毁原数据

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //这是打开了一个开关，然后又打开了抗锯齿，变成圆形

        g2.setColor(color);
        g2.fillOval(x, y, size, size);

        //x是左边距，y是上边距，后面两个分别是宽和高
        //fillOval表示填充，这里画了一个圆

        g2.setColor(Color.WHITE);

        //画笔选择为白色

        g2.setFont(g2.getFont().deriveFont((float) size * 0.5f));

        //拿到g2原本的字体，修改一下字号再赋给g2

        int textX = x + size / 2 - g2.getFontMetrics().stringWidth(text) / 2;
        int textY = y + size / 2 + g2.getFontMetrics().getAscent() / 3;

        //这里进行了一些神秘操作使得文字居中

        g2.drawString(text, textX, textY);

        g2.dispose();

        //创造后必须销毁
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }
}
