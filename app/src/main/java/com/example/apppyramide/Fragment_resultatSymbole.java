package com.example.apppyramide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Fragment_resultatSymbole extends Fragment {

    Button fin, joueurSuivant;
    TextView premierecarte, deuxiemecarte, dernierecarte , resultatSymbole, nomjoueur;
    public ArrayList<String> s1,liste;
    public int nb, count;
    public String choixSymb;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultat_symbole, container, false);

        //Initialisation des variables
        resultatSymbole = view.findViewById(R.id.resultatSymbole);
        premierecarte = view.findViewById(R.id.premierecarte);
        deuxiemecarte = view.findViewById(R.id.deuxiemecarte);
        dernierecarte = view.findViewById(R.id.derniereCarte);
        nomjoueur = view.findViewById(R.id.namejoueur);
        joueurSuivant = view.findViewById(R.id.next_player);
        fin = view.findViewById(R.id.finJeu);

       Bundle bundle = getArguments();
       liste = bundle.getStringArrayList("liste");
       nb = bundle.getInt("nb");
       count = bundle.getInt("count");
       choixSymb = bundle.getString("Choix");
       s1 = bundle.getStringArrayList("listeNom");


        //affiche le nom du joueur qui a tiré la carte
        nomjoueur.setText(""+s1.get(nb-1));


        //génère une nouvelle carte
        Random r = new Random ();
        int n = r.nextInt(52);

        //On instancie le jeu de cartes
        JeuDeCarte jeu = new JeuDeCarte();

        liste.add("" + jeu.getCarte(n).getValue() + " " + jeu.getCarte(n).getType());
        //Toast.makeText(getContext(), ""+ liste, Toast.LENGTH_SHORT).show();


        premierecarte.setText("1ère carte tirée : \n " + liste.get(0));
        deuxiemecarte.setText("2ème carte tirée : \n" + liste.get(1));
        dernierecarte.setText("2ème carte tirée : \n" + liste.get(2));



        //affiche le résultat ds un txtView
       if( choixSymb.equals(jeu.getCarte(n).getType())){
            resultatSymbole.setText("Bravo, tu donnes 3 gorgées au joeur de ton choix");
       }else{
            resultatSymbole.setText("Ratté, tu bois 3 gorgées");
       }


        if( nb == count){
            fin.setVisibility(View.VISIBLE);
            joueurSuivant.setVisibility(View.INVISIBLE);
        }else{
            fin.setVisibility(View.INVISIBLE);
            joueurSuivant.setVisibility(View.VISIBLE);
        }

        //enlève la carte
        jeu.removeCarte(n);
        //Toast.makeText(getContext(), ""+ jeu, Toast.LENGTH_SHORT).show();


       joueurSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_symbole fragment_symbole =new Fragment_symbole();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_symbole).commit();

            }
       });

       fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_finJeu fragment_finJeu = new fragment_finJeu();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_finJeu).commit();
            }
       });

        return view;

    }
}