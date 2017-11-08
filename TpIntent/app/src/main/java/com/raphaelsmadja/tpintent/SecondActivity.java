package com.raphaelsmadja.tpintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String SECOND_EDIT_TEXT_VALUE = "SECOND_EDIT_TEXT_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String editTextValue = getIntent().getStringExtra(MainActivity.MAIN_EDIT_TEXT_VALUE);
        MessageOlder messageOlder = (MessageOlder) getIntent().getSerializableExtra(MainActivity.MAIN_MESSAGE_OLDER);
        Toast.makeText(this, messageOlder.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this, editTextValue, Toast.LENGTH_SHORT).show();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String editTextValue = editText.getText().toString();
        MessageOlder messageOlder = (MessageOlder) getIntent().getSerializableExtra(MainActivity.MAIN_EDIT_TEXT_VALUE);
        Intent intent = new Intent();
        intent.putExtra(SECOND_EDIT_TEXT_VALUE,editTextValue);
        setResult(RESULT_OK, intent);
        finish();
    }
}
