package bridge;

public class SmsNotification implements TaskImplementation {
    @Override
    public void send(String message) {
        System.out.println("[SMS] Notificación: " + message);
    }
}