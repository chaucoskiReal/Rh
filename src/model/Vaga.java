package model;

public class Vaga extends Status {
    private Integer codigoVaga;
    private String descVaga;
    private String descRequisitos;

    public Integer getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(Integer codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public String getDescVaga() {
        return descVaga;
    }

    public void setDescVaga(String descVaga) {
        this.descVaga = descVaga;
    }

    public String getDescRequisitos() {
        return descRequisitos;
    }

    public void setDescRequisitos(String descRequisitos) {
        this.descRequisitos = descRequisitos;
    }
}
