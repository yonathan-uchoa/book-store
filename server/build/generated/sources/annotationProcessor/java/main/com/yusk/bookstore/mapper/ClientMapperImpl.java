package com.yusk.bookstore.mapper;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.dto.request.ClientPostRequestBody;
import com.yusk.bookstore.dto.request.ClientPutRequestBody;
import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.dto.response.ClientGetResponseBody;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T10:15:43-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
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
        clientDTO.setWishList( client.getWishList() );

        return clientDTO;
    }

    @Override
    public Client toClient(ClientPostRequestBody clientPostRequestBody) {
        if ( clientPostRequestBody == null ) {
            return null;
        }

        Client client = new Client();

        client.setName( clientPostRequestBody.getName() );
        client.setUsername( clientPostRequestBody.getUsername() );
        client.setPassword( clientPostRequestBody.getPassword() );

        return client;
    }

    @Override
    public Client toClient(ClientPutRequestBody clientPutRequestBody) {
        if ( clientPutRequestBody == null ) {
            return null;
        }

        Client client = new Client();

        client.setName( clientPutRequestBody.getName() );
        client.setPassword( clientPutRequestBody.getPassword() );

        return client;
    }

    @Override
    public ClientGetResponseBody toResponse(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientGetResponseBody clientGetResponseBody = new ClientGetResponseBody();

        clientGetResponseBody.setId( client.getId() );
        clientGetResponseBody.setName( client.getName() );
        clientGetResponseBody.setUsername( client.getUsername() );
        List<Address> list = client.getAddresses();
        if ( list != null ) {
            clientGetResponseBody.setAddresses( new ArrayList<Address>( list ) );
        }
        clientGetResponseBody.setWishList( client.getWishList() );

        return clientGetResponseBody;
    }

    @Override
    public void updateClient(ClientPutRequestBody clientPutRequestBody, Client client) {
        if ( clientPutRequestBody == null ) {
            return;
        }

        if ( clientPutRequestBody.getName() != null ) {
            client.setName( clientPutRequestBody.getName() );
        }
        if ( clientPutRequestBody.getPassword() != null ) {
            client.setPassword( clientPutRequestBody.getPassword() );
        }
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
        client.setWishList( clientDTO.getWishList() );

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
