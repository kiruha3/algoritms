package com.stringlist.stringlist.stringlist;

public class FulllistExeption extends RuntimeException {
    public FulllistExeption(String введенныйIndexНеСуществует) {
    }

    public FulllistExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public FulllistExeption(Throwable cause) {
        super(cause);
    }

    public FulllistExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FulllistExeption() {
    }
}
