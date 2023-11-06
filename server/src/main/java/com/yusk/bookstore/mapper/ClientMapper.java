package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    AddressDTO map(Address value);
    @InheritInverseConfiguration(name = "dtoToClient")
    ClientDTO clientToDTO(Client client);

    @Mapping(target = "password", ignore = true)
    Client dtoToClient(ClientDTO clientDTO);


}
