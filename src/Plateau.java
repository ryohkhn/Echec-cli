public class Plateau {
    private final int longueur;
    private final int largeur;
    private final Case[][] cases;

    public Plateau(int longueur,int largeur){
        // si une valeur négative est donnée on forme le plateau à 4
        if(longueur<4) longueur=4;
        if(largeur<4) largeur=4;
        if(longueur>8) longueur=8; // si la longueur est plus grande que 8 on crée le plateau avec 8 de largeur
        this.longueur=longueur;
        this.largeur=largeur;
        cases=new Case[longueur][largeur];
        for(int i = 0; i <this.cases.length ; i++) {
            for(int j = 0; j <this.cases[0].length ; j++) {
                if(i%2==j%2){ // on vérifie si les deux cases sont paires ou impaires ce qui implique que la case est noire
                    cases[i][j]=new Case(false);
                }
                else{
                    cases[i][j]=new Case(true);
                }
            }
        }
    }

    public boolean horsLimite(int x,int y){
        if(x>=this.longueur || y>=this.largeur || x<0 || y<0){
            return true; // on retourne true si les coordonnées sont bien en dehors des limites du tableau
        }
        return false;
    }

    public boolean horsLimite(Deplacement d){
        if(d.x1>=this.longueur || d.y1>=this.largeur || d.x1<0 || d.y1<0){
            return true; // on retourne true si les coordonnées sont bien en dehors des limites du tableau
        }
        return false;
    }

    public Case getCase(int x,int y){
        if(horsLimite(x,y)){
            System.out.println("Entrez des coordonnées valables.");
            return null;
        }
        return this.cases[x][y];
    }

    public Case[][] getCases(){
        return cases;
    }

    public void viderCase(int x, int y){
        if(horsLimite(x,y)){
            System.out.println("Entrez des coordonnées valables.");
            return;
        }
        this.cases[x][y].enleverPiece();
    }

    public void remplirCase(int x,int y,Piece p){
        if(horsLimite(x,y)){
            System.out.println("Entrez des coordonnées valables.");
            return;
        }
        this.cases[x][y].remplirePiece(p);
    }

    public void afficher(){
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print("    ");
        // affichage des valeurs de x
        for (int i = 0; i < cases.length ; i++) {
            System.out.print(i+"  ");
        }
        System.out.println();
        for (int i = 0; i < cases.length; i++) {
            System.out.print("----");
        }
        System.out.println();
        for(int i = 0; i <cases.length ; i++) {
            for(int j = 0; j <cases[0].length; j++) {
                if(j==0) System.out.print(alphabet.charAt(i)+" | "); // affichage des valeurs de y en lettres
                System.out.print(cases[j][i]+"  ");
            }
            System.out.println("");
        }
    }

    public void attribuerPiece(){
        int l=cases[0].length-1;
        // attribution des 16 pièces noires et blanches
        cases[0][0].remplirePiece(new HorVerDiag(false,"tour",true,false,false));
        cases[1][0].remplirePiece(new Cavalier(false));
        cases[2][0].remplirePiece(new HorVerDiag(false,"fou",false,true,false));
        cases[3][0].remplirePiece(new HorVerDiag(false,"roi",true,true,true));
        cases[4][0].remplirePiece(new HorVerDiag(false,"dame",true,true,false));
        cases[5][0].remplirePiece(new HorVerDiag(false,"fou",false,true,false));
        cases[6][0].remplirePiece(new Cavalier(false));
        cases[7][0].remplirePiece(new HorVerDiag(false,"tour",true,false,false));
        cases[0][l].remplirePiece(new HorVerDiag(true,"tour",true,false,false));;
        cases[1][l].remplirePiece(new Cavalier(true));
        cases[2][l].remplirePiece(new HorVerDiag(true,"fou",false,true,false));
        cases[3][l].remplirePiece(new HorVerDiag(true,"roi",true,true,true));
        cases[4][l].remplirePiece(new HorVerDiag(true,"dame",true,true,false));
        cases[5][l].remplirePiece(new HorVerDiag(true,"fou",false,true,false));
        cases[6][l].remplirePiece(new Cavalier(true));
        cases[7][l].remplirePiece(new HorVerDiag(true,"tour",true,false,false));

        // attribution des pions
        for(int i=0;i<cases.length;i++){
            cases[i][1].remplirePiece(new Pion(false));
        }
        for(int i=0;i<cases.length;i++){
            cases[i][l-1].remplirePiece(new Pion(true));
        }
    }
}
