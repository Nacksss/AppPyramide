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


public class Fragment_RN extends Fragment {

    //Déclaration des variables
    public int choixCouleur; // 0 pr noir, 1 pr rouge
    TextView tv;
    private ArrayList<String> s1;
    public ArrayList<String> liste_1;
    public int i, newI;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rn, container, false);

        //Initialisation
        tv = (TextView) view.findViewById(R.id.nomjoueur);
        Button btnRouge = (Button) view.findViewById(R.id.buttonR);
        Button btnNoir = (Button) view.findViewById(R.id.buttonN);

        //recoit les différents arguments du  bundle de l'activité carte RN
        Bundle bundleNom = getArguments();
        s1 = bundleNom.getStringArrayList("listNom");
        liste_1 = bundleNom.getStringArrayList("l1");
        int nbJoueur = bundleNom.getInt("count");

        Bundle bundlef = getArguments();
        newI = bundlef.getInt("int");

        //Affichage du nom du joeur
        //Ce nom doit évoluer si l'on passe au second joueur et ainsi de suite
        if(i==0){
            tv.setText("" + s1.get(i));
        }else{
            tv.setText(""+ s1.get(newI));
        }

        //incrémentation du i, pour pouvoir passer au joueur suivant, lors du retour possible sur ce fragment
        i = i +1;


        //affichage aléatoire carte avec Hashmap
        Random r = new Random();
        int n = r.nextInt(52);


        //Action suite au clic sur "Rouge"
        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 1;
                Bundle bundleR = new Bundle();
                bundleR.putInt("choix", choixCouleur);
                bundleR.putInt("nb", i);
                bundleR.putInt("count", nbJoueur);
                bundleR.putStringArrayList("l1", liste_1);
                bundleR.putStringArrayList("listNom",s1);

                Fragment_afficheCarte frag = new Fragment_afficheCarte();
                frag.setArguments(bundleR);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, frag).commit();
            }
        });

        //Action suite au clic sur "Noir"
        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choixCouleur = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);
                bundle.putInt("nb", i);
                bundle.putInt("count", nbJoueur);
                bundle.putStringArrayList("l1", liste_1);
                bundle.putStringArrayList("listNom",s1);

                Fragment_afficheCarte fragment_afficheCarte = new Fragment_afficheCarte();
                fragment_afficheCarte.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_afficheCarte).commit();
            }
        });

        return view;
    }
}