package com.example.aplikacjaturystyczna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button17);
        Button button2 = findViewById(R.id.button18);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.button17:
                    startActivity(new Intent(this, Logowanie.class));
                    break;
            case R.id.button18:
                startActivity(new Intent(this, Registration.class));
                break;
        }
    }
}