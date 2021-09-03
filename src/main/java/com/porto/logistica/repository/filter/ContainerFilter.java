package com.porto.logistica.repository.filter;

import com.porto.logistica.enun.CategoriaConteiner;
import com.porto.logistica.enun.StatusConteiner;
import lombok.Data;

@Data
public class ContainerFilter {
    private String cliente;
    private String numero;
    private Integer tipo;
    private StatusConteiner status;
    private CategoriaConteiner categoria;
}
