package com.petstore.ui;

import javax.swing.JOptionPane;
import java.awt.Component;

/**
 * UI 工具类。
 *
 * @author pet-store
 */
public final class UiUtils {

    private UiUtils() {
    }

    /**
     * 显示信息提示框。
     */
    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 显示成功提示框。
     */
    public static void success(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "成功", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * 显示错误提示框。
     */
    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "错误", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * 显示确认对话框。
     *
     * @return true 表示用户选择"是"
     */
    public static boolean confirm(Component parent, String message) {
        return JOptionPane.showConfirmDialog(parent, message, "确认",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    /**
     * 计算字符串在等宽字体下的显示宽度。
     * <p>
     * 英文/数字/标点每个占 1 个宽度单位；
     * 中文字符、全角符号每个占 2 个宽度单位。
     * 不能直接用 {@link String#length()}，因为它返回的是 UTF-16 编码单元数，
     * 一个中文字符在 UTF-16 里也是 1 个 char，但显示时宽度是 2。
     *
     * @param s 待测量的字符串
     * @return 显示宽度
     */
    public static int displayWidth(String s) {
        int width = 0;
        // 用 codePointAt 遍历 Unicode 码点，避免 emoji 等占 2 个 char 的字符被算错
        for (int i = 0; i < s.length(); ) {
            int codePoint = s.codePointAt(i);
            // 码点 > 127 的都是非 ASCII 字符（中文、日文等），显示宽度翻倍
            width += (codePoint > 127) ? 2 : 1;
            // charCount 返回该码点在 UTF-16 中占几个 char（通常是 1，emoji 是 2）
            i += Character.charCount(codePoint);
        }
        return width;
    }

    /**
     * 把字符串按显示宽度右补空格，使其总宽度恰好等于 targetWidth。
     * <p>
     * 如果原字符串显示宽度已经 >= targetWidth，直接返回原串不截断。
     *
     * @param s           原字符串
     * @param targetWidth 目标显示宽度
     * @return 补齐后的字符串
     */
    public static String padRight(String s, int targetWidth) {
        // 需要补多少个空格 = 目标宽度 - 实际显示宽度
        int padding = targetWidth - displayWidth(s);
        if (padding <= 0) {
            // 已经够宽或超出，返回原串（不截断，防止字段加长后显示不全）
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < padding; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}