package com.findus.findUs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.findus.findUs.models.Usuario;
import com.findus.findUs.repository.UsuarioRepository;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return repository.findAll();
    }

    @GetMapping("/usuario/{id_Usuario}")
    public Optional<Usuario> listaUsuarioUnico(@PathVariable(value="id_Usuario") Long id_Usuario) {
        return repository.findById(id_Usuario);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro") 
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarusuario")
    public String salvaUsuario(Usuario usuario) {

        repository.save(usuario);
        return "cadastrofinalizado";
    }

    @DeleteMapping("/usuario")
    public void deletaProduto(@RequestBody Usuario usuario) {
        repository.delete(usuario);
    }

    @PutMapping("/usuario")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }
}
