package com.bolsaideas.springboot.web.app.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bolsaideas.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Campos");
		usuario.setEmail("gonzalo@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPerfil);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andrés","Guzmán","andres@gmail.com"));
		usuarios.add(new Usuario("Gonzalo","Campos","gon@gmail.com"));
		usuarios.add(new Usuario("Iria","Cruz","iria@gmail.com"));
		usuarios.add(new Usuario("Tornado","Roe","tornado@gmail.com"));
		model.addAttribute("titulo",textoListar);
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andrés","Guzmán","andres@gmail.com"));
		usuarios.add(new Usuario("Gonzalo","Campos","gon@gmail.com"));
		usuarios.add(new Usuario("Iria","Cruz","iria@gmail.com"));
		usuarios.add(new Usuario("Tornado","Roe","tornado@gmail.com"));
		return usuarios;
	}
	
}
