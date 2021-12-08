package com.example.apppyramide;

public class Carte {
    static String[] typesCarte = {"Coeur", "Carreau", "Trèfle", "Pique"};
    static String[] valeursCarte = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};

        private String myType;
        private String myValue;

    public Carte(String t, String vCarte) {
        myType = t;
        myValue = vCarte;
    }

    public String getType() {
        return this.getType();
    }

    public String getValue() {
        return this.getValue();
    }

    public static String[] getTypesCarte() {
        return typesCarte;
    }

    public static String[] getValeursCarte() {
        return valeursCarte;
    }

    public static void main (String[] args) {

    }
}
