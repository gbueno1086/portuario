package com.porto.logistica.repository;

import com.porto.logistica.dto.MovimentacoesResponseDTO;
import com.porto.logistica.dto.TotalMovimentacoesDTO;
import com.porto.logistica.model.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Integer> {

    @Query(value = "SELECT new com.porto.logistica.dto.TotalMovimentacoesDTO(c.cliente, m.tipoMovimentacao, count(m.id) as total)" +
            "FROM Movimentacoes m JOIN m.conteiner c  GROUP BY c.cliente, m.tipoMovimentacao")
    List<TotalMovimentacoesDTO> totalMovimentacoes();


    @Query(value = "SELECT new com.porto.logistica.dto.MovimentacoesResponseDTO(c.cliente, c.numero, c.tipo, c.status, c.categoria, m.tipoMovimentacao, m.dataHoraInicio, m.dataHoraFim)" +
            "FROM Movimentacoes m JOIN m.conteiner c")
    List<MovimentacoesResponseDTO> todasMovimentacoes();
}
