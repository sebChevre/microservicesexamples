package ch.sebooom.users.spi.springevent;

import ch.sebooom.users.domain.event.DomainEvent;
import ch.sebooom.users.domain.event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringEventPublisher implements DomainEventPublisher{

    @Autowired
    private ApplicationEventPublisher publisher;


    @Override
    public void publishEvent(DomainEvent event) {
        publisher.publishEvent(event);
    }
}
