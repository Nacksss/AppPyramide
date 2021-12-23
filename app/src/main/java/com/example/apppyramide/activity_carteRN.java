package com.example.apppyramide;

import static com.example.apppyramide.R.id.fragment_containerRN;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;


public class activity_carteRN extends AppCompatActivity {

    //declaration variable delay
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartern);

        //recoit la liste des noms des joueurs de l'activité Nom joueurs
        ArrayList<String> s1 = getIntent().getStringArrayListExtra("listNom");
        //Recoit le nb de joueurs
        int val = getIntent().getIntExtra("count",0);
        //transmission de la liste des futures cartes du joueurs
        ArrayList<String> a = getIntent().getStringArrayListExtra("l1");


        //ouverture du fragment Rouge ou Noir dès l'ouverture de cette activité
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(fragment_containerRN, new Fragment_tempoRN());
        fragmentTransaction.commit();

        // Ouvre le second fragment (choix rouge ou noir) apres 2000 ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment_RN fragment_rn = new Fragment_RN();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                //Création d'un Bundle
                // et ajout des arguments qui sont à transettre
                Bundle bundleNom = new Bundle();
                bundleNom.putStringArrayList("listNom", s1);
                bundleNom.putInt("count", val);
                bundleNom.putStringArrayList("l1",a);

                fragment_rn.setArguments(bundleNom);
                fragmentTransaction.replace(fragment_containerRN, fragment_rn);
                fragmentTransaction.commit();
            }
        },2000);
    }
}