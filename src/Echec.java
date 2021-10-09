public class Echec {
    public boolean joueur;

    public Echec(){
        this.joueur=true;
    }

    public void jouerTour(Deplacement d,boolean joueur,Plateau p){
        // on vérifie que le déplacement est valide
        if(d.getPieceMove(p).estValide(d,p)){
            Piece temp=d.getPieceMove(p);
            p.viderCase(d.x0,d.y0);
            p.remplirCase(d.x1,d.y1,temp);
        }
        else{
            System.out.println("Vous ne pouvez pas faire ce déplacement.");
        }
    }


    public void jouerPartie(){
        Communication com=new Communication();
        Plateau plateau=new Plateau(8,8);
        plateau.attribuerPiece();
        boolean win=false;
        while(true){
            plateau.afficher();
            System.out.println("\nAu tour des "+(this.joueur?"blanc":"noir")+" de jouer.\n");
            Deplacement d=com.demanderDeplacement(this.joueur);
            // on vérifie la présence d'une pièce sur la case de départ, si le déplacement est valide et si la couleur de la pièce d'origine est bien celle du joueur
            while(d.getPieceMove(plateau)==null || !d.getPieceMove(plateau).estValide(d,plateau) || d.getPieceMove(plateau).couleur!=this.joueur){
                plateau.afficher();
                System.out.println("Vous ne pouvez pas faire ce déplacement");
                d=com.demanderDeplacement(this.joueur);
            }
            // on actualise la valeur booléenne win après avoir vérifé que le déplacemenet était valide, et avant d'avoir effectué le déplacement
            if(d.getPieceDest(plateau)!=null && d.getPieceDest(plateau).estRoi()) {
                win=true;
            }
            this.jouerTour(d,this.joueur,plateau);
            if(win){
                plateau.afficher();
                System.out.println("Le joueur "+(this.joueur?"blanc":"noir")+" a gagné la partie !");
                return;
            }
            // on actualise la couleur en fin de tour
            if(this.joueur){
                this.joueur=false;
            }else{
                this.joueur=true;
            }
        }
    }

    public static void main(String[] args){
        Echec echec=new Echec();
        echec.jouerPartie();
    }
}
