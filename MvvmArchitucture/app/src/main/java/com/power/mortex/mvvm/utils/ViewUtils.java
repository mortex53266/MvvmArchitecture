package com.power.mortex.mvvm.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import static android.content.res.Resources.getSystem;
import static android.graphics.PorterDuff.Mode.SRC_ATOP;
import static android.support.v4.content.ContextCompat.getColor;
import static com.power.mortex.mvvm.R.color.deep_gray;
import static java.lang.Math.round;


/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public final class ViewUtils {

    private ViewUtils() {
        // This class is not publicly instantiable
    }

    public static void changeIconDrawableToGray(Context context, Drawable drawable) {
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(getColor(context, deep_gray), SRC_ATOP);
        }
    }

    public static int dpToPx(float dp) {
        float density = getSystem().getDisplayMetrics().density;
        return round(dp * density);
    }

    public static float pxToDp(float px) {
        float densityDpi = getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }
}
