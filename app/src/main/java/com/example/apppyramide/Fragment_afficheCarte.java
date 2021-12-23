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


public class Fragment_afficheCarte extends Fragment {

    //Déclaration des variables
    TextView CarteObtenue, nomJoueur;
    TextView resultat;
    Button JoueurSuivant, TourSuivant;
    public String valeurCarte;
    public String Type;
    public int CouleurCarte, count;
    public int i;
    public ArrayList<String> s1;
    public ArrayList<String> liste_1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_affiche_carte, container, false);

        //Initialisation
        CarteObtenue = view.findViewById(R.id.carte_Tiré) ;
        resultat = view.findViewById(R.id.resultat) ;
        JoueurSuivant = view.findViewById(R.id.joueursuivant);
        TourSuivant = view.findViewById(R.id.Toursuivant);
        nomJoueur = view.findViewById(R.id.NomJoueur);

        //Récupération des arguments important du bundle
        Bundle bundle = this.getArguments();
        int choixCouleur = bundle.getInt("choix");
        i = bundle.getInt("nb");
        s1 = bundle.getStringArrayList("listNom");
        count = bundle.getInt("count");
        liste_1= bundle.getStringArrayList("l1");

        //Pour afficher le nom du joueur jouant la manche
        nomJoueur.setText("" + s1.get(i-1));

        //Gestion des boutons en fonction du nombre de joueur
        //  Soit pour passer au tour suivant, soit pour refaire la première manche mais pour le
        //   joueur suivant
        if( i == count){
            TourSuivant.setVisibility(View.VISIBLE);
            JoueurSuivant.setVisibility(View.INVISIBLE);
        }else{
            JoueurSuivant.setVisibility(View.VISIBLE);
            TourSuivant.setVisibility(View.INVISIBLE);
        }


        //affichage aléatoire carte avec Hashmap
        Random r = new Random ();
        int n = r.nextInt(52);

        //On instancie le jeu de cartes
        JeuDeCarte jeu = new JeuDeCarte();

        //affiche sur l'écran la carte obtenue
        CarteObtenue.setText("" + jeu.getCarte(n).getValue() + " " + jeu.getCarte(n).getType());
        String valeurCarte1 = jeu.getCarte(n).getValue();

        //ajout de la carte tirée à la liste du joueur correspindant
        liste_1.add("" + jeu.getCarte(n).getValue() + " " + jeu.getCarte(n).getType());

        //on récupère le symbole de la carte piochée
        Carte symboleN = jeu.getCarte(n);

        //on vérifie si la carte est noire
        if(symboleN.getType().equals("Pique") || symboleN.getType().equals("Trefle") ) {
            //couleur noire
            CouleurCarte = 0;
        } else {
            //couleur rouge
            CouleurCarte = 1;
        }

        //Comparaison de la couleur de la carte et du choix de joueur
        if( choixCouleur == CouleurCarte){
            resultat.setText("Bravo, tu donnes une gorgée au joueur de ton choix");
        }else{
            resultat.setText("Raté, tu bois une gorgée");
        }

        //retirer carte du paquet
        jeu.removeCarte(n);

        //Action suite au clic sur le bouton JoueurSuivant
        JoueurSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RN fragment_rn = new Fragment_RN();
                Bundle bundlef = new Bundle();
                i = i+1;
                Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();
                bundlef.putInt("int", i);
                bundlef.putStringArrayList("listNom", s1);
                fragment_rn.setArguments(bundlef);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_rn).commit();
            }
        });

        //Action suite au clic sur le bouton TourSuivant
        TourSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_PlusOuMoins frag = new Fragment_PlusOuMoins();
                i = 0; // pour repasser au joueur 1
                Bundle bundleFr = new Bundle();
                bundleFr.putInt("int", i);
                bundleFr.putStringArrayList("listNom", s1);
                bundleFr.putStringArrayList("l1",liste_1);
                bundleFr.putString("Val1", valeurCarte1);
                bundleFr.putInt("count", count);
                frag.setArguments(bundleFr);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, frag).commit();
            }
        });

        return view;
    }
}
