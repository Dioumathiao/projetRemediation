public class JoueurOrdinateur {
    private String typeDeJeu;
    private int niveau; // Changement de niveau pour int (à confirmer selon vos besoins)

    // Constructeur
    public JoueurOrdinateur(String typeDeJeu, int niveau) {
        this.typeDeJeu = typeDeJeu;
        this.niveau = niveau;
    }

    // Getter pour typeDeJeu
    public String getTypeDeJeu() {
        return typeDeJeu;
    }

    // Getter pour niveau
    public int getNiveau() {
        return niveau;
    }

    // Setter pour typeDeJeu
    public void setTypeDeJeu(String typeDeJeu) {
        this.typeDeJeu = typeDeJeu;
    }

    // Setter pour niveau
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    // Méthode pour afficher les informations
    public void affiche() {
        System.out.println("Type de jeu : " + typeDeJeu + ", Niveau : " + niveau);
    }
}
