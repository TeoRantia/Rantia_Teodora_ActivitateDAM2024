package com.example.seminar4_1098;

import android.os.Parcel;
import android.os.Parcelable;

public class Tema implements Parcelable {
    private String cerinta;
    private String rezolvare;
    private float nota;
    private boolean trimisa;
    private boolean verificata;

    public Tema(boolean verificata, boolean trimisa, float nota, String rezolvare, String cerinta) {
        this.verificata = verificata;
        this.trimisa = trimisa;
        this.nota = nota;
        this.rezolvare = rezolvare;
        this.cerinta = cerinta;
    }

    protected Tema(Parcel in) {
        cerinta = in.readString();
        rezolvare = in.readString();
        nota = in.readFloat();
        trimisa = in.readByte() != 0;
        verificata = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cerinta);
        dest.writeString(rezolvare);
        dest.writeFloat(nota);
        dest.writeByte((byte) (trimisa ? 1 : 0));
        dest.writeByte((byte) (verificata ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tema> CREATOR = new Creator<Tema>() {
        @Override
        public Tema createFromParcel(Parcel in) {
            return new Tema(in);
        }

        @Override
        public Tema[] newArray(int size) {
            return new Tema[size];
        }
    };

    public String getCerinta() {
        return cerinta;
    }

    public void setCerinta(String cerinta) {
        this.cerinta = cerinta;
    }

    public String getRezolvare() {
        return rezolvare;
    }

    public void setRezolvare(String rezolvare) {
        this.rezolvare = rezolvare;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isTrimisa() {
        return trimisa;
    }

    public void setTrimisa(boolean trimisa) {
        this.trimisa = trimisa;
    }

    public boolean isVerificata() {
        return verificata;
    }

    public void setVerificata(boolean verificata) {
        this.verificata = verificata;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tema{");
        sb.append("cerinta='").append(cerinta).append('\'');
        sb.append(", rezolvare='").append(rezolvare).append('\'');
        sb.append(", nota=").append(nota);
        sb.append(", trimisa=").append(trimisa);
        sb.append(", verificata=").append(verificata);
        sb.append('}');
        return sb.toString();
    }
}
