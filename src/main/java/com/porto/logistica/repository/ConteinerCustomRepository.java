package com.porto.logistica.repository;

import com.porto.logistica.enun.CategoriaConteiner;
import com.porto.logistica.enun.StatusConteiner;
import com.porto.logistica.model.Conteiner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ConteinerCustomRepository {

    private final EntityManager em;
    public ConteinerCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Conteiner> filtroPesquisa(String cliente, String numero, Integer tipo, StatusConteiner status, CategoriaConteiner categoria){
        String query = "SELECT c FROM Conteiner c ";
        String condicao = " WHERE ";

        if(cliente != null){
            query += condicao + "c.cliente LIKE CONCAT('%', :cliente, '%')";
            condicao = " AND ";
        }
        if(numero != null){
            query += condicao + "c.numero = :numero ";
            condicao = " AND ";
        }
        if(tipo != null){
            query += condicao + "c.tipo = :tipo ";
            condicao = " AND ";
        }
        if(status != null){
            query += condicao + "c.status = :status";
            condicao = " AND ";
        }
        if(categoria != null){
            query += condicao + "c.categoria = :categoria";
            condicao = " AND ";
        }

        var q = em.createQuery(query, Conteiner.class);

        if(cliente != null){
           q.setParameter("cliente", cliente);
        }
        if(numero != null){
            q.setParameter("numero", numero);
        }

        if(tipo != null){
            q.setParameter("tipo", tipo);
        }

        if(status != null){
            q.setParameter("status", status);
        }
        if(categoria != null){
            q.setParameter("categoria", categoria);
        }
        return q.getResultList();
    }

}
