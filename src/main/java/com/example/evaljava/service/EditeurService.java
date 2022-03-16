package com.example.evaljava.service;

import com.example.evaljava.entity.Editeur;
import com.example.evaljava.repository.EditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EditeurService {
    @Autowired
    EditeurRepository repository;

    public List<Editeur> findAll(){
        return (List<Editeur>)repository.findAll();
    }

    public List<Editeur> findAllEvenIds(){
        List<Editeur> editeurs = (List<Editeur>) repository.findAll();
        Predicate<Editeur> byId = editeur -> editeur.getId() % 2 == 0;
        return editeurs.stream().filter(byId)
                .collect(Collectors.toList());
    }

    public String deleteById(Long id){
        try {
            repository.deleteById(id);
            return "L'éditeur avec id "+ id +" a bien été supprimé";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Editeur create(Editeur editeur){
        return repository.save(editeur);
    }
}
