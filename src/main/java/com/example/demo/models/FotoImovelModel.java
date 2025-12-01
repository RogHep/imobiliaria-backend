package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos_imovel")
public class FotoImovelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeArquivo;

    private String caminho;

    private String capa; // S ou N

    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelModel imovel;

    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNomeArquivo() { return nomeArquivo; }
    public void setNomeArquivo(String nomeArquivo) { this.nomeArquivo = nomeArquivo; }

    public String getCaminho() { return caminho; }
    public void setCaminho(String caminho) { this.caminho = caminho; }

    public String getCapa() { return capa; }
    public void setCapa(String capa) { this.capa = capa; }

    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }

    public ImovelModel getImovel() { return imovel; }
    public void setImovel(ImovelModel imovel) { this.imovel = imovel; }
}
