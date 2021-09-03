package com.porto.logistica.repository.container;

import com.porto.logistica.model.Conteiner;
import com.porto.logistica.repository.filter.ContainerFilter;

import java.util.List;

public interface ConteinerRepositoryQuery {
    List<Conteiner> filtrar(ContainerFilter containerFilter);
}
