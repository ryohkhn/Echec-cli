public class Cavalier extends Piece{

    public Cavalier(boolean couleur){
        super(couleur,"Cavalier");
    }

    public boolean estValide(Deplacement d,Plateau p){
        // on vérifie si la case est hors limite
        if (p.horsLimite(d)) return false;
        // on retourne false si la case est déjà occupée par une pièce de la même couleur
        if(p.getCase(d.x1,d.y1).getPiece()!=null){
            if(p.getCase(d.x1,d.y1).getCouleurPiece()==this.couleur){
                return false;
            }
        }
        // on vérifie qu'il sagit bien d'un déplacement de cavalier
        if(d.typeDeplacement()!='c') return false;
        return true;
    }

    public boolean estRoi(){
        return false;
    }
}
