package me.pugabyte.justiceweb.controller;

import me.pugabyte.edenapi.models.nerd.Nerd;
import me.pugabyte.edenapi.models.nerd.NerdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("history")
public class HistoryController {

	@GetMapping("/{player}")
	public String history(@PathVariable("player") String player, Model model) {
		model.addAttribute("name", player);
		Nerd nerd = new NerdService().get(UUID.fromString("86d7e0e2-c95e-4f22-8f99-a6e83b398307"));
		System.out.println(nerd.toPrettyString());
		return "history/index";
	}

}
