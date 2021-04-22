package me.pugabyte.justiceweb.controller;

import edenapi.models.punishments.PunishmentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	static void shared(Model model) {
		model.addAttribute("types", PunishmentType.values());
	}

	@GetMapping
	public String index(Model model) {
		shared(model);
		return "index";
	}

}
