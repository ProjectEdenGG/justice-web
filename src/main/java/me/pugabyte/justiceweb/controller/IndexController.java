package me.pugabyte.justiceweb.controller;

import edenapi.models.punishments.PunishmentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("types", PunishmentType.values());
		return "index";
	}

}
