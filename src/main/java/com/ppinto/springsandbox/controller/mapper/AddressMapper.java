package com.ppinto.springsandbox.controller.mapper;

import com.ppinto.springsandbox.controller.dto.AddressDto;
import com.ppinto.springsandbox.model.Address;
import com.ppinto.springsandbox.patch.Patch;
import com.ppinto.springsandbox.patch.ReplaceOp;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);

    List<Address> toAddressList(List<AddressDto> addressDtos);

    default Patch<List<Address>> toPatch(Optional<List<AddressDto>> addressDtos) {
        return MappingHelper.convertToPatch(addressDtos, source -> ReplaceOp.of(toAddressList(source)));
    }
}
