package com.porto.logistica.service;

import com.porto.logistica.model.Movimentacoes;
import com.porto.logistica.repository.MovimentacoesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MovimentacoesService {

    @Autowired
    private MovimentacoesRepository repository;

    public List<Movimentacoes> todas(){
        return  repository.findAll();
    }

    public Movimentacoes buscaPorId(Integer id){
        Movimentacoes movimentacao = repository.findById(id).orElse(null);
        return  movimentacao;
    }
    public Movimentacoes salvar(Movimentacoes movimentacoes){
        Movimentacoes novaMovimentacao = repository.save(movimentacoes);
        return  novaMovimentacao;
    }
    public Movimentacoes editar(Integer id, Movimentacoes movimentacoes){
        Movimentacoes movimentacaoAlterar = buscaPorId(id);
        if(movimentacaoAlterar != null){
            BeanUtils.copyProperties(movimentacoes, movimentacaoAlterar, "id");
          movimentacaoAlterar =  repository.save(movimentacaoAlterar);
        }
        return movimentacaoAlterar;
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
