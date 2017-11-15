package com.raphaelsmadja.connection;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raphi on 07/11/2017.
 */

public class BaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_USERS = "table_users";
    private static final String COL_ID = "Id";
    private static final String COL_EMAIL = "Email";
    private static final String COL_PASSWORD = "Password";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_USERS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  COL_EMAIL  + " TEXT NOT NULL, "
            + COL_PASSWORD + " TEXT NOT NULL);";

    public BaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_USERS + ";");
        onCreate(db);
    }
}
