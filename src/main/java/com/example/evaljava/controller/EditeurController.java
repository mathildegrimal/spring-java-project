package com.example.evaljava.controller;

import com.example.evaljava.entity.Editeur;
import com.example.evaljava.service.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EditeurController {

    @Autowired
    EditeurService service;

    @GetMapping("/")
    public String init(Model model){
        List<Editeur> editeurs = service.findAll();
        model.addAttribute("editeurs", editeurs);
        return "list_editeurs";
    }

    @GetMapping("/delete/{id}")
    public String init(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editeur")
    public String initCreate(Model model){
        Editeur editeur = new Editeur("","");
        model.addAttribute("editeur", editeur);
        return "create_editeur";
    }

    @GetMapping("/editeur/create")
    public String init(Editeur editeur){
        service.create(editeur);
        return "redirect:/";
    }
}

