package ifam.edu.dra.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifam.edu.dra.chatfront.model.Contato;
import ifam.edu.dra.chatfront.service.FrontContatoService;

@RequestMapping("/contato")
@Controller
public class FrontContatoController {

	@Autowired
	FrontContatoService frontContatoService;

	@GetMapping
	public String showContatos(Model model) {

		model.addAttribute("contatos", frontContatoService.getContatos());
		return "listContato";
	}

	@GetMapping("/new")
	public String newContato(Model model) {
		return "newContato";
	}

	@PostMapping
	public String addUser(@Validated Contato contato, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newContato";
		}

		frontContatoService.setContato(contato);
		return "redirect:/contato";
	}
	
	@PutMapping("/{id}")
	public String changeContato(@PathVariable long id, 
			@Validated Contato contato, BindingResult result, Model model) {
		return "redirect:/contato";
	}
	
	@DeleteMapping("/{id}")
	public String deleteContato(@PathVariable long id) {
		return "redirect:/contato";
	}
}
