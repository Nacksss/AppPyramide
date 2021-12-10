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

public class Fragment_RN extends Fragment {

    public int choixCouleur; // 0 pr noir, 1 pr rouge
    TextView tv;
    private ArrayList<String> s1;
    public int i, newI;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rn, container, false);

        //recoit l'arraylist des noms des joueurs de l'activité carte RN
        tv = (TextView) view.findViewById(R.id.nomjoueur);


        Bundle bundleNom = getArguments();
        //pr afficher le nom du joueur correspondant
        s1 = bundleNom.getStringArrayList("listNom");

        Bundle bundlef = getArguments();
        newI = bundlef.getInt("int");
        ArrayList<String> a = bundleNom.getStringArrayList("l1");
        ArrayList<String> b = bundleNom.getStringArrayList("l2");

        //i=0;
        //i = bundleNom.getInt("int");
        if(i==0){
            tv.setText("" + s1.get(i));
        }else{
            tv.setText(""+ s1.get(newI));
        }



        int nbJoueur = bundleNom.getInt("count");
        //Toast.makeText(getContext(), ""+ nbJoueur, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), ""+ i + "", Toast.LENGTH_SHORT).show();

        //i = i +1;



        //on va regarder si jeu de carte fonctionne
        //JeuDeCarte jeu = new JeuDeCarte(); //on instancie un jeu de carte
        //affichage aléatoire carte avec Hashmap
        Random r = new Random();
        int n = r.nextInt(52);
        //Toast.makeText(getContext(), "" + jeu.getCarte(n), Toast.LENGTH_SHORT).show();

        Button btnRouge = (Button) view.findViewById(R.id.buttonR);
        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //i++;
                choixCouleur = 1;
                Bundle bundleR = new Bundle();
                bundleR.putInt("choix", choixCouleur);
                bundleR.putInt("nb", i);
                bundleR.putInt("count", nbJoueur);
                bundleR.putStringArrayList("l1",a);
                bundleR.putStringArrayList("l2",b);
                bundleR.putStringArrayList("listNom",s1);

                Fragment_afficheCarte frag = new Fragment_afficheCarte();
                frag.setArguments(bundleR);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, frag).commit();
            }
        });

        Button btnNoir = (Button) view.findViewById(R.id.buttonN);
        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //i++;
                choixCouleur = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("choix", choixCouleur);
                bundle.putInt("nb", i);
                bundle.putInt("count", nbJoueur);
                bundle.putStringArrayList("l1",a);
                bundle.putStringArrayList("l2",b);
                bundle.putStringArrayList("listNom",s1);

                Fragment_afficheCarte fragment_afficheCarte = new Fragment_afficheCarte();
                fragment_afficheCarte.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_afficheCarte).commit();
            }
        });

        return view;

    }
}