package com.example.apppyramide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class Activity2 extends AppCompatActivity{

    /* ////pluq utiles
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
        setContentView(R.layout.activity_2);

        //Initialisation des variables
        btnAdd = (Button)findViewById(R.id.btnAdd);
        debutJeu = (Button)findViewById(R.id.debutJeu);
        list = (ListView)findViewById(R.id.list);
        utilisateur = (EditText)findViewById(R.id.utilisateur);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(Activity2.this,
                android.R.layout.simple_expandable_list_item_1,arrayList);
        list.setAdapter(adapter);

        //fin initialisation


        //Fonction du click sur ajouter joueur
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(utilisateur.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Il faut rentrer un nom de joueur !", Toast.LENGTH_SHORT).show();
                }else {
                        //on récup le nom entré par le joueur
                        String nom = utilisateur.getText().toString();

                        arrayList.add("Nom joueur : " + nom);
                        adapter.notifyDataSetChanged();

                        //on l'affiche dans la list
                        //utilisateur.setText("Nom joueur : "+nom);
                   }
                }
            });


            //Fct du btn lancer partie
            //ouvrir une activité d'une activité
        debutJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, activity_RN.class);
                startActivity(intent);
            }
        });


    }
}





///chercher comment transmettre la variables d'unfragment a une activité
        /*
        //afficher les différents btn en fct du nombre de joueur
        int i=0;
        while ( i<count){
            btnAdd.setVisibility(View.VISIBLE);
            debutJeu.setVisibility(View.INVISIBLE);
            i++;
        }
            btnAdd.setVisibility(View.VISIBLE);
            debutJeu.setVisibility(View.INVISIBLE);


        int i=0;
        for ( i; i<count; i++){
            btnAdd.setVisibility(View.VISIBLE);
            debutjeu.setVisibility(View.INVISIBLE);
        }else {
            btnAdd.setVisibility(View.VISIBLE);
            debutjeu.setVisibility(View.INVISIBLE);
        }
        */


/*   /////////////Plus d'actualité
        //ouverture de cette activity avec le bouton ok de frag 2
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            if(bundle.getString("sommee") !=null){
                Toast.makeText(getApplicationContext(), "data"+ bundle.getString("sommee"),
                        Toast.LENGTH_SHORT).show();
            }
        }
*/

        /*   /////////////Plus d'actualité
        //on ouvre la base de données
        final DatabaseAcces db = DatabaseAcces.getInstance(getApplicationContext());
        db.open();

        //si on veut voir le nombre de participants pour l utilisateur Nico
        nombreDeParticipants = db.getNombreDeParticipants("DD");

        // on affiche le nombre de participants dans activity
        TextView textView_nombreDeparticipants = (TextView) findViewById(R.id.text_nbdeparticipants);
        textView_nombreDeparticipants.setText(nombreDeParticipants);

        db.close();
        */

/*  /////////////Plus d'actualité
        //Récupération de tous les users dans la base de donnée
        //users = db.getUsers();  a utiliser mais manque db
        lv = findViewById(R.id.list);

        adapterList =new AdapterList(this, users);
        lv.setAdapter(adapterList);
        /*a determiner
        lv.setOnItemClickListener(
            Intent intent = new intent (Activity2.this, Activity2.class );
            intent.putEtra(Activity2.MSG_Utilisateur, users[position]);
        */


/*  /////////////Plus d'actualité
    public void sendCreated(View view){
        String utilisateur = ((EditText) findViewById(R.id.utilisateur)).getText().toString();

        if(utilisateur.length()!=0) {
            final DatabaseAcces db = DatabaseAcces.getInstance(getApplicationContext());
            db.open();

            //on vérifie si l'utilisateur n'existe pas deja
            boolean exist = db.existUser(utilisateur);
            //si l'utilisateur n'existe pas on le créer
            if (!exist) {
                db.addUser(utilisateur);
                //String participants = db.getNombreDeParticipants(utilisateur);
            } else {
                Toast.makeText(this, "Le joueur" + utilisateur + " existe déjà", Toast.LENGTH_SHORT).show();
            }

            db.close();
        }
        else{
            Toast.makeText(this, "Vous devez donner un nom au joeur", Toast.LENGTH_SHORT).show();
        }
    }
*/
