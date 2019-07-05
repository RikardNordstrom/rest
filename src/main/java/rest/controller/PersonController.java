package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.model.Person;
import rest.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;


    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        //validation
        return service.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
        //validation
        return service.save(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        //validation
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public String ping() {
        return "Hello world";
    }
}
