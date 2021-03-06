package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Fragment_symbole extends Fragment {

    //Déclaration variables
    public EditText choixSymbole;
    public TextView nom;
    public Button btnValidation;
    public ArrayList<String> s1, liste;
    public int nb;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symbole, container, false);

        //Initialisation
        choixSymbole = view.findViewById(R.id.choixSymbole);
        btnValidation = view.findViewById(R.id.btnValidation);
        nom = view.findViewById(R.id.NOMjoueur);

        Bundle bundleR = getArguments();
        nb = bundleR.getInt("nb");
        int count = bundleR.getInt("count");
        liste = bundleR.getStringArrayList("liste");
        s1 = bundleR.getStringArrayList("listNom");


        //affiche le nom du joueur qui a tiré la carte
        nom.setText(""+s1.get(nb));
        nb = nb+1;

        //Action sur au clic sur le btn Valider choix
        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //récupérer le texte entré par l'utilisateur dans l'editVie
                String TexteChoix = choixSymbole.getText().toString();

                //Si le mot est conforme
                if (TexteChoix.equals("Pique") || TexteChoix.equals("Trefle") ||
                        TexteChoix.equals("Carreau") || TexteChoix.equals("Coeur")) {

                    Fragment_resultatSymbole fragment_resultatSymbole = new Fragment_resultatSymbole();
                    Bundle bundlesymb = new Bundle();
                    bundlesymb.putStringArrayList("liste", liste);
                    bundlesymb.putStringArrayList("listeNom", s1);
                    bundlesymb.putInt("nb", nb);
                    bundlesymb.putInt("count", count);
                    bundlesymb.putString("Choix", String.valueOf(TexteChoix));
                    fragment_resultatSymbole.setArguments(bundlesymb);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_containerRN, fragment_resultatSymbole).commit();
                }
                //Si le mot ne l'est pas
                else {
                    Toast.makeText(getContext(), "Il faut entrer un nom de symbole existant ! (Trefle,Pique,Carreau,Coeur) ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}