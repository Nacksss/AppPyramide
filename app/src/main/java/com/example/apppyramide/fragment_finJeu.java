package com.example.apppyramide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.w3c.dom.Text;


public class fragment_finJeu extends Fragment {

    TextView fin;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fin_jeu, container, false);

        fin = view.findViewById(R.id.fin);

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.anim);
        fin.startAnimation(animation);

        return view;
    }
}