package com.porto.logistica.repository.container;

import com.porto.logistica.enun.StatusConteiner;
import com.porto.logistica.model.Conteiner;
import com.porto.logistica.repository.filter.ContainerFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ConteinerRepositoryImpl implements ConteinerRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Conteiner> filtrar(ContainerFilter containerFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Conteiner> criteria = builder.createQuery(Conteiner.class);
        Root<Conteiner> root = criteria.from(Conteiner.class);

        Predicate[] predicates = criarRestricoes(containerFilter, builder, root);
        criteria.where(predicates);
        TypedQuery<Conteiner> query = manager.createQuery(criteria);
        return  query.getResultList();
    }

    private Predicate[] criarRestricoes(ContainerFilter containerFilter, CriteriaBuilder builder, Root<Conteiner> root) {
        List<Predicate> predicates = new ArrayList<>();
        if(containerFilter.getCliente() != null){
            predicates.add(builder.like(builder.lower(root.get("cliente")), "%" +containerFilter.getCliente()+ "%"));
        }
        if(containerFilter.getNumero() != null){
            predicates.add(builder.equal(builder.lower(root.get("numero")), containerFilter.getNumero()));
        }
        if(containerFilter.getTipo() != null){
            predicates.add(builder.equal(builder.lower(root.get("tipo")), containerFilter.getTipo()));
        }
        if(containerFilter.getStatus() != null){
            predicates.add(builder.equal(builder.lower(root.get("status")), containerFilter.getStatus()));
        }
        if(containerFilter.getCategoria() != null){
            predicates.add(builder.equal(builder.lower(root.get("categoria")), containerFilter.getCategoria()));
        }
        return  predicates.toArray(new Predicate[predicates.size()]);
    }
}
