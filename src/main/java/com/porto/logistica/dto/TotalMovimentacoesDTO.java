package com.porto.logistica.dto;

import com.porto.logistica.enun.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalMovimentacoesDTO {
    public String cliente;
    public TipoMovimentacao tipoMovimentacao;
    public Long id;
}
