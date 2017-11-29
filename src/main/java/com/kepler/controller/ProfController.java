package com.kepler.controller;

import com.kepler.model.Prof;
import com.kepler.service.ProfService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller("profController")
@RequestMapping("/prof")
public class ProfController {
    private static final Logger LOGGER = Logger.getLogger(ProfController.class);
    @Autowired
    ProfService profService;

    // GET qui permet de récupérer des informations identifié par l'URI de la demande
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Prof> getProf(@PathVariable("id") Long id) {
        Prof prof = profService.getById(id);
        if (prof == null) {
            return new ResponseEntity<Prof>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Prof>(prof, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Prof>> getAllProfs() {
        List<Prof> profs = profService.getAll();
        if (profs.isEmpty()) {
            return new ResponseEntity<List<Prof>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Prof>>(profs, HttpStatus.OK);
    }

    // POST demande au server d'origine d'accepter l'entité incluse dans la requete ent tant que nouveau subordonné de la ressource identifié par l'URI
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Prof> addProf(@RequestBody Prof prof) {
        //LOGGER.info("POST effectué");
        System.out.println("POST effectué");
        profService.save(prof);
        ResponseEntity<Prof> responseEntity = new ResponseEntity<Prof>(prof, HttpStatus.CREATED);
        return responseEntity;

    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Prof> updateProf(@RequestBody Prof prof) {
        Prof existingEle = profService.getById(prof.getId());
        if (existingEle == null) {
            return new ResponseEntity<Prof>(HttpStatus.NOT_FOUND);
        } else {
            profService.save(prof);
            return new ResponseEntity<Prof>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProf(@PathVariable("id") Long id) {
        Prof prof = profService.getById(id);
        if (prof == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            profService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);

        }

    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */