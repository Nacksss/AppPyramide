package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Fragment_PlusOuMoins extends Fragment {

    //Déclarations variables
    public TextView nom, textv, carte_précédente;
    public Button ButtonPlus, ButtonMoins;
    public int i, r, count, nb ; //nb= nbre joueur ayant joué cette manche
    public ArrayList<String> s1, liste_1;
    String valCarte1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_ou_moins, container, false);

        //Initialisation des variables
        ButtonPlus= view.findViewById(R.id.buttonPlus);
        ButtonMoins= view.findViewById(R.id.buttonMoins);
        nom= view.findViewById(R.id.nom);
        textv= view.findViewById(R.id.textv);
        carte_précédente= view.findViewById(R.id.carte_precedante);

        //Récupère les arguments nécessaire du bundle
        Bundle bundleA = getArguments();
        s1 = bundleA.getStringArrayList("listNom");
        i = bundleA.getInt("num");
        liste_1 = bundleA.getStringArrayList("l1");
        count = bundleA.getInt("count");
        valCarte1 = bundleA.getString("Val1");

        //affiche le nom du joueur qui a tiré la carte
        nom.setText(""+s1.get(i));

        //affiche la carte tiréé par le joueur au tour suivant
        carte_précédente.setText("Votre précédente carte était : "+ liste_1.get(0));

        //incrémente nb pour passer au joueur suivant
        nb = nb+1;

        //au clik sur les btns
        ButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //affiche le fragment résultat de ce tour
                Bundle bundlePM = new Bundle();
                r = 1; //choix plus
                bundlePM.putInt("resultatPM", r);
                bundlePM.putInt("count", count);
                bundlePM.putInt("nb", nb);
                bundlePM.putStringArrayList("l", liste_1);
                bundlePM.putStringArrayList("listNom", s1);
                bundlePM.putString("Val1", valCarte1);
                FragmentResultatPM result = new FragmentResultatPM();
                result.setArguments(bundlePM);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, result).commit();
            }
        });
        ButtonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //affiche le fragment résultat de ce tour
                Bundle bundlePM1 = new Bundle();
                r = 0; //choix moins
                bundlePM1.putInt("resultatPM", r);
                bundlePM1.putInt("count", count);
                bundlePM1.putInt("nb", nb);
                bundlePM1.putStringArrayList("l", liste_1);
                bundlePM1.putStringArrayList("listNom", s1);
                bundlePM1.putString("Val1", valCarte1);
                FragmentResultatPM result = new FragmentResultatPM();
                result.setArguments(bundlePM1);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, result).commit();
            }
        });

        return view;
    }
}