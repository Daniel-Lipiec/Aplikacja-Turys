package com.example.aplikacjaturystyczna;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Rejestracja extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);


        Button button1 = findViewById(R.id.button16);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button16:

                EditText textbox_login = (EditText) findViewById(R.id.editTextTextEmailAddress);
                String email = textbox_login.getText().toString();
                EditText password_textbox = (EditText) findViewById(R.id.editTextTextPassword);
                String password = password_textbox.getText().toString();
                EditText password_textbox_second = (EditText) findViewById(R.id.editTextTextPassword);
                String password_repeat = password_textbox_second.getText().toString();

                if (/* czy email istnieje w bazie danych */)
                    Toast.makeText(this, R.string.email_in_use_toast, Toast.LENGTH_SHORT).show();
                else
                {
                    if(password == password_repeat)
                    {
                        //dodanie konta do bazy danych
                        startActivity(new Intent(this, MainActivity.class));
                    }
                    else
                        Toast.makeText(this, R.string.passwords_not_same_toast, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

