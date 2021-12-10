package com.example.apppyramide;

import static com.example.apppyramide.R.id.fragment_containerRN;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class activity_carteRN extends AppCompatActivity {

    //declaration variable delay
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartern);

        //recoit l'arraylist des noms des joueurs de l'activité Nom joueurs
        ArrayList<String> s1 = getIntent().getStringArrayListExtra("listNom");
        int val = getIntent().getIntExtra("count",0);
        //Toast.makeText(getApplicationContext(), ""+ s1, Toast.LENGTH_SHORT).show();

        //ouverture du 1fragment Rouge ou Noir dès l'ouverture de cette activité( avec le btn lancer partie)
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(fragment_containerRN, new Fragment_tempoRN());
        fragmentTransaction.commit();

        // Ouvre le second fragment apres 5000 ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment_RN fragment_rn = new Fragment_RN();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                //envoyer l'arraylist au fragment RN
                Bundle bundleNom = new Bundle();
                bundleNom.putStringArrayList("listNom", s1);
                bundleNom.putInt("count", val);
                fragment_rn.setArguments(bundleNom);
                fragmentTransaction.replace(fragment_containerRN, fragment_rn);
                fragmentTransaction.commit();
            }
        },2000);
    }

}