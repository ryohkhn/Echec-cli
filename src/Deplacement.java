public class Deplacement {
    public final int x0;
    public final int y0;
    public final int x1;
    public final int y1;

    public Deplacement(int x0,int y0,int x1,int y1){
        this.x0=x0;
        this.x1=x1;
        this.y0=y0;
        this.y1=y1;
    }

    public char typeDeplacement(){
        // si x équivalent c'est un déplacement vertical
        if(this.x0==this.x1) return 'v';
        // si y équivalent c'est un déplacement horizontal
        if(this.y0==this.y1) return 'h';
        // si la différence de x0-x1 en valeur absolue est égale à celle de y0 avec y1 alors c'est une diagonale
        if(Math.abs(this.x0-this.x1)==Math.abs(this.y0-this.y1)) return 'd';
        // vérification de toutes les cases possibles selon la position de départ pour les déplacements du cavalier
        if((this.x0-2==this.x1 && this.y0-1==this.y1) || (this.x0-2==this.x1 && this.y0+1==this.y1)
                || (this.x0+2==this.x1 && this.y0-1==this.y1) || (this.x0+2==this.x1 && this.y0+1==this.y1)
                || (this.x0-1==this.x1 && this.y0-2==this.y1) || (this.x0+1==this.x1 && this.y0-2==this.y1)
                || (this.x0-1==this.x1 && this.y0+2==this.y1) || (this.x0+1==this.x1 && this.y0+2==this.y1)){
            return 'c';
        }
        return 'x';
    }

    public int dist(){
        if(this.typeDeplacement()=='c' || this.typeDeplacement()=='x') return -1;
        // cas d'un déplacement vertical
        if(this.x0==this.x1) return Math.abs(this.y0-this.y1);
        // le déplacement horizontale et diagonale s'obtient par le même calcul, c'est donc le dernier cas
        return Math.abs(this.x0-this.x1);
    }

    // permet de retourner la piece coorespondante au déplacement
    public Piece getPieceMove(Plateau p){
        if(p.getCase(this.x0,this.y0).estVide()) {
            return null;
        }
        return p.getCase(this.x0,this.y0).getPiece();
    }

    // permet de retourner la piece d'arrivée du déplacement
    public Piece getPieceDest(Plateau p){
        if(p.getCase(this.x1,this.y1).estVide()) {
            return null;
        }
        return p.getCase(this.x1,this.y1).getPiece();
    }

}
