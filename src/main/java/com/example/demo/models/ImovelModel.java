package com.example.demo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "imoveis")
@Getter
@Setter
public class ImovelModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(columnDefinition = "text")
    private String descricao;

    @Column(name = "preco_venda", precision = 15, scale = 2)
    private BigDecimal precoVenda;

    @Column(name = "preco_aluguel", precision = 15, scale = 2)
    private BigDecimal precoAluguel;

    private String finalidade;
    private String status;

    private Integer dormitorios;
    private Integer banheiros;
    private Integer garagem;

    @Column(name = "area_total", precision = 15, scale = 2)
    private BigDecimal areaTotal;

    @Column(name = "area_construida", precision = 15, scale = 2)
    private BigDecimal areaConstruida;

    private String endereco;

    // numero é VARCHAR(255) no banco
    private String numero;

    private String complemento;

    // cep é VARCHAR(255)
    private String cep;

    @Column(columnDefinition = "text")
    private String caracteristicas;

    // destaque é tinyint(1) → BOOLEAN
    private Boolean destaque;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_imovel_id")
    private TipoImovelModel tipoImovel;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bairro_id")
    private BairroModel bairro;
}
