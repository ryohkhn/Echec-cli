public class Case {
    private final boolean couleurCase;
    private Piece piece;

    public Case(boolean couleurCase,Piece piece){
        this.couleurCase=couleurCase;
        this.piece=piece;
    }

    public Case(boolean couleurCase){
        this(couleurCase,null);
    }

    public Piece getPiece(){
        return piece;
    }

    // permet de récupérer la couleur de la pièce
    public boolean getCouleurPiece(){
        return this.piece.couleur;
    }

    public boolean estVide(){
        if(this.piece==null) return true;
        return false;
    }

    public void remplirePiece(Piece p){
        this.piece=p;
    }

    public void enleverPiece(){
        this.piece=null;
    }

    public String toString(){
        if(estVide()){
            if(couleurCase) return "-";
            return "*";
        }
        // on retourne la première lettre via la méthode toString() de Piece qui met la majuscule en fonction de si la pièce est noire
        return piece.toString().substring(0,1);
    }


}
