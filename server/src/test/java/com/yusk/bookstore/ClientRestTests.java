package com.yusk.bookstore;

import com.yusk.bookstore.dto.request.ClientPostRequestBody;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.rest.ClientRestController;
import com.yusk.bookstore.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

@ExtendWith(SpringExtension.class)
@MockBeans({@MockBean(AddressService.class), @MockBean(ViaCepService.class), @MockBean(BookService.class),
        @MockBean(ClientService.class), @MockBean(LibraryService.class), @MockBean(WishListService.class)})
@WebMvcTest(value = ClientRestController.class)
@WithMockUser
public class ClientRestTests {
    @Autowired
    private MockMvc mvc;
    @Mock
    private ClientService clientService;
    private AddressService addressService;
    private ViaCepService viaCepService;
    private BookService bookService;
    private LibraryService libraryService;
    private WishListService wishListService;

    @Test
    void save() throws Exception {
        Client clientMock = new Client();
        clientMock.setId(1);
        clientMock.setName("myName");
        clientMock.setPassword("myPassword");
        clientMock.setUsername("myUsername");

        String clientJson = "{\"id\":1,\"name\":\"myName\",\"username\":\"myUsername\",\"addresses\":[],\"wishList\":null}";

        ClientPostRequestBody clientRequest = new ClientPostRequestBody("myName", "myUsername", "myPassword");

        Mockito.when(clientService.save(Mockito.any(Client.class))).thenReturn(clientMock);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/client")
                .accept(MediaType.APPLICATION_JSON)
                .content(clientJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());

    }
}
