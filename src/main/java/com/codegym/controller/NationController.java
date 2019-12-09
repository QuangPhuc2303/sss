package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.CityService;
import com.codegym.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NationController {

    @Autowired
    private NationService nationService;

    @Autowired
    private CityService cityService;

    @GetMapping("/nations")
    public ModelAndView listNation() {
        Iterable<Nation> nations = nationService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nation/list");
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @GetMapping("/create-nation")
    public ModelAndView showCreateNation() {
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }

    @PostMapping("/create-nation")
    public ModelAndView createNation(@ModelAttribute("nation") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message", "create nation successfully");
        return modelAndView;
    }

    @GetMapping("/edit-nation/{id}")
    public ModelAndView showEditNation(@PathVariable Long id) {
        Nation nation = nationService.findById(id);
        if (nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/edit");
            modelAndView.addObject("nation", nation);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nation")
    public ModelAndView editNation(@ModelAttribute("nation") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/edit");
        modelAndView.addObject("nation", nation);
        modelAndView.addObject("message", "update nation successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nation/{id}")
    public ModelAndView showDeleteNation(@PathVariable Long id) {
        Nation nation = nationService.findById(id);
        if (nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/delete");
            modelAndView.addObject("nation", nation);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-nation")
    public String deleteNation(@ModelAttribute("city") City city) {
        nationService.remove(city.getId());
        return "redirect:nations";
    }
}
