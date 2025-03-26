public class Case {
    private int valeur;
    private Joueur jouePar; // Remplace 'jouepar'
    private Position position;

    // Constructeur principal
    public Case(int valeur, Joueur jouePar, Position position) {
        this.valeur = valeur;
        this.jouePar = jouePar;
        this.position = position;
    }


    public Case(Position position) {
        this.valeur = 0; // Valeur par défaut
        this.jouePar = null; // Non occupée
        this.position = position;
    }

    
    public boolean estLibre() {
        return jouePar == null;
    }

    
    public int getValeur() {
        return valeur;
    }

    
    public Joueur getJouePar() {
        return jouePar;
    }

    
    public void setJouePar(Joueur jouePar) {
        this.jouePar = jouePar;
    }

   
    public Position getPosition() {
        return position;
    }

   
    public void occuper(Joueur jouePar) {
        this.jouePar = jouePar;
    }

    // Libère la case
    public void liberer() {
        this.jouePar = null;
    }

    
    @Override
    public String toString() {
        return "Case{" +
                "valeur=" + valeur +
                ", jouePar=" + (jouePar != null ? jouePar.getNom() : "Aucun") +
                ", position=(" + position.getX() + ", " + position.getY() + ")" +
                '}';
    }
}
