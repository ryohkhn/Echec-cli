public class Pion extends Piece{

    public Pion(boolean couleur){
        super(couleur,"Pion");
    }

    public boolean estValide(Deplacement d,Plateau p){
        if(!super.estValide(d,p)) return false;
        // s'il s'agit d'un déplacement diagonal, il faut que le pion prenne une pièce
        if(d.typeDeplacement()=='d'){
            if(d.dist()==1){
                if(p.getCase(d.x1,d.y1).estVide()) return false;
            }else{
                return false;
            }
        }
        // on vérifie qu'il sagit bien d'un déplacement vertical, que la case d'arrivée est vide et qu'il ne peut se déplacer par deux que depuis sa position initiale
        else if(d.typeDeplacement()=='v'){
            if(d.dist()==2){
                if(this.couleur){
                    if(d.y0!=p.getCases()[0].length-2) return false;
                }else{
                    if(d.y0!=1) return false;
                }
            }
            if(!p.getCase(d.x1,d.y1).estVide()) return false;
        }
        // on vérifie que le pion ne va pas en arrière
        if(this.couleur){
            if(d.y0<=d.y1) return false;
        }else{
            if(d.y0>=d.y1) return false;
        }
        if(d.dist()>2 || d.dist()<=0) return false;
        return true;
    }

    public boolean estRoi(){
        return false;
    }
}
