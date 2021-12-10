package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentResultatPM extends Fragment {

    public TextView resultapm, firstcarte, secondcarte;
    public Button Jsuivant;
    public int r;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultatpm, container, false);

        //Initialisation des variables
        resultapm = view.findViewById(R.id.resultatpm);
        firstcarte = view.findViewById(R.id.firstcarte);
        secondcarte = view.findViewById(R.id.secondcarte);
        Jsuivant = view.findViewById(R.id.prochain_joueur);

        Bundle bundleR = getArguments();
        bundleR.getInt("résultatPM");

        //affiche le résultat ds un txtView
        if( r == 1){
            resultapm.setText("Bravo, tu donnes deux gorgées au joeur de ton choix");
            //Toast.makeText(getContext(), "Bravo, tu donnes une gorgée au joeur de ton choix", Toast.LENGTH_SHORT).show();
        }else{
            resultapm.setText("Ratté, tu bois deux gorgées");
            //Toast.makeText(getContext(), "Ratté, tu bois une gorgées", Toast.LENGTH_SHORT).show();
        }

        firstcarte.setText("1ère carte tirée : \n"); //rajouter le carte
        secondcarte.setText("2ème carte tirée : \n"); //rajouter le carte

        //donne les deux cartes du joeurs

        //Btn joueurs suivant
        //si il reste des joeurs dans ce tour
        // on retourse ds fragm Plus ou Moins
        //else
        Jsuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_symbole fragment_symbole = new Fragment_symbole();
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_symbole).commit();
            }
        });

        return view;
    }
}