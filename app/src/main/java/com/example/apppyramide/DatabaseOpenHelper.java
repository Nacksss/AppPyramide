package com.example.apppyramide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String Liste = "db.menuGenerator.db";

    public DatabaseOpenHelper(Context context) {
        super(context, Liste, null, 1);
    }
}
