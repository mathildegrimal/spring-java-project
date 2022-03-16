package com.example.evaljava.controller;

import com.example.evaljava.entity.Editeur;
import com.example.evaljava.service.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/editeur")
public class EditeurRestController {
    @Autowired
    EditeurService service;

    @GetMapping("")
    public List<Editeur> init() {
        return service.findAll();
    }

    @GetMapping("/pairs")
    public List<Editeur> findByEvenIds() {
        return service.findAllEvenIds();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){ return service.deleteById(id); }
}
