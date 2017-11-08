package com.raphaelsmadja.tpintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String MAIN_EDIT_TEXT_VALUE = "MAIN_EDIT_TEXT_VALUE";
    public static final int REQUEST_CODE_FOR_SECOND = 2;
    public static final String MAIN_MESSAGE_OLDER = "MAIN_MESSAGE_OLDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String editTextValue = editText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MAIN_EDIT_TEXT_VALUE,editTextValue);
        intent.putExtra(MAIN_MESSAGE_OLDER, new MessageOlder(editTextValue));
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_FOR_SECOND);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (REQUEST_CODE_FOR_SECOND == requestCode && RESULT_OK == resultCode) {
            String text = data.getStringExtra(SecondActivity.SECOND_EDIT_TEXT_VALUE);
            Toast.makeText(this,"M => "+ text,Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
