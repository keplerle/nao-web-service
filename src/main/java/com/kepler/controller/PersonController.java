package com.kepler.controller;

import com.kepler.model.Person;
import com.kepler.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@Controller("personController")
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService perService;

// GET qui permet de récupérer des informations identifié par l'URI de la demande
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
   Person person = perService.getById(id);
    if (person == null) {
        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Person>(person, HttpStatus.OK);

}

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> persons=perService.getAll();
        if (persons.isEmpty()) {
            return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

   // POST demande au server d'origine d'accepter l'entité incluse dans la requete ent tant que nouveau subordonné de la ressource identifié par l'URI
    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        System.out.println(person);
        person.setId(1);
        ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(person,HttpStatus.CREATED);
        return responseEntity;
    }
    @RequestMapping(value="", method=RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person existingPer = perService.getById(person.getId());
        if (existingPer == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        } else {
            perService.save(person);
            return new ResponseEntity<Person>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Person person = perService.getById(id);
        if (person == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            perService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);

        }

    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */
