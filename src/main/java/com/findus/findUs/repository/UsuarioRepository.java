package com.findus.findUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findus.findUs.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select e from Usuario e where e.userEmail = :userEmail")
    public Usuario findByuserEmail(String userEmail);

    @Query("select s from Usuario s where s.userSenha = :userSenha")
    public Usuario findByuserSenha(String userSenha);
}
