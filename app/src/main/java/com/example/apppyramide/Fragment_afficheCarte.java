package com.example.apppyramide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Fragment_afficheCarte extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_affiche_carte, container, false);

        Bundle bundle = this.getArguments();
        int choixCouleur = bundle.getInt("choix");

        //affichage aléatoire de la carte


        //Comparaison de la couleur de la carte et du choix de joueur

        /*
        if( choixCouleur == couleurCarte){
            Toast.makeText(getContext(), "Bravo, tu donnes une gorgée au joeur de ton choix", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Ratté, tu bois une gorgées", Toast.LENGTH_SHORT).show();
        }
         */

        Toast.makeText(getContext(), "choix"+ choixCouleur, Toast.LENGTH_SHORT).show();

        //rentré la carte obtenue par le joueur ds la database et la retirer du paquet

        //au click sur le boutton on passe au joueur suivant et donc on retourne ds Fragment RN2

        //une fois que ts les joeurs on joué la première manche on passe à la manche suivante et donc on renvoir
        //vers un autre fragments
        return view;
    }
}
