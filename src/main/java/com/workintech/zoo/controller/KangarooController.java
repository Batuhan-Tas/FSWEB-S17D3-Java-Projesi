package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exception.KangarooValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void initKangaroos(){
        kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List getKangaroos(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getKangaroo(@PathVariable int id){
        KangarooValidator.isIdValid(id);
        KangarooValidator.isIdExist(kangaroos,id);
        return kangaroos.get(id);
    }

    @PostMapping("/")
    public Kangaroo addKangaroo(@RequestBody Kangaroo newKangaroo){
        kangaroos.put(newKangaroo.getId(),newKangaroo);
        return kangaroos.get(newKangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo newKangaroo){
        KangarooValidator.isIdValid(id);
        KangarooValidator.isIdExist(kangaroos,id);
        kangaroos.put(id,newKangaroo);
        return kangaroos.get(newKangaroo.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteKangaroo(@PathVariable int id){
        KangarooValidator.isIdValid(id);
        KangarooValidator.isIdExist(kangaroos,id);
        kangaroos.remove(id);
        return "Kangaroo has been successfully removed.";
    }
}
