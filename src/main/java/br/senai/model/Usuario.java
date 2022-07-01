package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @Column(unique = true)
    private Long id;

    @Size(max = 50)
    @NotNull
    private String nome;

    @Size(max = 50)
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max = 50)
    private String nicho;

    @Size(max = 255)
    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(
            name = "usuario_permissao",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id")
    )
    private List<Permissao> permissoes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNicho() {
        return nicho;
    }
    public void setNicho(String nicho) {
        this.nicho = nicho;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Permissao> getPermissoes() {
        return permissoes;
    }
    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeEmpresa='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", nicho='" + nicho + '\'' +
                ", password='" + password + '\'' +
                ", permissoes=" + permissoes +
                '}';
    }
}