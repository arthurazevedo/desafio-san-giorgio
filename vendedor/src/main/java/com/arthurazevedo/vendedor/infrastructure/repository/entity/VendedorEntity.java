package com.arthurazevedo.vendedor.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_VENDEDOR")
public class VendedorEntity {

    @Id
    private Long codigo;
    private String cpfCnpj;
    private String nome;
}
