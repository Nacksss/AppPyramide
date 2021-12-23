package com.example.apppyramide;

import java.util.HashMap;

public class JeuDeCarte {

    private HashMap<Integer, Carte> monJeu;

    public JeuDeCarte() {
        //instancier Hashmap
        monJeu = new HashMap<Integer, Carte>();
        int cle = 1;
        // instancie le jeu de carte
        for(int i =0; i < Carte.getTypesCarte().length; i++) {
            for (int j=0 ; j < Carte.getValeursCarte().length ; j++) {
                Carte ij = new Carte(Carte.typesCarte[i] , Carte.valeursCarte[j]);
                monJeu.put(cle, ij);
                cle ++;
            }
        }
    }

    public Carte getCarte(Integer n) {
        Carte maCarte = monJeu.get(n);
        return maCarte;
    }

    public void removeCarte(Integer n) {
        Carte maCarte = monJeu.remove(n);
    }
}
