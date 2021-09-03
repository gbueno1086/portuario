package com.porto.logistica.repository;

import com.porto.logistica.model.Conteiner;
import com.porto.logistica.repository.container.ConteinerRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConteinerRepository extends JpaRepository<Conteiner, Integer>, ConteinerRepositoryQuery {

    @Query("SELECT c FROM Conteiner c WHERE c.numero = :numero")
    Conteiner findByNumero(String numero);


}
