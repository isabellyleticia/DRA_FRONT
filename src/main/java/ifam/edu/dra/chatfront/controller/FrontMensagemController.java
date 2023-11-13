package ifam.edu.dra.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifam.edu.dra.chatfront.model.Mensagem;
import ifam.edu.dra.chatfront.service.FrontMensagemService;

@RequestMapping("/mensagem")
@Controller
public class FrontMensagemController {
	
	@Autowired
	FrontMensagemService frontMensagemService;
	
	@GetMapping
	public String showContatos(Model model) {

		model.addAttribute("mensagens", frontMensagemService.getMensagens());
		return "listMensagem";
	}
	
	@GetMapping("/new")
	public String newMensagem(Mensagem mensagem) {
		return "newMensagem";
	}

	@PostMapping
	public String addMensagem(@Validated Mensagem mensagem, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newMensagem";
		}
		frontMensagemService.postMensagem(mensagem);
		return "redirect:/mensagem";
	}

}
