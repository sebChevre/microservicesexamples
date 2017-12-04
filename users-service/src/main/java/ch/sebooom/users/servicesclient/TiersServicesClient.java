package ch.sebooom.users.servicesclient;

import ch.sebooom.users.domain.model.Tiers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("tiers-service")
public interface TiersServicesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/tiers/{tiersId}")
    Tiers getTiers(@PathVariable("tiersId") Integer tiersId);
}
