package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.patch.NoOp;
import com.ppinto.springsandbox.patch.Patch;
import com.ppinto.springsandbox.patch.ReplaceOp;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull"})
public class MappingHelper {

    @SuppressWarnings("unchecked")
    public static <S, T extends Patch<?>> T convertToPatch(Optional<S> source, Converter<S, T> converter) {
        if (source == null) return (T) NoOp.instance();
        if (source.isEmpty()) return (T) ReplaceOp.of(null);
        return converter.convert(source.get());
    }
}
