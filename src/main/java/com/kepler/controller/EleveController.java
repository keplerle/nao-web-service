package com.kepler.controller;

import com.kepler.model.Eleve;
import com.kepler.service.EleveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    // GET 1 eleve par id
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Eleve> getEleve(@Param("id") String id) {
        Eleve eleve = eleveService.getBy(id);
        if (eleve == null) {
            return new ResponseEntity<Eleve>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Eleve>(eleve, HttpStatus.OK);

    }
    // GET tout eleves par prof
    @RequestMapping(value = "/prof", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> getAllEleves(@Param("prof") String prof ) {
        List<Eleve> eleves = eleveService.findByProf(prof);
        if (eleves.isEmpty()) {
            return new ResponseEntity<List<Eleve>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Eleve>>(eleves, HttpStatus.OK);
    }

    // save un eleve
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Eleve> addEleve(@RequestBody Eleve eleve) {
        //LOGGER.info("POST effectué");
        System.out.println("POST effectué");
        eleveService.save(eleve);
        ResponseEntity<Eleve> responseEntity = new ResponseEntity<Eleve>(eleve, HttpStatus.CREATED);
        return responseEntity;

    }
    // met a jour un eleve
    @RequestMapping(value = "", method = RequestMethod.PUT,consumes = "application/json", produces = "application/json")
    public ResponseEntity<Eleve> updateEleve(@RequestBody Eleve eleve) {
        Eleve existingEle = eleveService.getBy(eleve.getProf());
        if (existingEle == null) {
            return new ResponseEntity<Eleve>(HttpStatus.NOT_FOUND);
        } else {
            eleveService.save(eleve);
            return new ResponseEntity<Eleve>(HttpStatus.OK);
        }
    }
    // Supprime un eleve
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProf(@Param("mail") String mail) {
       Eleve prof = eleveService.getBy(mail);
        if (prof == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            eleveService.delete(mail);
            return new ResponseEntity<Void>(HttpStatus.GONE);

        }
    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */
