package ifam.edu.dra.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifam.edu.dra.chatfront.model.Contato;
import ifam.edu.dra.chatfront.service.FrontContatoService;

@Controller
public class FrontContatoController {

	@Autowired
	FrontContatoService frontContatoService;

	@GetMapping("/showContatos")
	public String showContatos(Model model) {

		model.addAttribute("contatos", frontContatoService.getContatos());
		return "listContato";
	}

	@GetMapping("/newContato")
	public String newContato(Model model) {
		return "newContato";
	}

	@PostMapping("/addContato")
	public String addUser(@Validated Contato contato, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newContato";
		}

		frontContatoService.setContato(contato);
		return "redirect:/showContatos";
	}
}
