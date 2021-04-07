package com.example.aplikacjaturystyczna;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Logowanie extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        Button button1 = findViewById(R.id.button15);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button15:

                EditText textbox = (EditText)findViewById(R.id.editTextTextEmailAddress);
                String email = textbox.getText().toString();
                EditText password_textbox = (EditText)findViewById(R.id.editTextTextPassword);
                String password = password_textbox.getText().toString();

                if(/* email istnieje w bazie danych */) {
                    if (password.hashCode() == /* pobrany hash hasła z bazy danych */) {
                        startActivity(new Intent(this, main_menu.class));
                    } else
                        Toast.makeText(this, R.string.password_incorrect_toast, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, R.string.email_incorrect_toast, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
