package model;

import java.time.LocalDate;

public class ProcessoSeletivo {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer codigoProcessoSeletivo;
    private String descStatusProcesso;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getCodigoProcessoSeletivo() {
        return codigoProcessoSeletivo;
    }

    public void setCodigoProcessoSeletivo(Integer codigoProcessoSeletivo) {
        this.codigoProcessoSeletivo = codigoProcessoSeletivo;
    }

    public String getDescStatusProcesso() {
        return descStatusProcesso;
    }

    public void setDescStatusProcesso(String descStatusProcesso) {
        this.descStatusProcesso = descStatusProcesso;
    }
}
