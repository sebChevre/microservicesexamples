package ch.sebooom.users.api;

import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import ch.sebooom.users.servicesclient.TiersServicesClient;
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
        private UserRepository userRepository;

        @Autowired
        private TiersServicesClient tiersServicesClient;


        protected Logger logger = Logger.getLogger(Api.class.getName());


        @RequestMapping( value = "/users/{id}", method = RequestMethod.GET)
        public User findById(@PathVariable("id") Integer id) {
            logger.info(String.format("User.findById(%d)", id));
            User user =  userRepository.findById(id);
            Tiers tier = tiersServicesClient.getTiers(user.getTiersId());
            user.setTiers(tier);
            return user;
        }



        @RequestMapping( value = "/users", method = RequestMethod.GET )
        public List<User> findAll() {
            logger.info("User.findAll()");
            return userRepository.findAll();
        }

    }

