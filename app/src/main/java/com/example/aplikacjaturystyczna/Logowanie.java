package com.example.aplikacjaturystyczna;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.ValueEventListener;


public class Logowanie extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    boolean userCheck;
    int hashFromDB;
    String email;

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
                rootNode = FirebaseDatabase.getInstance();
                reference =rootNode.getReference("users");

                EditText textbox = (EditText)findViewById(R.id.editTextTextEmailAddress);
                email = textbox.getText().toString();
                EditText password_textbox = (EditText)findViewById(R.id.editTextTextPassword);
                String password = password_textbox.getText().toString();

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String hashDB = dataSnapshot.child(email).child("pwdHashCode").getValue().toString();
                        hashFromDB = Integer.parseInt(hashDB);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && userCheck) {
                   if (password.hashCode() == hashFromDB) {
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
