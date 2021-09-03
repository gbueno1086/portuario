package com.porto.logistica.controller;

import com.porto.logistica.enun.CategoriaConteiner;
import com.porto.logistica.enun.StatusConteiner;
import com.porto.logistica.model.Conteiner;
import com.porto.logistica.repository.ConteinerCustomRepository;
import com.porto.logistica.repository.ConteinerRepository;
import com.porto.logistica.repository.filter.ContainerFilter;
import com.porto.logistica.service.ConteinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/conteiners")
public class ConteinerController {

    @Autowired
    private ConteinerService service;

    @Autowired
    private  ConteinerRepository repository;

    private  final ConteinerCustomRepository conteinerCustomRepository;
    public ConteinerController(ConteinerCustomRepository conteinerCustomRepository) {
        this.conteinerCustomRepository = conteinerCustomRepository;
    }

    @GetMapping
    public List<Conteiner> pesquisar(ContainerFilter containerFilter){
        return  repository.filtrar(containerFilter);
    }

    @GetMapping("/fitro")
    public List<Conteiner> fitros(@RequestParam(value = "cliente", required = false)String cliente,
                                  @RequestParam(value = "numero", required = false)String numero,
                                  @RequestParam(value = "tipo", required = false)Integer tipo,
                                  @RequestParam(value = "status", required = false) StatusConteiner status,
                                  @RequestParam(value = "categoria", required = false) CategoriaConteiner categoria){
        return this.conteinerCustomRepository.filtroPesquisa(cliente, numero, tipo, status, categoria);
    }

    @GetMapping("/{id}")
    public Conteiner buscaId(@PathVariable Integer id){
        return  service.buscaPorId(id);
    }

    @PostMapping
    public Conteiner salvar(@Valid @RequestBody Conteiner conteiner){
        Conteiner novo = service.salvar(conteiner);
        return novo;
    }

    @PutMapping("/{id}")
    public Conteiner editar(@PathVariable Integer id, @RequestBody Conteiner conteiner){
        Conteiner editado = service.alterar(id, conteiner);
        return editado;
    }

    @DeleteMapping("/{id}")
    public Integer deletar(@PathVariable Integer id){
        service.deletar(id);
        return id;
    }
}
