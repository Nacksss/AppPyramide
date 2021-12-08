package com.example.apppyramide;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_CbDeJoueurs extends Fragment {

    //variables
    public int count;
    TextView valCount;
    Button ButtonOK, ButtonPlus, ButtonMoins;

    public String tab0[], tab1[],tab2[],tab3[],tab4[],tab5[],tab6[];


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbjoueurs, container, false);

        //Initialisation des variables
        ButtonOK = (Button)view.findViewById(R.id.nombre_joueurs_fragment_button3);
        ButtonPlus= (Button)view.findViewById(R.id.plusbutton);
        ButtonMoins= (Button)view.findViewById(R.id.moinsbutton);
        valCount = (TextView)view.findViewById(R.id.valCount);

        // fonction du click sur +
        ButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 6){
                    count = 6;
                }
                else{
                    count ++;
                    String nbDeJoueurs = "" + count;
                    valCount.setText(nbDeJoueurs);
                }

            }
        });

        // Fonction du click sur -
        ButtonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour ne pas aller dans les negatifs
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



        //Fonction du click sur Ok
        ButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                    Toast.makeText(getContext(), "Il ne peut pas y avoir 0 joueur", Toast.LENGTH_SHORT).show();
                }
                else {
                    //pour ouvrir une activité et transmettre une val
                    Intent in = new Intent(getActivity(), ActivityNomJoeurs.class);
                    in.putExtra("count",count);
                    startActivity(in);
                }
            }
        });

        return view;
    }

}