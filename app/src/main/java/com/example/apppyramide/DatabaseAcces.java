package com.example.apppyramide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAcces {
    public static final String Joueur_Table_Nom ="Utilisateur";
    public static final String Joueur_Nom ="Nom";
    public static final String Joueur_Participants ="NombreDeParticipants";

    //Base de donnée
    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAcces instance;
    Cursor c = null;


    private DatabaseAcces(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAcces getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAcces(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

////////////////////////////
    /////////////Requete vers la base de données

    //retourne le nombre de participant pour un utilisateur de l'application
    public String getNombreDeParticipants(String utiliateur){
        c = db.rawQuery("select NombreDeParticipants from Utilisateur where nom = ?" , new String[]{});

        if(c.getCount()!=1){
            return "erreur";
        }

        c.moveToFirst();
        return c.getString(0);
    }



    //verifie qu'un utilisateur existe ou non
    public boolean existUser(String utilsateur){
        c = db.rawQuery("select " + Joueur_Nom+"from"+ Joueur_Table_Nom+"where"+ Joueur_Nom+"=?", new String[]{});
        return c.getCount()==1;
    }

    //ajout d'un nouveau joeur
    public void addUser(String utilisateur){
        ContentValues value = new ContentValues();
        value.put(Joueur_Nom, utilisateur);
        value.put(Joueur_Participants, 0);
        long l = db.insert(Joueur_Table_Nom, null, value);
    }

   //retourne une liste avec tous les noms des joeurs
    public String[] getUsers(){
        c = db.rawQuery("select " + Joueur_Nom+"from"+ Joueur_Table_Nom, new String[]{});
        String[] users = new String[c.getCount()];
        int i = 0;
        while(c.moveToNext()){
            users[i]=c.getString(0);
            i++;
        }
        return users;
    }

}
