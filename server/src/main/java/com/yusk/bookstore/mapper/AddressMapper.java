package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.model.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @InheritInverseConfiguration(name = "dtoToAddress")
    AddressDTO addressToDTO(Address address);
    @Mapping(target = "client", ignore = true)
    Address dtoToAddress(AddressDTO addressDTO);
}
