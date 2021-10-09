public class HorVerDiag extends Piece{
    private final boolean goHori;
    private final boolean goDiag;
    private final boolean goAdj;

    public HorVerDiag(boolean couleur, String nom,boolean goHori,boolean goDiag,boolean goAdj){
        super(couleur, nom);
        this.goHori=goHori;
        this.goDiag=goDiag;
        this.goAdj=goAdj; // si goAdj vaut true alors la pièce ne peut se déplacer quand dans des cases adjacentes à la sienne
    }

    // Tour -> Horizontal ou vertical
    // Fou -> Diagonal
    // Dame -> Horizontal ou vertical ou diagonal n cases
    // Roi -> Horizontal ou vertical ou diagonal 1 case

    public boolean estValide(Deplacement d,Plateau p){
        if(!super.estValide(d,p)) return false;
        // cas de la tour
        if(goHori && !goDiag && !goAdj){
            if(d.typeDeplacement()!='h' && d.typeDeplacement()!='v') return false;
        }
        // cas du fou
        else if(!goHori && goDiag && !goAdj){
            if(d.typeDeplacement()!='d') return false;
        }
        // cas de la dame
        else if(goHori && goDiag && !goAdj){
            if(d.typeDeplacement()!='h' && d.typeDeplacement()!='v' && d.typeDeplacement()!='d') return false;
        }
        // cas du roi
        else if(goHori && goDiag && goAdj){
            if(d.typeDeplacement()!='h' && d.typeDeplacement()!='v' && d.typeDeplacement()!='d') return false;
            if(d.dist()>1) return false;
        }
        return true;
    }

    // return true si tous les booléens sont vrais, ce qui correspond au roi
    public boolean estRoi(){
        if(goHori && goDiag && goAdj) return true;
        return false;
    }
}
