package com.yusk.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    @JsonBackReference
    private Client client;
    @Column(name = "surname")
    private String surname;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "ibge")
    private Integer ibge;
    @Column(name = "gia")
    private Integer gia;
    @Column(name = "ddd")
    private Integer ddd;
    @Column(name = "siafi")
    private Integer siafi;
    @Column(name = "number")
    private Integer number;

}
