package com.findus.findUs.controllers;

import com.findus.findUs.models.Usuario;
import com.findus.findUs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    @GetMapping("/perfil")
    public ModelAndView perfil() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("perfil");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    @GetMapping("/errologin")
    public String errologin() {
        return "errologin";
    }

    @PostMapping("/efetuarlogin")
    public ModelAndView efetuarLogin(Usuario usuario, BindingResult br, RedirectAttributes ra, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        if (br.hasErrors()) {
            modelAndView.setViewName("errologin");
        }

        Usuario userEmail = usuarioRepository.findByuserEmail(usuario.getUserEmail());
        Usuario userSenha = usuarioRepository.findByuserSenha(usuario.getUserSenha());
        if (userEmail != null && userSenha != null) {
            session.setAttribute("usuarioLogado", userEmail);
            return perfil();
        } else {
            modelAndView.addObject("msg", "Email ou senha não encontrado. Tente novamente");
        }
        return modelAndView;
    }
}
