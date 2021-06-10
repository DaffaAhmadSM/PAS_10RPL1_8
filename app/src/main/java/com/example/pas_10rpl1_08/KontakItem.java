package com.example.pas_10rpl1_08;

public class KontakItem {
    private String mNamaKontak;
    private String mNomorHP;
    private int mImage;

    public KontakItem(String mNamaKontak, String mNomorHP, int mImage) {
        this.mNamaKontak = mNamaKontak;
        this.mNomorHP = mNomorHP;
        this.mImage = mImage;
    }

    public String getmNamaKontak() {
        return mNamaKontak;
    }

    public void setmNamaKontak(String mNamaKontak) {
        this.mNamaKontak = mNamaKontak;
    }

    public String getmNomorHP() {
        return mNomorHP;
    }

    public void setmNomorHP(String mNomorHP) {
        this.mNomorHP = mNomorHP;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
