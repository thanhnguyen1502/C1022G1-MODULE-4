package com.example.ss6_bongda.controller;

import com.example.ss6_bongda.dto.FootballDto;
import com.example.ss6_bongda.model.Football;
import com.example.ss6_bongda.service.IFootballService;
import com.example.ss6_bongda.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class FootballController {
    @Autowired
    private IFootballService footballService;

    @Autowired
    private ITeamService teamService;

    @GetMapping("/home")
    private String goHome(@PageableDefault(value = 5) Pageable pageable, Model model, @RequestParam(value = "name", defaultValue = "") String keySearch){
        model.addAttribute("footballList", footballService.findAllByNameAllBirthday(keySearch, pageable));
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("name", keySearch);
        return "football-list";
    }

//    @GetMapping("/home")
//    public String showList(Model model) throws ExceptionHandler {
//        List<Football> footballList = footballService.findAll();
//        if (footballList.size() > 11) {
//            throw new ExceptionHandler();
//        }
//        model.addAttribute("footballList", footballList);
//        model.addAttribute("teamList", teamService.findAll());
//        return "list";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        footballService.remove(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("footballDto", new FootballDto());
        model.addAttribute("teamList", teamService.findAll());
        return "football-create";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute FootballDto footballDto,
                      BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes){
        new FootballDto().validate(footballDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("teamList", teamService.findAll());
            return "football-create";
        }
        Football football = new Football();
        BeanUtils.copyProperties(footballDto, football);
        footballService.save(football);
        redirectAttributes.addFlashAttribute("mess", "successfully added new! ");
        return "redirect:/home";
    }

//    @ExceptionHandler(ExceptionHandler.class)
//    public String showException() {
//        return "errorPage";
//    }
}
