package com.example.apppyramide;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Fragment2 extends Fragment {

    //variables
    public int count = 0;
    TextView valCount;
    Button ButtonOK, ButtonPlus, ButtonMoins;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        //Initialisation des variables
        ButtonOK = (Button)view.findViewById(R.id.nombre_joueurs_fragment_button3);
        ButtonPlus= (Button)view.findViewById(R.id.plusbutton);
        ButtonMoins= (Button)view.findViewById(R.id.moinsbutton);
        valCount = (TextView)view.findViewById(R.id.valCount);

        //Fonction du click sur Ok
        ButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    Toast.makeText(getContext(), "Il ne peut pas y avoir 0 joueur", Toast.LENGTH_SHORT).show();
                }
                else {
                    //pour ouvrir une activité
                    Intent in = new Intent(getActivity(), Activity2.class);
                    in.putExtra("somme", "some data");
                    startActivity(in);

                    //pour ouvrir un fragment
                    /*FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new Fragment3());
                    fr.commit();*/
                }
            }
        });



        //Fonction du click sur +
        ButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count ++;
                String nbDeJoueurs = "" + count;
                valCount.setText(nbDeJoueurs);
            }
        });

        //Fonction du click sur -
        ButtonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour ne pas aller dans les négatifs
                if(count == 0){
                    count = 0;
                }
                else{
                    count --;
                    String nbDeJoueurs = "" + count;
                    valCount.setText(nbDeJoueurs);
                }
            }
        });


        return view;
    }

}