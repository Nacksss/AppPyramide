package com.example.apppyramide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

//Activité qui donne la possibilité au joueurs de rentrer leur pseudo

public class ActivityNomJoeurs extends AppCompatActivity {

    //Déclaration variable
    ListView list;
    Button btnAdd;
    Button debutJeu;
    EditText utilisateur;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomjoueurs);

        //Initialisation des variables
            btnAdd = (Button) findViewById(R.id.btnAdd);
            debutJeu = (Button) findViewById(R.id.debutJeu);
            list = (ListView) findViewById(R.id.list);
            utilisateur = (EditText) findViewById(R.id.utilisateur);
        //fin initialisation

        //Initialisation de l'arrayList qui va nous servir à lister les noms des joueurs
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ActivityNomJoeurs.this,
                android.R.layout.simple_expandable_list_item_1, arrayList);
        list.setAdapter(adapter);


        //recoit la variable entiere count du Fragment_CbDeJoueurs qui correspond au nombre de joueur
        int val = getIntent().getIntExtra("count",0);
        //recoit la liste créée pour le joueur
        ArrayList<String> a = getIntent().getStringArrayListExtra("l1");


        //afficher les differents btn en fct du nombre de joueur
        debutJeu.setVisibility(View.INVISIBLE);


        //Fonction du click sur ajouter joueur
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si l'utilisateur ne rentre pas de nom
                if (utilisateur.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Il faut rentrer un nom de joueur !", Toast.LENGTH_SHORT).show();
                }
                //Si non
                else{
                    //on recupere le nom entré par le joueur
                    String nom = utilisateur.getText().toString();
                    arrayList.add("Joueur " + (arrayList.size() + 1) + " : " + nom);
                    adapter.notifyDataSetChanged();
                    utilisateur.setText(""); //pr clear le TextView

                    //afficher les differents btn en fct du nombre de joueur
                    //on se place ici pour obtenir la taille de la liste incrémenté à chaque fois
                    if ((arrayList.size()) >= val ){
                        btnAdd.setVisibility(View.INVISIBLE);
                        debutJeu.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        //Fct du btn lancer partie
        debutJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Création d'un intent pour transmettre la liste de l'activité et le nombre de
                // joueur à "activity_carteRN"
                Intent intent = new Intent(ActivityNomJoeurs.this, activity_carteRN.class);
                intent.putExtra("listNom", arrayList);
                intent.putExtra("count", val);
                //transmission des liste pour chaque joueurs
                intent.putStringArrayListExtra("l1",a);
                startActivity(intent);
            }
        });
    }
}
