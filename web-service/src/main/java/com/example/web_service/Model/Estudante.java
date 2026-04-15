package com.example.web_service.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Estudante {
    @Id@GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String nascimento;
    private Integer anoIngresso;

    public Estudante() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public Integer getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(Integer anoIngresso) { this.anoIngresso = anoIngresso; }
}