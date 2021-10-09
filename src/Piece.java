public class Piece {
    protected final boolean couleur;
    private final String nom;

    public Piece(boolean couleur,String nom){
        this.couleur=couleur;
        this.nom=nom;
    }

    public String toString(){
        String res=this.nom.substring(0,1);
        if(!couleur){
            res=res.toUpperCase();
            res+=this.nom.substring(1);
            return res;
        }
        res=res.toLowerCase();
        res+=this.nom.substring(1);
        return res;
    }

    public String getNom(){
        return nom;
    }

    public boolean estValide(Deplacement d,Plateau p){
        // si on reste sur la même case, on retourne false
        if(d.x0==d.x1 && d.y0==d.y1) return false;
        // on retourne false si le type de déplacement n'est pas celui d'une pièce ou si la case est hors limite
        if (d.typeDeplacement() == 'x' || p.horsLimite(d)) return false;
        // on retourne false si la case est déjà occupée par une pièce de la même couleur
        if(p.getCase(d.x1,d.y1).getPiece()!=null){
            if(p.getCase(d.x1,d.y1).getCouleurPiece()==this.couleur){
                return false;
            }
        }
        // on vérifie qu'il n'y a aucune pièce sur le chemin du déplacement vertical
        if (d.typeDeplacement()=='v'){
            if (d.y0<d.y1){ // cas ou le pion descend le tableau
                for(int i=d.y0+1;i<d.y1;i++) {
                    if(!p.getCase(d.x1,i).estVide()) return false;
                }
            }else{ // cas ou le pion monte le tableau
                for(int i=d.y0-1;i>d.y1;i--) {
                    if(!p.getCase(d.x1,i).estVide()) return false;
                }
            }
        }
        // on vérifie qu'il n'y a aucune pièce sur le chemin du déplacement horizontal
        else if(d.typeDeplacement()=='h'){
            if(d.x0<d.x1){
                for(int i=d.x0+1;i<d.x1;i++) {
                    if(!p.getCase(i,d.y1).estVide()) return false;
                }
            }else{
                for(int i=d.x0+1;i>d.x1;i--) {
                    if(!p.getCase(i,d.y1).estVide()) return false;
                }
            }
        }
        // on traite les 4 diagonales possibles et on vérifie que chaque case ne comporte pas de pièce
        else if(d.typeDeplacement()=='d'){
            if(d.y0<d.y1){
                if(d.x0<d.x1){
                    for(int i=1;i<d.dist();i++){
                        if(!p.getCase(d.x0+i,d.y0+i).estVide()){
                            return false;
                        }
                    }
                }
                else{
                    for(int i=1;i<d.dist();i++){
                        if(!p.getCase(d.x0-i,d.y0+i).estVide()){
                            return false;
                        }
                    }
                }
            }
            else{
                if(d.x0<d.x1){
                    for(int i=1;i<d.dist();i++){
                        if(!p.getCase(d.x0+i,d.y0-i).estVide()){
                            return false;
                        }
                    }
                }
                else{
                    for(int i=1;i<d.dist();i++){
                        if(!p.getCase(d.x0-i,d.y0-i).estVide()){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean estRoi(){
        return false;
    }
}
