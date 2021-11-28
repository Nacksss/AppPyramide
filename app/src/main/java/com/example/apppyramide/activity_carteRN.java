package com.example.apppyramide;

import static com.example.apppyramide.R.id.fragment_containerRN;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import java.util.ArrayList;


public class activity_carteRN extends AppCompatActivity {

    //declaration variable delay
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartern);


        //ouverture du 1fragment Rouge ou Noir dès l'ouverture de cette activité( avec le btn lancer partie)
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(fragment_containerRN, new Fragment_tempoRN());
        fragmentTransaction.commit();

        // Ouvre le second fragment apres 5000 ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(fragment_containerRN, new Fragment_RN());
                fragmentTransaction.commit();
            }
        },2000);


    }

}