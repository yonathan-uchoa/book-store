package com.yusk.bookstore.dto;

import com.yusk.bookstore.model.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String surname;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;
    private Integer number;
}
