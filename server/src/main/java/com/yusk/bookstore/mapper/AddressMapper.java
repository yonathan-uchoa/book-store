package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.AddressPostRequestBody;
import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.model.Address;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ClientMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @InheritInverseConfiguration(name = "dtoToAddress")
    AddressDTO addressToDTO(Address address);
    @Mapping(target = "client", ignore = true)
    Address dtoToAddress(AddressDTO addressDTO);

    Address toAddress (AddressPostRequestBody addressPostRequestBody);

    void updateAddress (AddressDTO addressDTO, @MappingTarget Address address);

    void updateAddress (AddressPostRequestBody addressPostRequestBody, @MappingTarget Address address);
}
