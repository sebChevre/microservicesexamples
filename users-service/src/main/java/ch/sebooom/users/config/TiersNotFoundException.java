package ch.sebooom.users.config;

public class TiersNotFoundException extends Exception {
    public TiersNotFoundException(String not_found) {

        super(not_found);
    }
}
