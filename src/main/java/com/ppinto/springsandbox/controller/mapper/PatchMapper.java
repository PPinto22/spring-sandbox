package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.patch.Patch;
import com.ppinto.springsandbox.patch.ReplaceOp;
import org.mapstruct.Mapper;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mapper(componentModel = "spring")
public interface PatchMapper {

    default <T> Patch<T> toPatch(Optional<T> optional) {
        return MappingHelper.convertToPatch(optional, ReplaceOp::of);
    }

}
