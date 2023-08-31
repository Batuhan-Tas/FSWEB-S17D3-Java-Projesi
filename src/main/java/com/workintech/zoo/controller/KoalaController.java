package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exception.KangarooValidator;
import com.workintech.zoo.exception.KoalaValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    public Map<Integer, Koala> koalas;

    @PostConstruct
    public void initKoalas(){
        koalas = new HashMap<>();
    }

    @GetMapping
    public List getKoalas(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getKoala(@PathVariable int id){
        KoalaValidator.isIdValid(id);
        KoalaValidator.isIdExist(koalas,id);
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala addKoala(@RequestBody Koala newKoala){
        koalas.put(newKoala.getId(),newKoala);
        return koalas.get(newKoala.getId());
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable int id, @RequestBody Koala newKoala){
        KoalaValidator.isIdValid(id);
        KoalaValidator.isIdExist(koalas,id);
        koalas.put(id,newKoala);
        return koalas.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteKoala(@PathVariable int id){
        KoalaValidator.isIdValid(id);
        KoalaValidator.isIdExist(koalas,id);
        koalas.remove(id);
        return "Koala has been successfully removed";
    }

}
