package ch.sebooom.users.servicesclient;

import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.dto.TiersDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("tiers-service")
public interface TiersServicesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/tiers/{tiersId}")
    Tiers getTiers(@PathVariable("tiersId") Integer tiersId);

    @RequestMapping(method = RequestMethod.POST, value = "/tiers")
    Tiers createTiers(@RequestBody TiersDto tiers);
}
