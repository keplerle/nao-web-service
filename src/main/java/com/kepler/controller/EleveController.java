package com.kepler.controller;

import com.kepler.model.Eleve;
import com.kepler.service.EleveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.print.attribute.standard.Media;
import java.util.List;


@Controller("eleveController")
@RequestMapping("/eleve")
public class EleveController {
    private static final Logger LOGGER = Logger.getLogger(EleveController.class);
    @Autowired
    EleveService eleveService;

    // GET qui permet de récupérer des informations identifié par l'URI de la demande
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Eleve> getEleve(@PathVariable("id") Long id) {
        Eleve eleve = eleveService.getById(id);
        if (eleve == null) {
            return new ResponseEntity<Eleve>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Eleve>(eleve, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> getAllEleves() {
        List<Eleve> eleves = eleveService.getAll();
        if (eleves.isEmpty()) {
            return new ResponseEntity<List<Eleve>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Eleve>>(eleves, HttpStatus.OK);
    }

    // POST demande au server d'origine d'accepter l'entité incluse dans la requete ent tant que nouveau subordonné de la ressource identifié par l'URI
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Eleve> addEleve(@RequestBody Eleve eleve) {
        //LOGGER.info("POST effectué");
        System.out.println("POST effectué");
        eleveService.save(eleve);
        ResponseEntity<Eleve> responseEntity = new ResponseEntity<Eleve>(eleve, HttpStatus.CREATED);
        return responseEntity;

    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Eleve> updateEleve(@RequestBody Eleve eleve) {
        Eleve existingEle = eleveService.getById(eleve.getId());
        if (existingEle == null) {
            return new ResponseEntity<Eleve>(HttpStatus.NOT_FOUND);
        } else {
            eleveService.save(eleve);
            return new ResponseEntity<Eleve>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEleve(@PathVariable("id") Long id) {
        Eleve eleve = eleveService.getById(id);
        if (eleve == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            eleveService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);

        }

    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */
