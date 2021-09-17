package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Act_prep extends AppCompatActivity implements View.OnClickListener {

    private CheckBox nE1, nE2, nE5;
    private Button nextBtn;
    int puntos;
    String name, identify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_n_e);


        nE1 = findViewById(R.id.nE1);
        nE2 = findViewById(R.id.nE2);
        nE5 = findViewById(R.id.nE5);
        nextBtn = findViewById(R.id.contiBtn);


        nextBtn.setOnClickListener(this);

        nE1.setOnClickListener(this);
        nE2.setOnClickListener(this);
        nE5.setOnClickListener(this);

        puntos = 0;


        name = getIntent().getExtras().getString("name");
        identify = getIntent().getExtras().getString("ident");

        //Este es para que esté invisible cuando apenas entra la persona a esa pantalla
        if (nE1.isChecked() == false && nE2.isChecked() == false &&  nE5.isChecked() == false) {
            nextBtn.setVisibility(View.INVISIBLE);
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.contiBtn:

                Intent n = new Intent(this, Auto_ev.class);
                n.putExtra("name",name);
                n.putExtra("ident", identify);
                n.putExtra("puntos", puntos);
                startActivity(n);
                finish();
                break;

            case R.id.nE1:
                nE1.isChecked();

                //los puntos que vale cada opción, si no lo presiona se quitan los puntos
                if(nE1.isChecked()){
                    puntos+=1;
                }else{
                    puntos-=1;
                }
                //Se pone a -ninguna de las anteriores- inhabilitada
                nE5.setChecked(false);
                break;

            case R.id.nE2:
                nE2.isChecked();
                if (nE2.isChecked()) {
                    puntos += 3; //Es igual a decir pnt = pnt+3
                }else{
                    puntos+=3;
                }
                nE5.setChecked(false);
                break;


             //Este es 0 porque es Ninguno de los anteriores
            case R.id.nE5:
                nE5.isChecked();
                if (nE5.isChecked()) {
                    puntos = 0;
                }
                nE1.setChecked(false);
                nE2.setChecked(false);

                break;

        }
        //Para que aparezca si presionaron una opción
        if (nE1.isChecked() || nE2.isChecked() ||  nE5.isChecked()) {
            nextBtn.setVisibility(View.VISIBLE);
        } else {
            nextBtn.setVisibility(View.INVISIBLE);
        }
    }
}