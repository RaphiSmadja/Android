package com.example.raphael.otime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String TEST = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    UserBDD userBdd = new UserBDD(this);
    User user = new User("raphael-smadja@hotmail.fr","Raphael","Smadja");

    public void goToFormToAddTask(View view) {
        insertUserToBdd(user);
        //Boolean res = checkInBdd();
        Intent intent = new Intent(this,FormTask.class);
        startActivity(intent);
    }

    public void insertUserToBdd(User user){
        /*TODO beug insertUserToBddCheck*/
        userBdd.open();
        userBdd.insertUser(user);
        User userFromBdd = userBdd.getUserWithEmail(user.getEmail());
        //Si un email est retourné (donc si le livre à bien été ajouté à la BDD)
        if(userFromBdd != null){
            //On affiche les infos du livre dans un Toast
            Toast.makeText(this, userFromBdd.toString(), Toast.LENGTH_LONG).show();
            userBdd.selectUser();
        }
        userBdd.close();
    }

    public boolean checkInBdd(){
        User test = userBdd.getUserWithEmail("test@gemail.fr");
        Log.i(TEST,"check mail exist in bdd" + test.getEmail());
        return true;
    }
}
