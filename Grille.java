public class Grille {
    private Case[][] cases;
    private int alignementActif;

    // Constructeur
    public Grille(int alignementActif) {
        this.alignementActif = alignementActif;
        this.cases = new Case[alignementActif][alignementActif];

        // Initialisation des cases
        for (int i = 0; i < alignementActif; i++) {
            for (int j = 0; j < alignementActif; j++) {
                cases[i][j] = new Case(new Position(i, j)); // Correction ici
            }
        }
    }

    // Récupère l'alignement actif
    public int getAlignementActif() {
        return alignementActif;
    }

    // Récupère une case à partir d'une position
    public Case getCase(Position position) {
        return cases[position.getX()][position.getY()];
    }

    // Extrait un alignement de cases
    public AlignementCases extraireAlignement(Position position, Orientation orientation) {
        AlignementCases alignement = new AlignementCases();
        if (orientation == Orientation.LIGNE) {
            for (int y = 0; y < alignementActif; y++) {
                alignement.ajouterCase(cases[position.getX()][y]);
            }
        } else if (orientation == Orientation.COLONNE) {
            for (int x = 0; x < alignementActif; x++) {
                alignement.ajouterCase(cases[x][position.getY()]);
            }
        }
        return alignement;
    }

    // Récupère la dimension de la grille
    public int getDimension() {
        return alignementActif;
    }
}
