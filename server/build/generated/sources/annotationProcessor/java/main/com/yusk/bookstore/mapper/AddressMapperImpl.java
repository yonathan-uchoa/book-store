package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.request.AddressPostRequestBody;
import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T18:04:41-0400",
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

        return address;
    }

    @Override
    public Address toAddress(AddressPostRequestBody addressPostRequestBody) {
        if ( addressPostRequestBody == null ) {
            return null;
        }

        Address address = new Address();

        address.setSurname( addressPostRequestBody.getSurname() );
        address.setCep( addressPostRequestBody.getCep() );

        return address;
    }

    @Override
    public void updateAddress(AddressDTO addressDTO, Address address) {
        if ( addressDTO == null ) {
            return;
        }

        if ( addressDTO.getId() != null ) {
            address.setId( addressDTO.getId() );
        }
        if ( addressDTO.getSurname() != null ) {
            address.setSurname( addressDTO.getSurname() );
        }
        if ( addressDTO.getCep() != null ) {
            address.setCep( addressDTO.getCep() );
        }
        if ( addressDTO.getLogradouro() != null ) {
            address.setLogradouro( addressDTO.getLogradouro() );
        }
        if ( addressDTO.getComplemento() != null ) {
            address.setComplemento( addressDTO.getComplemento() );
        }
        if ( addressDTO.getBairro() != null ) {
            address.setBairro( addressDTO.getBairro() );
        }
        if ( addressDTO.getLocalidade() != null ) {
            address.setLocalidade( addressDTO.getLocalidade() );
        }
        if ( addressDTO.getUf() != null ) {
            address.setUf( addressDTO.getUf() );
        }
        if ( addressDTO.getIbge() != null ) {
            address.setIbge( addressDTO.getIbge() );
        }
        if ( addressDTO.getGia() != null ) {
            address.setGia( addressDTO.getGia() );
        }
        if ( addressDTO.getDdd() != null ) {
            address.setDdd( addressDTO.getDdd() );
        }
        if ( addressDTO.getSiafi() != null ) {
            address.setSiafi( addressDTO.getSiafi() );
        }
    }

    @Override
    public void updateAddress(AddressPostRequestBody addressPostRequestBody, Address address) {
        if ( addressPostRequestBody == null ) {
            return;
        }

        if ( addressPostRequestBody.getSurname() != null ) {
            address.setSurname( addressPostRequestBody.getSurname() );
        }
        if ( addressPostRequestBody.getCep() != null ) {
            address.setCep( addressPostRequestBody.getCep() );
        }
    }
}
