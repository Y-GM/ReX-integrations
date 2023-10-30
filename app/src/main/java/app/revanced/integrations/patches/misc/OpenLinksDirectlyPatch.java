package app.revanced.integrations.patches.misc;

import android.net.Uri;

import app.revanced.integrations.settings.SettingsEnum;

public class OpenLinksDirectlyPatch {
    private static final String YOUTUBE_REDIRECT_PATH = "/redirect";

    public static Uri enableBypassRedirect(String uri) {
        final Uri parsed = Uri.parse(uri);

        if (SettingsEnum.ENABLE_OPEN_LINKS_DIRECTLY.getBoolean() && parsed.getPath().equals(YOUTUBE_REDIRECT_PATH)) {
            return Uri.parse(Uri.decode(parsed.getQueryParameter("q")));
        }

        return parsed;
    }
}
