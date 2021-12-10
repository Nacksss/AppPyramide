package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment_symbole extends Fragment {

    EditText choixSymbole;
    Button btnValidation;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symbole, container, false);

        choixSymbole = view.findViewById(R.id.choixSymbole);
        btnValidation = view.findViewById(R.id.btnValidation);
        Editable texte = choixSymbole.getText();


        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), ""+texte, Toast.LENGTH_SHORT).show();
                if( !texte.equals("pique") || !texte.equals("trefle")||
                        !texte.equals("Carreau") || !texte.equals("Coeur")){
                    Toast.makeText(getContext(), "Il faut entrer un nom de symbole existant ! (Trèfles,Pique,Carreau,Coeur) ", Toast.LENGTH_SHORT).show();
                }else{
                    Bundle bundleR = new Bundle();
                    //bundleR.putString("choix", texte);

                    //générer une nouvelle carte aléatoire
                    //comparer le type de la carte avec le choix du joeur

                }
            }
        });

        //faire une affichage résultat

        return view;
    }
}