package org.haxe.extension;

// import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.*;
import org.haxe.extension.extensionkit.Trace;
import org.haxe.extension.PushNotificationService;

public class PNSFirebaseInstanceIDService extends FirebaseInstanceIdService {
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
//        String refreshedToken = getPushID();
        String refreshedToken = FirebaseInstanceId.getInstance(PushNotificationService.firebaseApp).getToken();
        Trace.Error("onrefresh");
        Trace.Error(refreshedToken.toString());

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
//        sendRegistrationToServer(refreshedToken);
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to app server.
    }

    public static String getPushID(FirebaseApp firebaseApp) {
        if (firebaseApp == null) {
            Trace.Error("firebaseApp IS NULL 222");
        } else {
            Trace.Error("firebaseApp IS NOT NULL 222");
        }

        String token = FirebaseInstanceId.getInstance(firebaseApp).getToken();
        return token;
    }
}
