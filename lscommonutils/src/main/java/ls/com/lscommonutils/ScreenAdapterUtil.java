package ls.com.lscommonutils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * Created by shulin on 2018/7/4.
 */

public class ScreenAdapterUtil {
    private static float sNonCompatDensity;
    private static float sNonCompatScaleDensity;

    public static void setCustomDensity(Activity activity, final Application application) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        if (sNonCompatDensity == 0) {
            sNonCompatDensity = appDisplayMetrics.density;
            sNonCompatScaleDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    sNonCompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                }

                @Override
                public void onLowMemory() {

                }
            });

        }

//屏幕宽 的像素除以360 获得Density的值
        final float targetDensity = appDisplayMetrics.widthPixels / 360;
        final int targetDensityDpi = (int) (targetDensity * 160);
        final float targetScaledDensity = (int) (targetDensity * (sNonCompatScaleDensity / sNonCompatDensity));

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;

    }

}
