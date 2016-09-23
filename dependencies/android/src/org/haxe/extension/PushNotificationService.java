package org.haxe.extension;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import org.haxe.extension.PNSFirebaseInstanceIDService;

import java.lang.String;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.*;
import org.haxe.extension.extensionkit.Trace;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class PushNotificationService extends Extension {
	
	public static FirebaseApp firebaseApp = null;
	public static int sampleMethod (int inputValue) {
		
		return inputValue * 100;
		
	}
	
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		
		return true;
		
	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		Trace.Error("oncreate pns");

		FirebaseOptions.Builder firebaseBuilder = new FirebaseOptions.Builder();
		firebaseBuilder.setApiKey("AIzaSyBXSAK0oBZjuX8JYWxlxP6sm1jG0JMenGo");
		firebaseBuilder.setApplicationId("1:60691401087:android:739aed522d2d96b5");
		firebaseBuilder.setDatabaseUrl("https://clover-2b677.firebaseio.com");
		firebaseBuilder.setGcmSenderId("60691401087");
		firebaseBuilder.setStorageBucket("clover-2b677.appspot.com");

		firebaseApp = FirebaseApp.initializeApp(mainContext, firebaseBuilder.build());

		if (firebaseApp == null) {
			Trace.Error("firebaseApp IS NULL");
		} else {
			Trace.Error("firebaseApp IS NOT NULL");
		}

		String t = PNSFirebaseInstanceIDService.getPushID(firebaseApp);

		if (t == null) {
			Trace.Error("token IS NULL");
		} else {
			Trace.Error("token IS NOT NULL");
		}

//		PNSFirebaseInstanceIDService pnsFIIDS = new PNSFirebaseInstanceIDService();
//		String t = pnsFIIDS.getPushID(firebaseApp).toString();
//		Trace.Error("token = ");
//		Trace.Error(t);
//		if (!FirebaseApp.getApps(this).isEmpty()) {
//			Trace.Error("oncreate pns 0");
//			FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//		}
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	public static String getPushID() {
		return "";
//		return PNSFirebaseInstanceIDService.getPushID(firebaseApp);
//		Trace.Error("getpushid init");
//		FirebaseOptions.Builder firebaseBuilder = new FirebaseOptions.Builder();
//		firebaseBuilder.setApiKey("AIzaSyBXSAK0oBZjuX8JYWxlxP6sm1jG0JMenGo");
//		firebaseBuilder.setApplicationId("1:60691401087:android:739aed522d2d96b5");
//		firebaseBuilder.setDatabaseUrl("https://clover-2b677.firebaseio.com");
//		firebaseBuilder.setGcmSenderId("60691401087");
//		firebaseBuilder.setStorageBucket("clover-2b677.appspot.com");

//		FirebaseApp.initializeApp(mainContext, firebaseBuilder.build());

//		String token = "new token";
//		Trace.Error("getpushid pns");
//		try {
//			Trace.Error("getpushid pns 1");
//			token = FirebaseInstanceId.getInstance(firebaseApp).getToken();
//			Trace.Error("getpushid pns 2");
////			Trace.Error(token);
//		} catch (Exception e) {
//			Trace.Error("getpushid pns 3");
//			token = "null token";
//			Trace.Error(e.toString());
//		}
//		return token;
	}
}