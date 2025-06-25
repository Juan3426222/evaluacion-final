package bridge;

public class EmailNotification implements TaskImplementation {
    @Override
    public void send(String message) {
        System.out.println("[Email] Notificación: " + message);
    }
}