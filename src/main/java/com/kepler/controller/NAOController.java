package com.kepler.controller;

import com.kepler.model.NAO;
import com.kepler.service.NAOService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



@Controller("naoController")
@RequestMapping("/nao")
public class NAOController {
    private final static Logger LOGGER= Logger.getLogger(NAOController.class);
    @Autowired
    NAOService naoService;

    // GET qui permet de récupérer des informations identifié par l'URI de la demande
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<NAO> getNAOip(String ip) {
        NAO nao = naoService.getBy(ip);
        if (nao == null) {
            return new ResponseEntity<NAO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NAO>(nao, HttpStatus.OK);

    }

    @RequestMapping(value = "/mailprof", method = RequestMethod.GET)
    public ResponseEntity<List<NAO>> getAllNAOProf(String mailprof) {
        //Warning: la variable doit être
        LOGGER.info(mailprof);
        List<NAO> naos = naoService.findByMailprof(mailprof);
        /*if (naos.isEmpty()) {
            return new ResponseEntity<List<NAO>>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<List<NAO>>(naos, HttpStatus.OK);
    }

    // POST demande au server d'origine d'accepter l'entité incluse dans la requete ent tant que nouveau subordonné de la ressource identifié par l'URI
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<NAO> addNAO(@RequestBody NAO nao) {
        naoService.save(nao);
        ResponseEntity<NAO> responseEntity = new ResponseEntity<NAO>(nao, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<NAO> updateNAO(@RequestBody NAO nao) {
        NAO existingnao = naoService.getBy(nao.getIp());
        if (existingnao == null) {
            return new ResponseEntity<NAO>(HttpStatus.NOT_FOUND);
        } else {
            naoService.save(nao);
            return new ResponseEntity<NAO>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteNAO(@Param("ip") String ip) {
        NAO person = naoService.getBy(ip);
        if (person == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            naoService.delete(ip);
            return new ResponseEntity<Void>(HttpStatus.GONE);

        }

    }
}


/**
 * User : /user
 * Configuration : /configuration
 * Game: /game
 */
