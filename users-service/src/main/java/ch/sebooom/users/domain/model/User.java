package ch.sebooom.users.domain.model;

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

    @Transient
    private Tiers tiers;

    public User () {}

    public Integer getTiersId() {
        return tiersId;
    }

    public User(Integer id, String username, String password, Integer tiersId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tiersId = tiersId;

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
}
