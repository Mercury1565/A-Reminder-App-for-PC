package projectFinal;

import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import doryan.windowsnotificationapi.fr.Notification;

public class windowsNotify {
	public static void main() {
		try {
			Notification.sendNotification("Reminder", "It is time to complete a task", MessageType.INFO);
		} catch (MalformedURLException | AWTException e) {
			e.printStackTrace();
		}
	}
}

