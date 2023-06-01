package com.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.modelo.Persona;

@Controller
public class ThymeleafController {

	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "¡Hola desde el controlador!");
        return "home"; //Hace referencia al html
    }
	
	@GetMapping("/personas")
    public String personas(Model model) { 
        List<Persona> personas = getPersonas(); // Obtener la lista de personas (puede ser desde una base de datos o cualquier otra fuente de datos)

        model.addAttribute("personas", personas);
        return "personas";
    }
		
	 private List<Persona> getPersonas() {
	        List<Persona> personas = new ArrayList<>();
	        personas.add(new Persona("Juan", "Perez"));
	        personas.add(new Persona("Javier", "Ereña"));
	        personas.add(new Persona("Ana", "Garcia"));
	        return personas;
	    }
}
