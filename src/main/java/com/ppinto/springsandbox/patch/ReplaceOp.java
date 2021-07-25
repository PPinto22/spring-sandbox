package com.ppinto.springsandbox.patch;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReplaceOp<T> implements Patch<T> {

    private final T newValue;

    public static <T> ReplaceOp<T> of(T newValue) {
        return new ReplaceOp<>(newValue);
    }

    @Override
    public T apply(T oldValue) {
        return newValue;
    }
}

