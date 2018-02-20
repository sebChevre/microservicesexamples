package ch.sebooom.users.domain.event;

import java.util.Date;

public class UserActivatedEvent {

    private Integer userId;
    private Integer tiersId;
    private Date date;

    public UserActivatedEvent(Integer tiersId, Integer userId){
        this.tiersId = tiersId;
        this.userId = userId;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "UserActivatedEvent{" +
                "userId=" + userId +
                ", tiersId=" + tiersId +
                ", date=" + date +
                '}';
    }
}
