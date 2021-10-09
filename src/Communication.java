import java.util.Scanner;

public class Communication {
    private Scanner scanReponse=new Scanner(System.in);

    public Deplacement demanderDeplacement(boolean joueur){
        String alphabet="abcdefghijklmnopqrstuvwxyz"; // alphabet pour récupérer l'index correspondant
        int x0,y0,x1,y1;
        System.out.println("En quelle hauteur est votre pièce (lettre) ?");
        String s=scanReponse.next().toLowerCase(); // on utilise la fonction String.toLowerCase() pour ne pas avoir de problème avec les majuscules
        // si la fonction indexOf ne trouve pas le caractère envoyé via le scanner dans le string alphabet il return -1, si c'est le cas on relance la fonction
        if((alphabet.indexOf(s.charAt(0)))<0){
            System.out.println("Vous devez entrer une lettre présente dans l'alphabet pour le premier caractère.");
            return demanderDeplacement(joueur);
        }
        y0=alphabet.indexOf(s.charAt(0));
        System.out.println("En quelle largeur est votre pièce (chiffre) ?");
        x0=scanReponse.nextInt();
        if(x0<0){
            System.out.println("Vous devez entrer une valeur positive.");
            return demanderDeplacement(joueur); // si la coordonnée de largeur est négative on relance la fonction
        }
        System.out.println("En quelle hauteur voulez-vous faire votre déplacement (lettre) ?");
        String s2=scanReponse.next().toLowerCase();
        if((alphabet.indexOf(s2.charAt(0)))<0){
            System.out.println("Vous devez entrer une lettre présente dans l'alphabet pour le premier caractère.");
            return demanderDeplacement(joueur);
        }
        y1=alphabet.indexOf(s2.charAt(0));
        System.out.println("En quelle largeur voulez-vous faire votre déplacement (chiffre) ?");
        x1=scanReponse.nextInt();
        if(x1<0){
            System.out.println("Vous devez entrer une valeur positive.");
            return demanderDeplacement(joueur); // si la coordonnée de largeur est négative on relance la fonction
        }
        return new Deplacement(x0,y0,x1,y1);
    }

}
