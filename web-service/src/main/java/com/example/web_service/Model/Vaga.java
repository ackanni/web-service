package com.example.web_service.model;

public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private Boolean ativo;
    private Long idEmpresa;

    public Vaga() {
    }

    public Vaga(Long id, String titulo, String descricao, String publicacao, Boolean ativo, Long idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPublicacao() { return publicacao; }
    public void setPublicacao(String publicacao) { this.publicacao = publicacao; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public Long getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Long idEmpresa) { this.idEmpresa = idEmpresa; }
}