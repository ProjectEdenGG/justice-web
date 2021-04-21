package me.pugabyte.justiceweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("history")
public class HistoryController {

	@GetMapping("/{player}")
	public String history(@PathVariable("player") String player, Model model) {
		model.addAttribute("name", player);
		return "history/index";
	}

}
