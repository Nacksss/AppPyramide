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

    public TextView nom, textv, carte_précédente;
    public Button ButtonPlus, ButtonMoins;
    public int i, r;
    public ArrayList<String> s1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_ou_moins, container, false);

        //Initialisation des variables
        ButtonPlus= view.findViewById(R.id.buttonPlus);
        ButtonMoins= view.findViewById(R.id.buttonMoins);
        nom= view.findViewById(R.id.nom);
        textv= view.findViewById(R.id.textv);
        carte_précédente= view.findViewById(R.id.carte_precedante);

        Bundle bundleA = getArguments();
        s1 = bundleA.getStringArrayList("listNom");
        i = bundleA.getInt("num");

        //affiche le nom du joueur qui a tiré la carte
        nom.setText(""+s1.get(i));

        //affiche la carte tiréé par le joueur au tour suivant
        carte_précédente.setText("Votre précédente carte était : "   );//+joueur i carte

        //au clik sur les btns
        ButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compare la valeur des deux cartes
                //si vrai r = 1     si faux r =0

                //affiche le fragment résultat de ce tour
                Bundle bundlePM = new Bundle();
                bundlePM.putInt("résultatPM", r);
                FragmentResultatPM result = new FragmentResultatPM();
                result.setArguments(bundlePM);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, result).commit();
            }
        });

        ButtonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compare la valeur des deux cartes
                //si vrai r = 1     si faux r =0

                //affiche le fragment résultat de ce tour
                Bundle bundlePM1 = new Bundle();
                bundlePM1.putInt("résultatPM", r);
                FragmentResultatPM result = new FragmentResultatPM();
                result.setArguments(bundlePM1);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, result).commit();

            }
        });

        return view;
    }
}