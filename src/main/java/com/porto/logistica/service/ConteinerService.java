package com.porto.logistica.service;

import com.porto.logistica.exception.NumeroConteinerInvalidoException;
import com.porto.logistica.exception.NumeroConteinerJaExisteException;
import com.porto.logistica.model.Conteiner;
import com.porto.logistica.repository.ConteinerRepository;
import com.porto.logistica.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConteinerService {

    @Autowired
    private ConteinerRepository repository;

    public List<Conteiner> todos(){
        return repository.findAll();
    }

    public Conteiner buscaPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
    public Conteiner salvar(Conteiner conteiner){
        Conteiner novo = new Conteiner();
        if(!Utils.validaNumeroConteiner(conteiner.getNumero())){
            throw new NumeroConteinerInvalidoException("Numero do Container não é valido!");
        }
        novo = repository.findByNumero(conteiner.getNumero());
        if(novo != null){
            throw  new NumeroConteinerJaExisteException("O Conteiner Numero:  "+conteiner.getNumero()+ " já está cadastrado!");
        }
        novo = repository.save(conteiner);
        return novo;
    }

    public Conteiner alterar(Integer id, Conteiner conteiner){
        Conteiner conteinerAlterar = buscaPorId(id);
        if(conteinerAlterar != null){
            BeanUtils.copyProperties(conteiner, conteinerAlterar, "id");
            repository.save(conteinerAlterar);
        }
        return conteinerAlterar;
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
