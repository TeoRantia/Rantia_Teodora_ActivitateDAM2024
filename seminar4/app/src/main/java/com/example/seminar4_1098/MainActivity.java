package com.example.seminar4_1098;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Tema> teme = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        teme = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.adaugaTema);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), TemaActivitate.class);
                startActivityForResult(it, 123);
            }
        });

        Button listaTemeBtn = findViewById(R.id.butonListaTeme);
        listaTemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), TemaActivitate.class);
                it.putParcelableArrayListExtra("teme", (ArrayList<? extends Parcelable>) teme);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123) {
            if(resultCode == RESULT_OK) {
                Tema tema = data.getParcelableExtra("tema");
                teme.add(tema);
                /*TextView tv = findViewById(R.id.textView);
                tv.setText(tema.toString());*/
            }
        }
    }
}