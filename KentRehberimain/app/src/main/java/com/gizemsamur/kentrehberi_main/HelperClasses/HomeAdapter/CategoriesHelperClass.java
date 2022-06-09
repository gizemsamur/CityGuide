package com.gizemsamur.kentrehberi_main.HelperClasses.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    GradientDrawable image;
    int title;
    String description;

    public CategoriesHelperClass(GradientDrawable image, int title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public GradientDrawable getImage() {
        return image;
    }

    public int getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

