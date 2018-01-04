package com.example.raphael.otime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raphi on 07/11/2017.
 */

public class BaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_USERS = "table_users";
    private static final String COL_ID = "id_user";
    private static final String COL_EMAIL = "email";
    private static final String COL_FIRSTNAME = "firstname";
    private static final String COL_LASTNAME = "lastname";
    private static final String COL_DATEOFCREATIONUSER = "date_of_creation";

    private static final String TABLE_TASKS = "table_tasks";
    private static final String COL_ID_TASK = "id_task";
    private static final String COL_ID_USER = "id_user";
    private static final String COL_TITLE = "title";
    private static final String COL_DEADLINE = "deadline";
    private static final String COL_DATEOFCREATIONTASK = "date_of_creation";


    private static final String CREATE_BDD_USERS = "CREATE TABLE " + TABLE_USERS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  COL_EMAIL  + " TEXT NOT NULL, "
            + COL_FIRSTNAME + " TEXT NOT NULL, " + COL_LASTNAME + " TEXT NOT NULL, "
            + COL_DATEOFCREATIONUSER + " DATE NOT NULL) ;";

    private static final String CREATE_BDD_TASK = "CREATE TABLE " + TABLE_TASKS + " ("
            + COL_ID_TASK + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ID_USER + " INTEGER NOT NULL, "
            + COL_TITLE  + " TEXT NOT NULL, " + COL_DEADLINE + " DATE NOT NULL, "
            + COL_DATEOFCREATIONTASK + " DATE NOT NULL) ;";


    public BaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD_USERS);
        db.execSQL(CREATE_BDD_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_USERS + ";");
        db.execSQL("DROP TABLE " + TABLE_TASKS + ";");
        onCreate(db);
    }
}
