package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_RN extends Fragment {

    public int choixCouleur; // 0 pr noir, 1 pr rouge
    TextView tv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rn, container, false);

        tv = (TextView) view.findViewById(R.id.nomjoueur);
        //pr afficher le nom du joueur correspondant
        //tv.setText("Joueur n° " + arraylist.size() + " : " + arrayList(i));




        Button btnRouge = (Button) view.findViewById(R.id.buttonR);
        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 1;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);

                Fragment_afficheCarte fr = new Fragment_afficheCarte();
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fr).commit();

            }
        });

        Button btnNoir = (Button) view.findViewById(R.id.buttonN);
        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);

                Fragment_afficheCarte fr = new Fragment_afficheCarte();
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fr).commit();
            }
        });

        return view;

    }
}