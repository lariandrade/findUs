package com.findus.findUs.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Tb_Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private Long id_Usuario;

    @Column(name = "userNome", length = 50, nullable = false)
    private String userNome;

    @Column(name = "userCPF_CNPJ", length = 14, nullable = false)
    private Integer userCPF_CNPJ;

    @Column(name = "userTelefone", length = 9, nullable = false)
    private Integer userTelefone;

    @Column(name = "userEmail", length = 50, nullable = false)
    private String userEmail;

    @Column(name = "userSenha", length = 8, nullable = false)
    private String userSenha;

    @Column(name = "confirmarSenha", length = 8, nullable = false)
    private String confirmarSenha;

    @Column(name = "razaoSocial", length = 50, nullable = false)
    private String razaoSocial;

    @Column(name = "segmento", length = 50, nullable = false)
    private String segmento;

    public Usuario() {

    }

    public Long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public Integer getUserCPF_CNPJ() {
        return userCPF_CNPJ;
    }

    public void setUserCPF_CNPJ(Integer userCPF_CNPJ) {
        this.userCPF_CNPJ = userCPF_CNPJ;
    }

    public Integer getUserTelefone() {
        return userTelefone;
    }

    public void setUserTelefone(Integer userTelefone) {
        this.userTelefone = userTelefone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }


}
