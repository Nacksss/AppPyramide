package com.example.apppyramide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Fragment_afficheCarte extends Fragment {

    TextView CarteObtenue;
    TextView resultat;
    Button JoueurSuivant;
    public String valeurCarte;
    public String Type;
    public int CouleurCarte;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_affiche_carte, container, false);

        Bundle bundle = this.getArguments();
        int choixCouleur = bundle.getInt("choix");

        //affichage aléatoire de la carte
        //Random r = new Random();
        //int n = r.nextInt(13);
        //Random r1 = new Random();
        //int type = r1.nextInt(4);

        //affichage aléatoire carte avec Hashmap
        Random r = new Random();
        int n = r.nextInt(52);

        CarteObtenue = (TextView) view.findViewById(R.id.carte_Tiré) ;
        resultat = (TextView) view.findViewById(R.id.resultat) ;
        JoueurSuivant = (Button) view.findViewById(R.id.joueursuivant);

        /* on définie le num de la carte
        if(n == 1) {
            valeurCarte ="As";
        }
        else if(n == 2) {
            valeurCarte ="2";
        }
        else if(n == 3) {
            valeurCarte ="3";
        }
        else if(n == 4) {
            valeurCarte ="4";
        }
        else if(n == 5) {
            valeurCarte ="5";
        }
        else if(n == 6) {
            valeurCarte ="6";
        }
        else if(n == 7) {
            valeurCarte ="7";
        }
        else if(n == 8) {
            valeurCarte ="8";
        }
        else if(n == 9) {
            valeurCarte ="9";
        }
        else if(n == 10) {
            valeurCarte ="10";
        }
        else if(n == 11) {
            valeurCarte ="J";
        }
        else if(n == 12) {
            valeurCarte ="Q";
        }
        else if(n == 13) {
            valeurCarte ="K";
        }
        */


        //On définie le type de la carte
        /*if(type == 1) {
            Type ="Coeur";
        }
        else if(type == 2) {
            Type ="Carreau";
        }
        else if(type == 3) {
            Type ="Pique";
        }
        else if(type == 4) {
            Type ="Trèfle";
        }

         */


        //On définie si la carte est rouge ou noire
        JeuDeCarte jeu = new JeuDeCarte(); //on instancie un jeu de carte

        //retourne la carte obtenue
        CarteObtenue.setText(jeu.getValeurH(n));


        int symboleP = jeu.getValeurH(n).indexOf("Pique"); //on regarde s'il y a le mot pique dans la valeur n de la Hashmap
        int symboleT = jeu.getValeurH(n).indexOf("Trèfle"); //on regarde s'il y a le mot trèfle dans la valeur n de la Hashmap
        // la méthode indexof() retourne la position du mot dans la chaîne de caractère.
        // si indexof() ==-1, le mot n'est pas présent

        if( symboleP != -1 || symboleT != -1){
            //couleur noire
            CouleurCarte = 0;
        }else{
            //couleur rouge
            CouleurCarte = 1;
        }

        //Comparaison de la couleur de la carte et du choix de joueur
        if( choixCouleur == CouleurCarte){
            resultat.setText("Bravo, tu donnes une gorgée au joueur de ton choix");
            //Toast.makeText(getContext(), "Bravo, tu donnes une gorgée au joeur de ton choix", Toast.LENGTH_SHORT).show();
        }else{
            resultat.setText("Raté, tu bois une gorgées");
            //Toast.makeText(getContext(), "Ratté, tu bois une gorgées", Toast.LENGTH_SHORT).show();
        }


        //retirer carte du paquet
        jeu.remove(n);


        //au click sur le boutton on passe au joueur suivant et donc on retourne ds Fragment RN

        //si tous les joueurs n'ont pas encore fait le premier tour
        //on renvoie vers fragment RN
        //si non vers le prochaine frag
        JoueurSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (il reste des joueurs )
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_containerRN, new Fragment_RN());
                    fr.commit();
                //else{
                    //FragmentTransaction fr1 = getFragmentManager().beginTransaction();
                    //fr1.replace(R.id.fragment_containerRN, new Fragment_PlusOuMoins());
                    //fr1.commit();
                //}
            }
        });

        //une fois que ts les joeurs on joué la première manche on passe à la manche suivante et donc on renvoir
        //vers un autre fragments

        return view;
    }
}
