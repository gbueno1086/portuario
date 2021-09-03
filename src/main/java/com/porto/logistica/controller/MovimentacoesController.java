package com.porto.logistica.controller;

import com.porto.logistica.dto.MovimentacoesResponseDTO;
import com.porto.logistica.dto.TotalMovimentacoesDTO;
import com.porto.logistica.model.Movimentacoes;
import com.porto.logistica.repository.MovimentacoesRepository;
import com.porto.logistica.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacoesRepository repository;

    @Autowired
    private MovimentacoesService service;

    @GetMapping
    public List<MovimentacoesResponseDTO> find(){
        return  repository.todasMovimentacoes();
    }

    @GetMapping("/{id}")
    public Movimentacoes buscaId(@PathVariable Integer id){
        Movimentacoes movimentacao = service.buscaPorId(id);
        return  movimentacao;
    }
    @GetMapping("/total")
    public List<TotalMovimentacoesDTO> movimentacoes(){
        return repository.totalMovimentacoes();
    }

    @PostMapping
    public Movimentacoes salva(@Valid @RequestBody Movimentacoes movimentacoes){
        Movimentacoes nova = service.salvar(movimentacoes);
        return nova;
    }

    @PutMapping("/{id}")
    public Movimentacoes editar(@PathVariable Integer id, @Valid @RequestBody Movimentacoes movimentacoes){
        Movimentacoes movimentacaoeditada = service.editar(id,movimentacoes);
        return movimentacaoeditada;
    }
    @DeleteMapping("/{id}")
    public Integer deletar(@PathVariable Integer id){
        service.deletar(id);
        return id;
    }



}
