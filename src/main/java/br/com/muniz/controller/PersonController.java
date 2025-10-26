package br.com.muniz.controller;

import br.com.muniz.model.Person;
import br.com.muniz.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basicCrud/v1")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable ("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable ("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
