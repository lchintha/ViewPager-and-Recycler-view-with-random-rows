package com.example.chint.viewpagerwithrecyclerview;

import android.content.Context;

/**
 * Created by chint on 6/27/2017.
 */

public class MyData {

    private int imagesm;
    private String titlesm;
    private String descriptionsm;

    public static final MyData[] newData = {
            new MyData("Title1", "Desciption1", R.drawable.carrick),
            new MyData("Title2", "Desciption2", R.drawable.costa),
            new MyData("Title3", "Desciption3", R.drawable.degea),
            new MyData("Title4", "Desciption4", R.drawable.oscar),
            new MyData("Title5", "Desciption5", R.drawable.herera),
            new MyData("Title6", "Desciption6", R.drawable.carrick),
            new MyData("Title7", "Desciption7", R.drawable.oscar),
            new MyData("Title8", "Desciption8", R.drawable.costa),
            new MyData("Title9", "Desciption9", R.drawable.degea),
            new MyData("Title0", "Desciption0", R.drawable.carrick)
    };

    public MyData(String titlesm, String descriptionsm, int imagesm) {
        this.imagesm = imagesm;
        this.titlesm = titlesm;
        this.descriptionsm = descriptionsm;
    }

    public int getImagesm() {
        return imagesm;
    }

    public String getTitlesm() {
        return titlesm;
    }

    public String getDescriptionsm() {
        return descriptionsm;
    }

}
