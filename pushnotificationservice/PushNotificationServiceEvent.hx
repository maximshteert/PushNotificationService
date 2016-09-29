package pushnotificationservice;

import flash.events.Event;


class PushNotificationServiceEvent extends Event {
    public static inline var REFRESH_TOKEN = "refresh_token";

    public var token(default, null) : String = null;

    public function new(type: String, token: String) {
        super(type, true, true);

        this.token = token;
    }

	public override function clone() : Event {
		return new PushNotificationServiceEvent(type, token);
	}

	public override function toString() : String {
        var s = "[PushNotificationServiceEvent type=" + type;
        s += " token=" + token;
        s += "]";
        return s;
	}
}
