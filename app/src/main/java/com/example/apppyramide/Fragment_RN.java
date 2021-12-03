package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment_RN extends Fragment {

    public int choixCouleur; // 0 pr noir, 1 pr rouge
    TextView tv;
    private ArrayList<String> s1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rn, container, false);

        //recoit l'arraylist des noms des joeurs de l'activité carte RN
        tv = (TextView) view.findViewById(R.id.nomjoueur);

        Bundle bundleNom = getArguments();
        s1 = bundleNom.getStringArrayList("listNom");
        for(int i = 0; i< s1.size(); i++){
            tv.setText("" + s1.get(i));
        }


        //pr afficher le nom du joueur correspondant
        //tv.setText("" + bundleNom);
        //tv.setText("Joueur n° " + s1.size() + " : " + s1[i]);



        Button btnRouge = (Button) view.findViewById(R.id.buttonR);
        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 1;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);

                Fragment_afficheCarte frag = new Fragment_afficheCarte();
                frag.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, frag).commit();

            }
        });

        Button btnNoir = (Button) view.findViewById(R.id.buttonN);
        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);

                Fragment_afficheCarte fr1 = new Fragment_afficheCarte();
                fr1.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fr1).commit();
            }
        });

        return view;

    }
}