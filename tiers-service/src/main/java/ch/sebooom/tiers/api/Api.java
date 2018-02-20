package ch.sebooom.tiers.api;

import ch.sebooom.tiers.domain.model.Tiers;
import ch.sebooom.tiers.service.TiersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class Api {

    @Autowired
    private TiersService tiersService;




    protected Logger logger = Logger.getLogger(Api.class.getName());


    @RequestMapping( value = "/tiers/{id}",method = RequestMethod.GET )
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Tiers.findById(%d)", id));
        Optional<Tiers> tiers =  tiersService.findById(id);

        ResponseEntity response;

        if(tiers.isPresent()){
            response =  new ResponseEntity<Tiers>(tiers.get(),HttpStatus.OK);
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiIError.message("Entite non trouvé!"));
        }

        return response;

    }

    @RequestMapping( value = "/tiers", method = RequestMethod.GET )
    public List<Tiers> findByAll() {
        logger.info("Tiers.findAll()");
        return tiersService.findAll();
    }


    @RequestMapping( value = "/tiers", method = RequestMethod.POST)
    public ResponseEntity<Tiers> createNewTiers(@RequestBody Tiers tier){
        tiersService.createNewTiers(tier);
        return new ResponseEntity<Tiers>(tier, HttpStatus.CREATED);
    }



}
