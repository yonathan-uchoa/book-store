package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.dto.request.ClientPostRequestBody;
import com.yusk.bookstore.dto.request.ClientPutRequestBody;
import com.yusk.bookstore.dto.response.ClientGetResponseBody;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    AddressDTO map(Address value);
    @InheritInverseConfiguration(name = "dtoToClient")
    ClientDTO clientToDTO(Client client);

    // Map to client
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "wishList", ignore = true)
    @Mapping(target = "password", source = "password")
    Client toClient (ClientPostRequestBody clientPostRequestBody);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "wishList", ignore = true)
    Client toClient(ClientPutRequestBody clientPutRequestBody);
    // -----------------------------------------
    // Map to response
    ClientGetResponseBody toResponse (Client client);
    // -----------------------------------------
    // Update methods
    @InheritConfiguration(name = "toClient")
    void updateClient(ClientPutRequestBody clientPutRequestBody, @MappingTarget Client client);

    @Mapping(target = "password", ignore = true)
    Client dtoToClient(ClientDTO clientDTO);
}
