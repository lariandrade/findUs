package com.findus.findUs.controllers;

import com.findus.findUs.models.Usuario;
import com.findus.findUs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class LoginController {

    List<Usuario> usuarios = new ArrayList<>();

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

    @GetMapping("/paginadeedicaodoperfil")
    public ModelAndView paginaDeEdicaoDoPerfil() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editarperfil");
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

    @GetMapping("/editarperfil")
    public ModelAndView editarPerfil() {

        ModelAndView mv = new ModelAndView("editarperfil");

        return mv;
    }


    @GetMapping("/edit/{idUsuario}")
    @ResponseBody
    public String edit(@PathVariable("idUsuario") Long idUsuario , @ModelAttribute Usuario usuario, Model model) {


        usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"+ idUsuario));
        model.addAttribute("usuario", usuario);

        return "redirect:/editarperfil";
    }

    @PostMapping("/update/{idUsuario}")
    public String update(@PathVariable("idUsuario") Long idUsuario, Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            usuario.setIdUsuario(idUsuario);
            return "redirect:/editarperfil";
        }

        usuarioRepository.save(usuario);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "redirect:/perfil";
    }

    @GetMapping("/delete/{idUsuario}")
    public String deleteUser(@PathVariable("idUsuario") Long idUsuario, Model model) {



        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + idUsuario));
        usuarioRepository.delete(usuario);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/lista")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("usuarios", usuarioRepository.findAll());
        return mv;
    }

    @GetMapping("/confirmacaodaexclusao")
    public ModelAndView confirmarExclusao() {

        ModelAndView mv = new ModelAndView("confirmacaodaexclusao");
        return mv;
    }
}
