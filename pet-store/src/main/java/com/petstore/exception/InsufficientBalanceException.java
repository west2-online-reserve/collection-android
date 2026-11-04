package com.petstore.exception;

/**
 * 余额不足异常。
 * <p>
 * 买入动物时余额不足以支付进价时抛出。
 *
 * @author pet-store
 */
public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
