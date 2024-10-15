package com.example.decisionestarea;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etR;
    private EditText etA;
    private EditText etRE;
    private TextView txtResult;
    private Button btnV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etR = findViewById(R.id.etR);
        etA = findViewById(R.id.etA);
        etRE = findViewById(R.id.etRE);
        txtResult = findViewById(R.id.txtResult);
        btnV = findViewById(R.id.btnV);

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //para que se conviertan a minusculas
                String recubrimiento = etR.getText().toString().toLowerCase();
                String alimentacion = etA.getText().toString().toLowerCase();
                String reproduccion = etRE.getText().toString().toLowerCase();

                String resultado = "";

                // tipo de animal
                if (recubrimiento.equals("pelo") && alimentacion.equals("carne") && reproduccion.equals("vientre")) {
                    resultado = "Es un mamífero";
                } else if (recubrimiento.equals("plumas") && alimentacion.equals("semillas") && reproduccion.equals("huevos")) {
                    resultado = "Es un ave";
                } else if (recubrimiento.equals("escamas") && alimentacion.equals("insectos") && reproduccion.equals("huevos")) {
                    resultado = "Es un reptil";
                } else {
                    resultado = "No se pudo determinar el tipo de animal";
                }


                txtResult.setText(resultado);
            }
        });

        etR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etA.requestFocus();
            }
        });

        etA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRE.requestFocus();
            }
        });

        etRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnV.requestFocus();
            }
        });

    }

}