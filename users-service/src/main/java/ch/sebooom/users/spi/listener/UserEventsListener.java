package ch.sebooom.users.spi.listener;

import ch.sebooom.users.domain.event.UserActivatedEvent;
import ch.sebooom.users.domain.event.UserCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventsListener {

    protected Logger logger = LoggerFactory.getLogger(UserEventsListener.class.getName());


    @EventListener
    public void handleUserCreatedEvent (UserCreatedEvent event) {
        logger.info(event.toString());
    }

    @EventListener
    public void handleUserActivatedEvent (UserActivatedEvent event) {
        logger.info(event.toString());
    }
}
