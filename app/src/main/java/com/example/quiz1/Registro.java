package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre_estudiante, id;
    private Button registerBtn;
     String name, code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registerBtn = findViewById(R.id.regBtn);
        nombre_estudiante = findViewById(R.id.nombre);
        id = findViewById(R.id.id);

        registerBtn.setOnClickListener(this);

    }

    public void onClick(View view) {

        //los toma y los vuelve String
        name = nombre_estudiante.getText().toString();
        code = id.getText().toString();


        Intent r = new Intent(this, Act_prep.class);
        r.putExtra("name", name);
        r.putExtra("ident", code);
        startActivity(r);
        finish();

        }


    }


