package com.shopping.app.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class Util {

    // This function based on file name return image Identifier id
    public static int nameToDrawable(String name, Context context) {
        String resourceName = name.substring(0, name.lastIndexOf('.')).toLowerCase().replaceAll("[^a-z0-9_]", "_");
        return context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
    }
}
