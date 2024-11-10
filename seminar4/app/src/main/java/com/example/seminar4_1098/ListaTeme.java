package com.example.seminar4_1098;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class ListaTeme extends AppCompatActivity {
    private List<Tema> teme = null;
    private int idModificat = 0;
    private TemaAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_teme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent it = getIntent();
        List<Tema> teme = it.getParcelableArrayListExtra("teme");

        ListView lv = findViewById(R.id.temeLV);
        //ArrayAdapter<Tema> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, teme);
        //lv.setAdapter(adapter);
        adapter = new TemaAdapter(teme, getApplicationContext(), R.layout.row_layout);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intentModifica = new Intent(getApplicationContext(), TemaActivitate.class);
                intentModifica.putExtra("tema", teme.get(i));
                idModificat = i;
                startActivityForResult(intentModifica, 209);

                Toast.makeText(getApplicationContext(), teme.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                teme.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 209){
                teme.set(idModificat, data.getParcelableExtra("tema"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}