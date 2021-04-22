package me.pugabyte.justiceweb.controller;

import edenapi.models.nerd.Nerd;
import edenapi.models.nerd.NerdService;
import edenapi.models.punishments.PunishmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import static me.pugabyte.justiceweb.view.View.HISTORY_INDEX;

@Controller
@RequestMapping("history")
public class HistoryController {

	@GetMapping("/{player}")
	public String history(@PathVariable("player") String player, Model model) {
		model.addAttribute("name", player);
		model.addAttribute("history", new PunishmentsService().get(player).toPrettyString());
		return HISTORY_INDEX.view();
	}

}
