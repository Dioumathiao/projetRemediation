import java.util.LinkedList;

public class AlignementCase {

  
    private Orientation orientation;
    private LinkedList<Case> cases;
    private int position;

    // Constructeur
    public AlignementCase(Orientation orientation, LinkedList<Case> cases, int position) {
        if (orientation == null || cases == null || position < 0) {
            throw new IllegalArgumentException("Les paramètres orientation, cases et position doivent être valides.");
        }
        this.orientation = orientation;
        this.cases = cases;
        this.position = position;
    }


    public Case getCaseNum(int num) {
        if (num >= 0 && num < cases.size()) {
            return cases.get(num);
        }
        return null; 
    }

   
    public LinkedList<Case> getCaseLibre() {
        LinkedList<Case> caseLibres = new LinkedList<>();
        for (Case c : cases) {
            if (c.estLibre()) {
                caseLibres.add(c);
            }
        }
        return caseLibres;
    }

   
    public Case getCaseLibreValeurMax() {
        LinkedList<Case> libres = getCaseLibre();
        if (libres.isEmpty()) {
            return null; 
        }

        Case caseMax = libres.get(0);
        for (Case c : libres) {
            if (c.getValeur() > caseMax.getValeur()) {
                caseMax = c;
            }
        }
        return caseMax;
    }

    // Retourne l'orientation
    public Orientation getOrientation() {
        return orientation;
    }

    // Retourne la position
    public int getPosition() {
        return position;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlignementCase{orientation=")
          .append(orientation)
          .append(", position=")
          .append(position)
          .append(", cases=[");
        
        for (Case c : cases) {
            sb.append(c.toString()).append(", ");
        }
        
        if (!cases.isEmpty()) {
            sb.setLength(sb.length() - 2); 
        }
        
        sb.append("]}");
        return sb.toString();
    }
}
