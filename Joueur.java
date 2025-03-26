public class Joueur {
    private String nom;

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Joueur{" + "nom='" + nom + '\'' + '}';
    }
}
