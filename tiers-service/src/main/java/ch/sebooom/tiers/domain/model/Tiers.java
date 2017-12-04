package ch.sebooom.tiers.domain.model;

public class Tiers {

    private Integer id;
    private String nom;
    private String prenom;

    public Tiers(Integer id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Tiers () {}

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
