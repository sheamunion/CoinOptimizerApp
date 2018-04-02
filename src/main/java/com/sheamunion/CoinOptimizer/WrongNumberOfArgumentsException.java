package com.sheamunion.CoinOptimizer;

public class WrongNumberOfArgumentsException extends Throwable {
    private int errorCode;

    public WrongNumberOfArgumentsException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
