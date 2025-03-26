public class Orientation {
    public static final int LIGNE = 0;    // Verticale
    public static final int COLONNE = 1; // Horizontale

    private int orientation;

    // Constructeur
    public Orientation(int orientation) {
        if (orientation != LIGNE && orientation != COLONNE) {
            throw new IllegalArgumentException("Orientation doit être LIGNE (0) ou COLONNE (1).");
        }
        this.orientation = orientation;
    }

    // Vérifie si l'orientation est verticale
    public boolean estVerticale() {
        return orientation == LIGNE;
    }

    // Vérifie si l'orientation est horizontale
    public boolean estHorizontale() {
        return orientation == COLONNE;
    }

    // Retourne la valeur de l'orientation
    public int getOrientation() {
        return orientation;
    }

    // Définit une nouvelle valeur pour l'orientation
    public void setOrientation(int orientation) {
        if (orientation != LIGNE && orientation != COLONNE) {
            throw new IllegalArgumentException("Orientation doit être LIGNE (0) ou COLONNE (1).");
        }
        this.orientation = orientation;
    }

    // Affiche les informations sous forme de chaîne
    public String affiche() {
        return "Orientation{" + "orientation=" +
               (orientation == LIGNE ? "Verticale" : "Horizontale") + '}';
    }
}
