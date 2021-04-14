package com.example.aplikacjaturystyczna;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Rejestracja extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    EditText textbox_login = (EditText) findViewById(R.id.editTextTextEmailAddress);
    EditText password_textbox = (EditText) findViewById(R.id.editTextTextPassword2);
    EditText password_textbox_second = (EditText) findViewById(R.id.editTextTextPassword3);
    boolean userExists;

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
                rootNode = FirebaseDatabase.getInstance();
                reference =rootNode.getReference("users");



                String email = textbox_login.getText().toString();
                String password = password_textbox.getText().toString();
                String password_repeat = password_textbox_second.getText().toString();
                UserClass user = new UserClass(email, password.hashCode());

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String email_check = textbox_login.getText().toString();
                      if(dataSnapshot.hasChild(email_check))
                          userExists = true;
                      else userExists = false;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (userExists)
                        Toast.makeText(this, R.string.email_in_use_toast, Toast.LENGTH_SHORT).show();
                    else {
                        if (password.equals(password_repeat)) {
                            reference.child(email).setValue(user);
                            startActivity(new Intent(this, MainActivity.class));
                        } else
                            Toast.makeText(this, R.string.passwords_not_same_toast, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(this, R.string.wrong_email_format, Toast.LENGTH_SHORT).show();
                    break;

        }
    }
}

