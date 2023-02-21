package app.revanced.integrations.patches.misc;

import static app.revanced.integrations.utils.ReVancedUtils.context;
import static app.revanced.integrations.utils.SharedPrefHelper.SharedPrefNames.REVANCED;

import app.revanced.integrations.utils.LogHelper;
import app.revanced.integrations.utils.SharedPrefHelper;

public class VersionOverridePatch {

    /*
     * Context is overridden when trying to play a YouTube video from the Google Play Store,
     * Which is speculated to affect VersionOverridePatch
     */
    public static String getVersionOverride(String version) {

        try {
            boolean isOldLayoutEnabled = SharedPrefHelper.getBoolean(context, REVANCED, "revanced_enable_old_layout", false);
            boolean isInitialSpoofed = SharedPrefHelper.getBoolean(context, REVANCED, "revanced_initial_spoof", false);

            return !isInitialSpoofed ? "18.04.43" : isOldLayoutEnabled ? "17.28.35" : version;
        } catch (Exception ex){
            LogHelper.printException(VersionOverridePatch.class, "Failed to getBoolean", ex);
            return version;
        }
    }
}