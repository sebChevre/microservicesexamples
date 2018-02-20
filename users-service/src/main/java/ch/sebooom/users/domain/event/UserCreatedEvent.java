package ch.sebooom.users.domain.event;

import java.util.Date;

public class UserCreatedEvent implements DomainEvent{

    private Integer userId;
    private Integer tiersId;
    private Date date;

    public UserCreatedEvent(Integer tiersId, Integer userId){
        this.tiersId = tiersId;
        this.userId = userId;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "userId=" + userId +
                ", tiersId=" + tiersId +
                ", date=" + date +
                '}';
    }
}
