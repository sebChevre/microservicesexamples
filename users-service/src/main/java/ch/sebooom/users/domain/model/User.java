package ch.sebooom.users.domain.model;

import ch.sebooom.users.domain.event.DomainEventPublisher;
import ch.sebooom.users.domain.event.UserCreatedEvent;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "tiersId")
    private Integer tiersId;

    @Column(name = "etat")
    private UserState etat = UserState.INITIE;

    @Transient
    private Tiers tiers;

    @Transient
    private DomainEventPublisher eventPublisher;

    public void setEventPublisher(DomainEventPublisher publisher){
        this.eventPublisher = publisher;
    }

    private User(UserBuilder userBuilder) {
        this.username = userBuilder.username;
        this.password = userBuilder.password;
        this.tiersId = userBuilder.tiersId;
        this.etat = userBuilder.etat;
    }


    public UserState getEtat() {
        return etat;
    }

    public void setEtat(UserState etat) {
        this.etat = etat;
    }

    public User () {}

    public Integer getTiersId() {
        return tiersId;
    }

    private User(String username, String password, Integer tiersId, UserState etat) {
        this.username = username;
        this.password = password;
        this.tiersId = tiersId;
        this.etat = etat;
    }



    public static class UserBuilder {

        private final String username;
        private final String password;
        private final Integer tiersId;
        private UserState etat;
        private Integer id;

        public UserBuilder(String username, String password, Integer tiersId){
            this.username = username;
            this.password = password;
            this.tiersId = tiersId;
            this.etat = UserState.INITIE;
        }

        public UserBuilder etat(UserState etat){
            this.etat = etat;
            return this;
        }

        public UserBuilder id(Integer  id){
            this.id = id;
            return this;
        }

        public User build () {
            return new User(this);
        }

    }


    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
        this.tiersId = tiers.getId();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTiersId(Integer tiersId) {
        this.tiersId = tiersId;
    }

    public void valideUserAccount () {

        this.eventPublisher.publishEvent(new UserCreatedEvent(this.getId(),this.getTiersId()));
        this.etat = UserState.ACTIVE;
    }
}
