package com.example.HolaSpring.web;

import java.security.Principal;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.HolaSpring.domain.Persona;
import com.example.HolaSpring.servicio.PersonaService;

@Controller
@SessionAttributes("persona")
public class ControladorInicio implements ErrorController {

	private static Integer con = 0;
	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model) {
		List<Persona> personas = (List<Persona>) personaService.listarpersonas();
		Collections.sort(personas);
		model.addAttribute("personas", personas);
		double saldoTotal = 0;
		for (Persona persona : personas) {
			saldoTotal += persona.getSaldo();
		}

		model.addAttribute("saldoTotal", saldoTotal);
		model.addAttribute("conta", con);
		model.addAttribute("totalClientes", personas.size());

		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errors, Model model,SessionStatus status) {
		if (errors.hasErrors()) {
			return "redirect:/";
		}
		con = 1;
		model.addAttribute("conta", con);
		personaService.guardar(persona);
		status.isComplete();
		return "redirect:/";
	}

	@GetMapping("/editar/{idPersona}")
	public String editar(@PathVariable(value = "idPersona") Long id, Persona persona, Model model) {

		persona = personaService.findById(id);
		model.addAttribute("conta", con);
		model.addAttribute("persona",persona);
		return "modificar";
	}

	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
				return "/error/405";
			}
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "/error/404";
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		con = 0;
		return "redirect:/login?logout";
	}

	@Override
	public String getErrorPath() {
		return null;
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash, Locale locale) {
		if (principal != null) {
			return "redirect:/";
		}
		return "login";
	}
}
