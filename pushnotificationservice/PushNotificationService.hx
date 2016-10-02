package pushnotificationservice;

import extensionkit.ExtensionKit;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.utils.JNI;
#end


class PushNotificationService {
	private static var pushnotificationservice_getPushID_jni : Dynamic;
	// private static var pushnotificationservice_getPushID : Dynamic; // for iOS

	public static var pushnotificationservice_firebaseInit_jni : Dynamic;

	public static function Initialize() : Void {
		try {
			#if android
				pushnotificationservice_getPushID_jni = JNI.createStaticMethod("org/haxe/extension/PushNotificationService", "getPushID", "()Ljava/lang/String;");
				pushnotificationservice_firebaseInit_jni = JNI.createStaticMethod("org/haxe/extension/PushNotificationService", "firebaseInit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
			#end
			#if cpp
				// TODO iOS method
			#end
		} catch(e:Dynamic) {
			trace(e);
		}

		ExtensionKit.Initialize();
	}

	public static function getPushID() {
		#if android
			if (pushnotificationservice_getPushID_jni != null) {
				return pushnotificationservice_getPushID_jni();
			} else {
				trace("Error: PushNotificationService doesn't initialized");
				return "";
			}
		#elseif (cpp && mobile)
//			return pushnotificationservice_getPushID();
		#end
	}

	public static function messageServerInit(apiKey: String, appId: String, dbUrl: String, gcmSenderId: String, storageBucket: String) {
		#if android
				if (isEmpty(apiKey) || isEmpty(appId) || isEmpty(dbUrl) || isEmpty(gcmSenderId) || isEmpty(storageBucket)) {
					trace("Error: Incorrent firebase init parameters");
				} else {
					if (pushnotificationservice_firebaseInit_jni != null) {
						pushnotificationservice_firebaseInit_jni(apiKey, appId, dbUrl, gcmSenderId, storageBucket);
					} else {
						trace("Error: PushNotificationService doesn't initialized");
					}
				}
		#elseif (cpp && mobile)
		#end
	}

	private static function isEmpty(v: String) : Bool {
		return v == "" || v == null;
	}
}