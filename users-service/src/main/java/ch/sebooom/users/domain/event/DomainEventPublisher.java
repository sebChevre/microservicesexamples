package ch.sebooom.users.domain.event;

public interface DomainEventPublisher {

    void publishEvent(DomainEvent event);
}
