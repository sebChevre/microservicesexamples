package ch.sebooom.tiers.api;

import ch.sebooom.tiers.domain.model.Tiers;
import ch.sebooom.tiers.domain.repository.TiersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class Api {

    @Autowired
    private TiersRepository tiersRepository;




    protected Logger logger = Logger.getLogger(Api.class.getName());


    @RequestMapping( value = "/tiers/{id}",method = RequestMethod.GET )
    public Tiers findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Tiers.findById(%d)", id));
        return tiersRepository.findById(id);
    }

    @RequestMapping( value = "/tiers", method = RequestMethod.GET )
    public List<Tiers> findByAll() {
        logger.info("Tiers.findAll()");
        return tiersRepository.findAll();
    }





}
