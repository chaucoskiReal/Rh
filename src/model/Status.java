package model;

public class Status {
    private Integer codigoStatus;
    private String descStatus;

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }


    public enum status{
        ABERTO,
        ANDAMENTO,
        CONCLUIDO;
    }
}

