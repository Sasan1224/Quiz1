package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainBtn;
    private TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn = findViewById(R.id.mainBtn);
        userText = findViewById(R.id.userText);

        mainBtn.setOnClickListener(this);

    }

    //Para que se guarden los datos
    protected void onResume() {
        super.onResume();
        sharedP();
    }

    public void onClick(View v) {
        Intent a = new Intent(this, Registro.class);
        startActivity(a);
    }

    public void sharedP(){
        String locker = getSharedPreferences("locker", MODE_PRIVATE).getString("puntajeNE", "NO_DATA");
        userText.setText(locker);

    }
}