package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;


public class FragmentResultatPM extends Fragment {

    //Déclaration des variables
    public TextView resultapm, firstcarte, secondcarte, nomjoueur;
    public Button Jsuivant, Toursuivant;
    public int  nb, count;
    public ArrayList<String> liste, s1;
    String val1, val2;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultatpm, container, false);

        //Initialisation des variables
        resultapm = view.findViewById(R.id.resultatpm);
        firstcarte = view.findViewById(R.id.firstcarte);
        secondcarte = view.findViewById(R.id.secondcarte);
        nomjoueur = view.findViewById(R.id.nommjoueur);
        Jsuivant = view.findViewById(R.id.prochain_joueur);
        Toursuivant = view.findViewById(R.id.prochainTour);

        //Récupère les arguments nécesaires
        Bundle bundleR = getArguments();
        int result = bundleR.getInt("resultatPM");
        count = bundleR.getInt("count");
        nb = bundleR.getInt("nb");
        liste = bundleR.getStringArrayList("l");
        s1 = bundleR.getStringArrayList("listNom");
        val1 = bundleR.getString("Val1");

        //affiche le nom du joueur qui a tiré la carte
        nomjoueur.setText(""+s1.get(nb-1));
        //Gestion de l'affichage des boutons en fonction du nombre de joueur
        if( nb == count){
            Toursuivant.setVisibility(View.VISIBLE);
            Jsuivant.setVisibility(View.INVISIBLE);
        }else{
            Toursuivant.setVisibility(View.INVISIBLE);
            Jsuivant.setVisibility(View.VISIBLE);
        }

        //génère une nouvelle carte
        Random r = new Random ();
        int n = r.nextInt(52);

        //On instancie le jeu de cartes
        JeuDeCarte jeu = new JeuDeCarte();
        //Ajout de la carte tiré à la liste du joueur
        liste.add("" + jeu.getCarte(n).getValue() + " " + jeu.getCarte(n).getType());

        //Affiche les deux cartes du joeurs
        firstcarte.setText("1ère carte tirée : \n\n " + liste.get(0));
        secondcarte.setText("2ème carte tirée : \n\n" + liste.get(1));

    //Gestion des cas des cartes particulières, pour le phase du plus ou moins
        if(val1.equals("As")){
            val1 = "1";
        }if(val1.equals("Valet")){
            val1 = "11";
        }if(val1.equals("Dame")){
            val1 = "12";
        }if(val1.equals("Roi")){
            val1 = "13";
        }
        int v1 = Integer.parseInt(val1);

        val2 = jeu.getCarte(n).getValue();
        if(val2.equals("As")){
            val2 = "1";
        }if(val2.equals("Valet")){
            val2 = "11";
        }if(val2.equals("Dame")){
            val2 = "12";
        }if(val2.equals("Roi")){
            val2 = "13";
        }
        int v2 = Integer.parseInt(val2);
        //fin carte particulière

        //enlève la carte
        jeu.removeCarte(n);


        //affiche le résultat du plus ou moins entre la carte pécédente et la carte tirée
        // ds un txtView
       if( ((result == 1) && v2>v1) || ((result == 0) && v2<v1)){
            resultapm.setText("Bravo, tu donnes deux gorgées au joeur de ton choix");
        }else{
            resultapm.setText("Ratté, tu bois deux gorgées");
        }

       //Action suite au clic sur joueur suivant
       Jsuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_PlusOuMoins fragment_plusOuMoins =new Fragment_PlusOuMoins();
                Bundle bundlex = new Bundle();
                bundlex.putInt("nb",nb);
                bundlex.putStringArrayList("listNom", s1);
                bundlex.putInt("count", count);
                bundlex.putStringArrayList("liste", liste);
                fragment_plusOuMoins.setArguments(bundlex);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_plusOuMoins).commit();

            }
       });

        //Action suite au clic sur tour suivant
       Toursuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_symbole fra = new Fragment_symbole();
                nb = 0;
                Bundle bundlefra = new Bundle();
                bundlefra.putInt("nb",nb);
                bundlefra.putInt("count", count);
                bundlefra.putStringArrayList("listNom", s1);
                bundlefra.putStringArrayList("liste", liste);
                fra.setArguments(bundlefra);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fra).commit();
            }
       });

        return view;
    }
}