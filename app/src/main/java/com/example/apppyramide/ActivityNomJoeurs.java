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
import java.util.List;

public class ActivityNomJoeurs extends AppCompatActivity {

    /* plus utile
    ListView lv;
    private String nombreDeParticipants ="";
    private String[] users;
    AdapterList adapterList;
    public static final String MSG_Utilisateur ="";
     */

    //Variable
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


        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ActivityNomJoeurs.this,
                android.R.layout.simple_expandable_list_item_1, arrayList);
        list.setAdapter(adapter);
        //fin initialisation

        //recoit la variable entiere count du Fragment2
        Bundle bundle = getIntent().getExtras();
        int val = bundle.getInt("count");

        //afficher les differents btn en fct du nombre de joueur
        debutJeu.setVisibility(View.INVISIBLE);


        //Fonction du click sur ajouter joueur
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (utilisateur.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Il faut rentrer un nom de joueur !", Toast.LENGTH_SHORT).show();
                }/* faire une condition pour qu il ne puisse pas rentrer un nom deja selectionne
                else if (){

                }*/ else {
                    //on recupere le nom entré par le joueur
                    String nom = utilisateur.getText().toString();
                    arrayList.add("Nom joueur " + (arrayList.size() + 1) + " : " + nom);
                    adapter.notifyDataSetChanged();
                    utilisateur.setText(""); //pr clear le TextView

                    //afficher les differents btn en fct du nombre de joueur
                    //on se place ici pour obtenir la taille de la liste incrémenté à chaque fois
                    if ((arrayList.size()) >= val ){
                        //Toast.makeText(getApplicationContext(), ""+ arrayList.size(), Toast.LENGTH_SHORT).show();
                        btnAdd.setVisibility(View.INVISIBLE);
                        debutJeu.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        //Fct du btn lancer partie
        //ouvrir une activité d'une activité
        debutJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrayList.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Vous ne pouvez pas lancer la partie sans rentrer le nom des participants", Toast.LENGTH_SHORT).show();
                } else {
                    //transmettre la liste de l'activité à un fragment
                    //regarder cmt faire
                    //Bundle bundle1 = new Bundle();
                   // bundle1.get("list",arrayList ) ;
                    Intent intent = new Intent(ActivityNomJoeurs.this, activity_carteRN.class);
                    //intent.putExtra("list", arrayList);
                    //intent.putParcelableArrayListExtra("listNom", ArrayList<? extends Parcelable > arrayList);
                    startActivity(intent);
                }
            }
        });
    }
}
