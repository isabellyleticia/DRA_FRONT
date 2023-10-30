package ifam.edu.dra.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
