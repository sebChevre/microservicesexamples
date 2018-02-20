package ch.sebooom.users.dto;

import ch.sebooom.users.domain.model.UserState;

public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private UserState etat;

    private Integer tiersId;


    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", etat=" + etat +
                ", tiersId=" + tiersId +
                '}';
    }

    public UserState getEtat() {
        return etat;
    }

    public void setEtat(UserState etat) {
        this.etat = etat;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTiersId() {
        return tiersId;
    }

    public void setTiersId(Integer tiersId) {
        this.tiersId = tiersId;
    }
}
