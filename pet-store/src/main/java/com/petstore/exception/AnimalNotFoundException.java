package com.petstore.exception;

/**
 * 没找到动物异常。
 * <p>
 * 店内没有动物可买时抛出。
 *
 * @author pet-store
 */
public class AnimalNotFoundException extends RuntimeException {
    //自定义异常，继承自运行时异常
    public AnimalNotFoundException(String message) {
        super(message);
    }
    //super（message）的用法示例：
    //if……throw new AnimalNotFoundException（“…………”）
    //抛出“…………”的内容
}
