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

import java.util.ArrayList;
import java.util.Random;


public class Fragment_afficheCarte extends Fragment {

    TextView CarteObtenue;
    TextView resultat;
    Button JoueurSuivant;
    //public String valeurCarte;
    //public String Type;
    public int CouleurCarte;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_affiche_carte, container, false);

        Bundle bundle = this.getArguments();
        int choixCouleur = bundle.getInt("choix");


        //affichage aléatoire carte avec Hashmap
        Random r = new Random();
        int n = r.nextInt(52);

        CarteObtenue = (TextView) view.findViewById(R.id.carte_Tiré) ;
        resultat = (TextView) view.findViewById(R.id.resultat) ;
        JoueurSuivant = (Button) view.findViewById(R.id.joueursuivant);


        //On définie si la carte est rouge ou noire
        JeuDeCarte jeu = new JeuDeCarte(); //on instancie un jeu de carte

        //retourne la carte obtenue
        CarteObtenue.setText("" + jeu.getCarte(n).getValue() + " " + jeu.getCarte(n).getType());


       // int symboleP = jeu.getCarte(n).indexOf("Pique"); //on regarde s'il y a le mot pique dans la valeur n de la Hashmap
       // int symboleT = jeu.getCarte(n).indexOf("Trèfle"); //on regarde s'il y a le mot trèfle dans la valeur n de la Hashmap
        // la méthode indexof() retourne la position du mot dans la chaîne de caractère.
        // si indexof() ==-1, le mot n'est pas présent

        Carte symboleN = jeu.getCarte(n);

        if( symboleN.getType().equals("Pique") || symboleN.getType().equals("Trèfle")){
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
        //jeu.removeCarte(n);


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
