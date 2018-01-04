package com.example.raphael.otime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by raphi on 15/11/2017.
 */

public class UserBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "otime.db";

    private static final String TABLE_USERS = "table_users";
    private static final String COL_ID = "id_user";
    private static final int NUM_COL_ID = 0;
    private static final String COL_EMAIL = "email";
    private static final int NUM_COL_EMAIL = 1;
    private static final String COL_FIRSTNAME = "firstname";
    private static final int NUM_COL_FIRSTNAME = 2;
    private static final String COL_LASTNAME = "lastname";
    private static final int NUM_COL_LASTNAME = 3;
    private static final String COL_DATEOFCREATIONUSER = "date_of_creation";
    private static final int NUM_COL_DATEOFCREATIONUSER = 4;

    private SQLiteDatabase bdd;

    private BaseSQLite maBaseSQLite;

    public UserBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new BaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertUser(User user){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_EMAIL, user.getEmail());
        values.put(COL_FIRSTNAME, user.getFirstname());
        values.put(COL_LASTNAME, user.getLastname());
        values.put(COL_DATEOFCREATIONUSER, String.valueOf(user.getDateOfCreation()));
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_USERS, null, values);
    }

    public void selectUser(){
        Cursor c = bdd.rawQuery("SELECT * FROM table_users", null);
        Log.i("SELECT REQUEST","SELECT --- > "+c.toString());
    }

    public int updateUser(int id, User user){
        //La mise à jour d'un user dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_EMAIL, user.getEmail());
        values.put(COL_LASTNAME, user.getLastname());
        values.put(COL_FIRSTNAME, user.getFirstname());
        return bdd.update(TABLE_USERS, values, COL_ID + " = " + id, null);
    }

    public int removeUserWithID(int id){
        //Suppression d'un user de la BDD grâce à l'ID
        return bdd.delete(TABLE_USERS, COL_ID + " = " +id, null);
    }

    public User getUserWithEmail(String email){
        //Récupère dans un Cursor les valeurs correspondant à un user contenu dans la BDD (ici on sélectionne le user grâce à son email)
        Cursor c = bdd.query(TABLE_USERS, new String[] {COL_ID, COL_FIRSTNAME,COL_LASTNAME, COL_EMAIL}, COL_EMAIL + " LIKE \"" + email +"\"", null, null, null, null);
        return cursorToUser(c);
    }

    //Cette méthode permet de convertir un cursor en un user
    private User cursorToUser(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un user
        User user = new User();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        user.setId(c.getInt(NUM_COL_ID));
        user.setEmail(c.getString(NUM_COL_EMAIL));
        user.setFirstname(c.getString(NUM_COL_FIRSTNAME));
        user.setLastname(c.getString(NUM_COL_LASTNAME));
        //On ferme le cursor
        c.close();

        //On retourne le user
        return user;
    }
}
