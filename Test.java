import java.util.ArrayList;
import java.util.List;

// Classe Position
class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// Classe Orientation
enum Orientation {
    LIGNE, COLONNE
}

// Classe Case
class Case {
    private boolean occupee;
    private int valeur;
    private Joueur joueur;

    public Case(int valeur) {
        this.valeur = valeur;
        this.occupee = false;
    }

    public boolean estOccupee() {
        return occupee;
    }

    public void occuper() {
        this.occupee = true;
    }

    public void liberer() {
        this.occupee = false;
    }

    public int getValeur() {
        return valeur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}

// Classe Grille
class Grille {
    private Case[][] cases;
    private int dimension;

    public Grille(int dimension) {
        this.dimension = dimension;
        this.cases = new Case[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cases[i][j] = new Case(1); // Valeur par défaut pour l'exemple
            }
        }
    }

    public Case getCase(Position position) {
        return cases[position.getX()][position.getY()];
    }

    public int getDimension() {
        return dimension;
    }
}

// Classe Joueur
abstract class Joueur {
    protected String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract Coup jouer(Grille grille, Orientation orientation);
}

// Classe JoueurHumain
class JoueurHumain extends Joueur {
    public JoueurHumain(String nom) {
        super(nom);
    }

    @Override
    public Coup jouer(Grille grille, Orientation orientation) {
        // Pour l'exemple, on joue toujours à la position (0,0)
        return new Coup(this, new Position(0, 0), orientation);
    }
}

// Classe JoueurOrdinateur
class JoueurOrdinateur extends Joueur {
    private int niveau;

    public JoueurOrdinateur(String nom, int niveau) {
        super(nom);
        this.niveau = niveau;
    }

    @Override
    public Coup jouer(Grille grille, Orientation orientation) {
        // Pour l'exemple, on joue toujours à la position (1,1)
        return new Coup(this, new Position(1, 1), orientation);
    }
}

// Classe Coup
class Coup {
    private Joueur joueur;
    private Position position;
    private Orientation orientation;

    public Coup(Joueur joueur, Position position, Orientation orientation) {
        this.joueur = joueur;
        this.position = position;
        this.orientation = orientation;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Position getPositionCase() {
        return position;
    }
}

// Classe Partie
class Partie {
    private Grille grille;
    private Joueur joueur1;
    private Joueur joueur2;
    private List<Coup> coupsJoues;
    private int scoreJoueur1;
    private int scoreJoueur2;

    public Partie(int dimension, Joueur joueur1, Joueur joueur2) {
        this.grille = new Grille(dimension);
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.coupsJoues = new ArrayList<>();
        this.scoreJoueur1 = 0;
        this.scoreJoueur2 = 0;
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void jouerCoup(Coup coup) {
        coupsJoues.add(coup);
        Case caseJouee = grille.getCase(coup.getPositionCase());
        if (coup.getJoueur() == joueur1) {
            scoreJoueur1 += caseJouee.getValeur();
        } else {
            scoreJoueur2 += caseJouee.getValeur();
        }
        caseJouee.occuper();
        caseJouee.setJoueur(coup.getJoueur());
    }

    public void annulerDernierCoup() {
        if (!coupsJoues.isEmpty()) {
            Coup dernierCoup = coupsJoues.remove(coupsJoues.size() - 1);
            Case caseAnnulee = grille.getCase(dernierCoup.getPositionCase());
            if (dernierCoup.getJoueur() == joueur1) {
                scoreJoueur1 -= caseAnnulee.getValeur();
            } else {
                scoreJoueur2 -= caseAnnulee.getValeur();
            }
            caseAnnulee.liberer();
            caseAnnulee.setJoueur(null);
        }
    }

    public void afficherGrille() {
        for (int i = 0; i < grille.getDimension(); i++) {
            for (int j = 0; j < grille.getDimension(); j++) {
                Case c = grille.getCase(new Position(i, j));
                if (c.estOccupee()) {
                    System.out.print("X (" + (c.getJoueur() == joueur1 ? joueur1.getNom() : joueur2.getNom()) + ") ");
                } else {
                    System.out.print(c.getValeur() + " ");
                }
            }
            System.out.println();
        }
    }

    public void afficherScores() {
        System.out.println("Score de " + joueur1.getNom() + " : " + scoreJoueur1);
        System.out.println("Score de " + joueur2.getNom() + " : " + scoreJoueur2);
    }
}

// Classe Test
public class Test {
    public static void main(String[] args) {
        Partie partie = new Partie(5, new JoueurHumain("M.Noel"), new JoueurOrdinateur("Jean", 1));

        partie.afficherGrille();

        Coup coupHumain = new Coup(partie.getJoueur1(), new Position(0, 0), Orientation.LIGNE);
        partie.jouerCoup(coupHumain);
        partie.afficherGrille();

        Coup coupOrdi = partie.getJoueur2().jouer(partie.getGrille(), Orientation.COLONNE);
        partie.jouerCoup(coupOrdi);
        partie.afficherGrille();

        partie.afficherScores();

        partie.annulerDernierCoup();
        partie.afficherGrille();
        partie.afficherScores();
    }
}
