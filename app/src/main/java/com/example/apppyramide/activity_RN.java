package com.example.apppyramide;

import static com.example.apppyramide.R.id.fragment_container;
import static com.example.apppyramide.R.id.fragment_containerRN;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;

public class activity_RN extends AppCompatActivity {

    //déclaration variable delay
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rn);


        //ouverture du 1fragment Rouge ou Noir dès l'ouverture de cetta activté (avec le btn lancer partie)
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(fragment_containerRN, new Fragment_RN1());
        fragmentTransaction.commit();

        //ouvre le second fragment après 5000 ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(fragment_containerRN, new Fragment_RN2());
                fragmentTransaction.commit();
            }
        },5000);


    }
}