package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-05T19:08:34-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO addressToDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setSurname( address.getSurname() );
        addressDTO.setCep( address.getCep() );
        addressDTO.setLogradouro( address.getLogradouro() );
        addressDTO.setComplemento( address.getComplemento() );
        addressDTO.setBairro( address.getBairro() );
        addressDTO.setLocalidade( address.getLocalidade() );
        addressDTO.setUf( address.getUf() );
        addressDTO.setIbge( address.getIbge() );
        addressDTO.setGia( address.getGia() );
        addressDTO.setDdd( address.getDdd() );
        addressDTO.setSiafi( address.getSiafi() );
        addressDTO.setNumber( address.getNumber() );

        return addressDTO;
    }

    @Override
    public Address dtoToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setSurname( addressDTO.getSurname() );
        address.setCep( addressDTO.getCep() );
        address.setLogradouro( addressDTO.getLogradouro() );
        address.setComplemento( addressDTO.getComplemento() );
        address.setBairro( addressDTO.getBairro() );
        address.setLocalidade( addressDTO.getLocalidade() );
        address.setUf( addressDTO.getUf() );
        address.setIbge( addressDTO.getIbge() );
        address.setGia( addressDTO.getGia() );
        address.setDdd( addressDTO.getDdd() );
        address.setSiafi( addressDTO.getSiafi() );
        address.setNumber( addressDTO.getNumber() );

        return address;
    }
}
