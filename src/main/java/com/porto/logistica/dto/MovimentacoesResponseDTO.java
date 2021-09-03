package com.porto.logistica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.porto.logistica.enun.CategoriaConteiner;
import com.porto.logistica.enun.StatusConteiner;
import com.porto.logistica.enun.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MovimentacoesResponseDTO {
    private String cliente;
    private String numero;
    private Integer tipo;
    private StatusConteiner status;
    private CategoriaConteiner categoria;
    private TipoMovimentacao tipoMovimentacao;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHoraInicio;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHoraFim;
}
