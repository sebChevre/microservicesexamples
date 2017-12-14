package ch.sebooom.users.dto;

public class UserWithTiersDto {

    private UserDto user;

    private TiersDto tiers;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TiersDto getTiers() {
        return tiers;
    }

    public void setTiers(TiersDto tiers) {
        this.tiers = tiers;
    }
}
