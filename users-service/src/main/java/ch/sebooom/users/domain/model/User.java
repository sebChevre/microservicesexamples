package ch.sebooom.users.domain.model;

public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer tiersId;
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
    }
}
