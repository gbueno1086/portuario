package com.porto.logistica.model;

import com.porto.logistica.enun.CategoriaConteiner;
import com.porto.logistica.enun.StatusConteiner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "conteiner")
public class Conteiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Nome do Cliente é obrigatório!")
    @Column(name = "cliente")
    private String cliente;

    @NotEmpty(message = "Numero do Conteiner não pode estar vazio")
    @Column(name = "numero_conteiner" )
    private String numero;

    @Column(name = "tipo_conteiner" )
    private Integer tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_conteiner" )
    private StatusConteiner status;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_conteiner" )
    private CategoriaConteiner categoria;



}
