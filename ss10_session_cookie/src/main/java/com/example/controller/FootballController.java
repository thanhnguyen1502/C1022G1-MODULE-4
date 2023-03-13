package com.example.controller;

import com.example.dto.FavoriteDto;
import com.example.dto.FootballDto;
import com.example.model.Football;
import com.example.service.IFootballService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("favorite")
public class FootballController {
    @Autowired
    private IFootballService iPlayerService;

    @ModelAttribute("favorite")
    public FavoriteDto initFavorite() {
        return new FavoriteDto();
    }

    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "playerId",required = false,defaultValue = "-1") int id) {
        model.addAttribute("playerList", iPlayerService.findAll());
        return "player/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("player", iPlayerService.findById(id));
        return "player/detail";
    }

    @GetMapping("add/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favorite") FavoriteDto favoriteDto,
                              HttpServletResponse response) {

        int num=response.getStatus();
        for (Football players:iPlayerService.findAll()) {
            if (iPlayerService.findById(id).isPresent()){
                players.setStatus(players.getStatus()+1);
            }
        }

        Football player = iPlayerService.findById(id).get();
        FootballDto playerDto = new FootballDto();
        BeanUtils.copyProperties(player, playerDto);
        favoriteDto.addFavoritePlayer(playerDto);


        Cookie cookie = new Cookie("playerId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/favorite");
        response.addCookie(cookie);

        return "redirect:/favorite";
    }
}
