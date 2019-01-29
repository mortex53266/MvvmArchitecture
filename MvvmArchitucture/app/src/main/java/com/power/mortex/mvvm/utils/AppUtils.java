package com.power.mortex.mvvm.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import static android.content.Intent.ACTION_VIEW;
import static android.net.Uri.parse;
import static com.power.mortex.mvvm.R.string.app_google_play_store_link;
import static com.power.mortex.mvvm.R.string.app_market_link;


/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public final class AppUtils {

    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(ACTION_VIEW,
                    parse(context
                            .getResources()
                            .getString(app_market_link) + appPackageName)));
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(ACTION_VIEW,
                    parse(context
                            .getResources()
                            .getString(app_google_play_store_link) + appPackageName)));
        }
    }
}
