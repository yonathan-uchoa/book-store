package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.model.WishList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-08T01:36:11-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public AddressDTO map(Address value) {
        if ( value == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( value.getId() );
        addressDTO.setSurname( value.getSurname() );
        addressDTO.setCep( value.getCep() );
        addressDTO.setLogradouro( value.getLogradouro() );
        addressDTO.setComplemento( value.getComplemento() );
        addressDTO.setBairro( value.getBairro() );
        addressDTO.setLocalidade( value.getLocalidade() );
        addressDTO.setUf( value.getUf() );
        addressDTO.setIbge( value.getIbge() );
        addressDTO.setGia( value.getGia() );
        addressDTO.setDdd( value.getDdd() );
        addressDTO.setSiafi( value.getSiafi() );
        addressDTO.setNumber( value.getNumber() );

        return addressDTO;
    }

    @Override
    public ClientDTO clientToDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setName( client.getName() );
        clientDTO.setUsername( client.getUsername() );
        clientDTO.setAddresses( addressListToAddressDTOList( client.getAddresses() ) );
        List<WishList> list1 = client.getWishLists();
        if ( list1 != null ) {
            clientDTO.setWishLists( new ArrayList<WishList>( list1 ) );
        }

        return clientDTO;
    }

    @Override
    public Client dtoToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setName( clientDTO.getName() );
        client.setUsername( clientDTO.getUsername() );
        client.setAddresses( addressDTOListToAddressList( clientDTO.getAddresses() ) );
        List<WishList> list1 = clientDTO.getWishLists();
        if ( list1 != null ) {
            client.setWishLists( new ArrayList<WishList>( list1 ) );
        }

        return client;
    }

    protected List<AddressDTO> addressListToAddressDTOList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDTO> list1 = new ArrayList<AddressDTO>( list.size() );
        for ( Address address : list ) {
            list1.add( map( address ) );
        }

        return list1;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
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

    protected List<Address> addressDTOListToAddressList(List<AddressDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDTO addressDTO : list ) {
            list1.add( addressDTOToAddress( addressDTO ) );
        }

        return list1;
    }
}
