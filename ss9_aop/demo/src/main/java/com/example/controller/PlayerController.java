package com.example.controller;

import com.example.dto.PlayerDto;
import com.example.exception.ExceptionHandle;
import com.example.model.Player;
import com.example.service.IPlayerService;
import com.example.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(Model model) throws ExceptionHandle {
        List<Player> playerList = iPlayerService.findAll();
        if (playerList.size() > 11) {
            throw new ExceptionHandle();
        }
        model.addAttribute("playerList", playerList);
        model.addAttribute("teamList", iTeamService.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Player player = iPlayerService.findById(id);

        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(player, playerDto);

        model.addAttribute("playerDto", playerDto);
        model.addAttribute("teamList", iTeamService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated PlayerDto playerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        new PlayerDto().validate(playerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("playerDto", playerDto);
            model.addAttribute("teamList", iTeamService.findAll());

            return "edit";
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        iPlayerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Chinh sua thanh cong.");
        return "redirect:/";
    }


    @ExceptionHandler(ExceptionHandle.class)
    public String showException() {
        return "errorPage";
    }
}
