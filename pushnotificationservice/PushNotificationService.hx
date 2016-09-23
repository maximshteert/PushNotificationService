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

	public static function Initialize() : Void {
		try {
			#if android
				pushnotificationservice_getPushID_jni = JNI.createStaticMethod("org/haxe/extension/PushNotificationService", "getPushID", "()Ljava/lang/String;");
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
				var pushId = "";
				try {
					trace("getting push id");
					pushId = pushnotificationservice_getPushID_jni();
					trace("getting push id done");
				} catch (e: Dynamic) {
					trace("Error get push id: " + e.toString());
				}
				return pushId;
//				return pushnotificationservice_getPushID_jni();
			} else {
				trace("Error: PushNotificationService doesn't initialized");
				return "";
			}
		#elseif (cpp && mobile)
			return pushnotificationservice_getPushID();
		#end
	}
}