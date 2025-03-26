public class Coup {

    private Joueur joueur;
    private Position positionCase;
    private Orientation orientation;

    // Constructeur avec validation
    public Coup(Joueur joueur, Position positionCase, Orientation orientation) {
        if (joueur == null || positionCase == null || orientation == null) {
            throw new IllegalArgumentException("Les arguments joueur, positionCase et orientation ne doivent pas être null.");
        }
        this.joueur = joueur;
        this.positionCase = positionCase;
        this.orientation = orientation;
    }

    // Getter pour joueur
    public Joueur getJoueur() {
        return joueur;
    }

    // Getter pour positionCase
    public Position getPositionCase() {
        return positionCase;
    }

    // Getter pour orientation
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Coup{" +
               "joueur=" + joueur.getNom() +
               ", positionCase=(" + positionCase.getX() + ", " + positionCase.getY() + ")" +
               ", orientation=" + (orientation == Orientation.LIGNE ? "Ligne" : "Colonne") +
               '}';
    }
}
