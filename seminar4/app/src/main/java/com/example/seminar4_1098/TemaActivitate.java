package com.example.seminar4_1098;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TemaActivitate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema_activitate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.butonTema);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etCerinta = findViewById(R.id.idCerinta);
                String cerinta = etCerinta.getText().toString();
                EditText etRezolvare = findViewById(R.id.idRezolvare);
                String rezolvare = etRezolvare.getText().toString();
                Boolean trimisa = ((CheckBox)findViewById(R.id.checkboxTrimitere)).isChecked();
                Boolean verificata = ((CheckBox)findViewById(R.id.checkboxVerificare)).isChecked();
                RatingBar rb = findViewById(R.id.ratingBarNota);
                float nota = rb.getNumStars();

                Tema tema = new Tema(verificata, trimisa, nota, rezolvare, cerinta);

                Intent it = new Intent();
                it.putExtra("tema", tema);
                setResult(RESULT_OK, it);
                finish();
                //Toast.makeText(TemaActivitate.this, tema.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}