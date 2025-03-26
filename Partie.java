import java.util.ArrayList;
import java.util.List;

// Classe Partie
public class Partie {
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
        }
    }

    public void afficherGrille() {
        for (int i = 0; i < grille.getDimension(); i++) {
            for (int j = 0; j < grille.getDimension(); j++) {
                Case c = grille.getCase(new Position(i, j));
                // Vérification correcte si la case est occupée
                System.out.print((c.estOccupee() ? "X" : c.getValeur()) + " ");
            }
            System.out.println();
        }
    }

    public void afficherScores() {
        System.out.println("Score de " + joueur1.getNom() + " : " + scoreJoueur1);
        System.out.println("Score de " + joueur2.getNom() + " : " + scoreJoueur2);
    }
}
