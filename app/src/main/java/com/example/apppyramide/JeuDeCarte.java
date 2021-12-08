package com.example.apppyramide;

import java.util.HashMap;

public class JeuDeCarte {

    private HashMap<Integer, String> monJeu;

    public JeuDeCarte() {
        //instancier Hashmap
        HashMap jeu = new HashMap<Integer, String>();

        //instancier carte
        Carte maCarte = new Carte("", "");

        // instancie le jeu de carte
        for(int i =0; i < Carte.getTypesCarte().length; i++) {
            for (int j=0 ; j < Carte.getValeursCarte().length ; j++) {
                int cle = 1;
                jeu.put(cle, "" + Carte.typesCarte[i] + " " + Carte.valeursCarte[j]);
                cle ++;
            }
        }

    }

    public String getValeurH(Integer n) {
        return this.getValeurH(n);
    }

    public void remove(Integer n) {
        this.remove(n);
    }


    public JeuDeCarte(HashMap j) {
        monJeu = j;
    }

    public HashMap getMonJeu() {
        return monJeu;
    }


    public static void main(String[] args) {
        //instancier Hashmap
       HashMap jeu = new HashMap<>();

       //instancier carte
        Carte maCarte = new Carte("", "");

        // instancie le jeu de carte
       for(int i =0; i < Carte.getTypesCarte().length; i++) {
            for (int j=0 ; j < Carte.getValeursCarte().length ; j++) {
                int cle = 1;
               jeu.put(cle, "" + Carte.typesCarte[i] + " " + Carte.valeursCarte[j]);
               cle ++;
            }
       }


    }
}
