package com.raphaelsmadja.connection;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    UserBDD userBdd = new UserBDD(this);
    User user;

    public void connectUser(View view){
        EditText emailText = (EditText) findViewById(R.id.emailText);
        String editEmailValue = emailText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        String editPasswordValue = passwordText.getText().toString();
        Log.i("EMAILCO"," email co -> "+editEmailValue);
        Log.i("PASSWORDCO"," password co -> "+editPasswordValue);
        /** TEST **/
        isValidEmail(editEmailValue);
        //isValidPassword(editEmailValue);
    }

    public void insertUser(View view){
        EditText emailText = (EditText) findViewById(R.id.emailText);
        String editEmailValue = emailText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        String editPasswordValue = passwordText.getText().toString();
        Log.i("EMAIL_INSERT"," email -> "+editEmailValue);
        Log.i("PASSWORD_INSERT"," password -> "+editPasswordValue);
        /** TEST **/
        //isValidPassword(editPasswordValue);
        if(isValidEmail(editEmailValue)){
            user = new User(editEmailValue,editPasswordValue);
            // création d'une instance class UserBDD
            userBdd.open();
            userBdd.insertUser(user);
            //Pour vérifier que l'on a bien créé notre livre dans la BDD
            //on extrait le livre de la BDD grâce au titre du livre que l'on a créé précédemment
            User userFromBdd = userBdd.getUserWithEmail(user.getEmail());
            //Si un email est retourné (donc si le livre à bien été ajouté à la BDD)
            if(userFromBdd != null){
                //On affiche les infos du livre dans un Toast
                Toast.makeText(this, userFromBdd.toString(), Toast.LENGTH_LONG).show();
                userBdd.selectUser();
            }

        } else {
            Log.i("ERROR","erreur insert ");
        }
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean isValidEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
        }
    }

    public void saveDatabase(View view){
        SQLiteDatabase db;
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(this, DatabaseHelper.DB_NAME, DatabaseHelper.DB_VERSION);
            db = databaseHelper.getWritableDatabase();
        } catch (SQLiteException e){
            db = openOrCreateDatabase(DatabaseHelper.DB_NAME, MODE_APPEND,null);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        userBdd.close();
    }
}
