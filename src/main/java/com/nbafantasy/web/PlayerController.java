package com.nbafantasy.web;

import com.nbafantasy.model.Player;
import com.nbafantasy.service.PlayerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping({"/", "/players"})
    public String listAll(Model model){
        List<Player> players = this.playerService.listAll();
        model.addAttribute("players", players);
        return "list";

    }

    @GetMapping("/players/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAdd(){
        return "form";
    }

    @GetMapping("/players/{id}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEdit(@PathVariable Long id, Model model){
        model.addAttribute("player", this.playerService.findById(id));
        return "form";
    }

    @PostMapping("/players")
    @PreAuthorize("hasRole('ADMIN')")
    public String create(@RequestParam String name,
                         @RequestParam String team,
                         @RequestParam String pos,
                         @RequestParam Double age,
                         @RequestParam Double ppg,
                         @RequestParam Double apg,
                         @RequestParam Double rpg){
        this.playerService.create(name, team, pos, age, ppg, apg, rpg);
        return "redirect:/players";

    }

    @PostMapping("/players/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String team,
                         @RequestParam String pos,
                         @RequestParam Double age,
                         @RequestParam Double ppg,
                         @RequestParam Double apg,
                         @RequestParam Double rpg){
        this.playerService.update(id, name, team, pos, age, ppg, apg, rpg);
        return "redirect:/players";

    }

    @PostMapping("/players/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id){
        this.playerService.delete(id);
        return "redirect:/players";
    }



}
