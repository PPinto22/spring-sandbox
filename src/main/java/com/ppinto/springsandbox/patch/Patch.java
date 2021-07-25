package com.ppinto.springsandbox.patch;

public interface Patch<T> {

    T apply(T oldValue);
}
