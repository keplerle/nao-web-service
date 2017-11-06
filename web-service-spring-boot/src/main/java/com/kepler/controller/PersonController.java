package com.kepler.controller;

import com.kepler.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("personController")
@RequestMapping("/person")
public class PersonController {
    //HTTP ->

    //GET
    //PUT
    //POST
    //DELETE
//Exemple de requete GET qui permet de récupérer
// des informations identifié par l'URI de la demande
    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<Person> getPerson(){
        Person person = new Person();
        person.setAge(22);
        person.setName("kepler");
        person.setId(1);
        ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(person, HttpStatus.OK);
        return responseEntity;
    }
    //Exemple de requete POST demande au server d'origine d'accepter
    // l'entinté incluse dans la requete ent tant que nouveau
    // subordonné de la ressource identifié par l'URI
    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        System.out.println(person);
        person.setId(1);
        ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(person,HttpStatus.OK);
        return responseEntity;
    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */
