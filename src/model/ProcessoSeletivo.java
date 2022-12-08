package model;

import java.time.LocalDate;

public class ProcessoSeletivo {

    private Integer codigoProcessoSeletivo;
    private String descStatusProcesso;

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
