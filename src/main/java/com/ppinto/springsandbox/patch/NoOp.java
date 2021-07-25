package com.ppinto.springsandbox.patch;

public class NoOp<T> implements Patch<T> {

    private static final NoOp<Object> INSTANCE = new NoOp<>();

    private NoOp() {
    }

    @SuppressWarnings("unchecked")
    public static <T> NoOp<T> instance() {
        return (NoOp<T>) INSTANCE;
    }

    @Override
    public T apply(T oldValue) {
        return oldValue;
    }
}
