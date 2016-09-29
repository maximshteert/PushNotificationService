package org.haxe.extension;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.lang.Exception;
import java.lang.Void;
import java.util.concurrent.Callable;

import org.haxe.extension.extensionkit.Trace;
import org.haxe.extension.extensionkit.HaxeCallback;

public class PNSFirebaseInstanceIDService extends FirebaseInstanceIdService {
//    public static void sendToken() { };
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // Refresh token
    @Override
    public void onTokenRefresh() { // Get updated InstanceID token.
        Trace.Error("Refresh token");
        // Dispatch event refresh token to proccess it in main application
        HaxeCallback.DispatchEventToHaxe("pushnotificationservice.PushNotificationServiceEvent",
            new Object[]{
                "refresh_token",
                getPushID()
            }
        );
    }

    public static String getPushID() {
        return FirebaseInstanceId.getInstance().getToken();
    }
}
