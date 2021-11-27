package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_RN2 extends Fragment {

    public int choixCouleur; // 0 pr noir, 1 pr rouge
    TextView tv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__r_n2, container, false);

        tv = (TextView) view.findViewById(R.id.textView3);
        //pr afficher le nom du joueur correspondant
        //tv.setText(arrayList(i));


        Button btnRouge = (Button) view.findViewById(R.id.buttonR);
        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_containerRN, new Fragment_afficheCarte());
                fr.commit();
                choixCouleur = 1;
            }
        });

        Button btnNoir = (Button) view.findViewById(R.id.buttonN);
        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_containerRN, new Fragment_afficheCarte());
                fr.commit();
                choixCouleur = 0;
            }
        });

        return view;

    }
}