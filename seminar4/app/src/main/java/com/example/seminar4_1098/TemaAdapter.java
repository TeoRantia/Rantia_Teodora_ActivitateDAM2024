package com.example.seminar4_1098;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class TemaAdapter extends BaseAdapter {
    private List<Tema> teme = null;
    private Context ctx;
    private int resursaLayout;

    public TemaAdapter(List<Tema> teme, Context ctx, int resursaLayout) {
        this.teme = teme;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return teme.size();
    }

    @Override
    public Object getItem(int i) {
        return teme.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, viewGroup, false);

        TextView cerintaTV = v.findViewById(R.id.cerintaTV);
        TextView rezolvareTV = v.findViewById(R.id.rezolvareTV);
        CheckBox trimisaCB = v.findViewById(R.id.trimisaCB);
        CheckBox verificataCB = v.findViewById(R.id.verificataCB);
        RatingBar notaRB = v.findViewById(R.id.notaRB);

        Tema tema = (Tema)getItem(i);

        cerintaTV.setText(tema.getCerinta());
        rezolvareTV.setText(tema.getRezolvare());
        trimisaCB.setChecked(tema.isTrimisa());
        verificataCB.setChecked(tema.isVerificata());
        notaRB.setNumStars((int)tema.getNota());

        return v;
    }


}
