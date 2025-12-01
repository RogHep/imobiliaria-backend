package com.example.demo.Dtos;

public class FotoImovelDTO {

    private String capa; // "S" ou "N"
    private Integer ordem;
    private Integer imovelId;

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getImovelId() {
        return imovelId;
    }

    public void setImovelId(Integer imovelId) {
        this.imovelId = imovelId;
    }
}
