/*
question:-
You need to send notifications via different channels (Email, SMS, Whatsapp).
You also have different notification types (Alert, Reminder, Promotion).
Design a system that allows you to easily add new channels or notification types using the Bridge pattern.


old approach (with bridge design pattern)
    notification system is implemented by 3 classes Email, SMS, whatsapp
    then each of these 3 classes will be extended by diffeernt notification types
    like AlertEmail , SMSReminder
    so we kind of have
    3 * 3 = 9 classes

    but by bridge we have only 3 + 3 six

* */

interface NotificationSender{
    void sendNotification();
}
interface Notification{
    void notifyUser();
}
class Alert implements NotificationSender{
    final int priority = 1;
    String name="ALERT";
    Notification notification;

    public Alert(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void sendNotification() {

        System.out.println("alert mail send ");
        notification.notifyUser();
    }
}
class Reminder implements NotificationSender{
    final int priority = 2;
    String name="REMINDER";
    Notification notification;
    public Reminder(Notification notification) {
        this.notification = notification;
    }
    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void sendNotification() {
        System.out.println("Reminder mail send ");
        notification.notifyUser();
    }

}
class Promotion implements NotificationSender{
    final int priority = 3;
    String name="PROMOTION";
    Notification notification;
    public Promotion(Notification notification) {
        this.notification = notification;
    }
    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void sendNotification() {
        System.out.println("Promotion mail send ");
        notification.notifyUser();
    }
}
class EmailNotificationSender implements  Notification{
    String sender;
    String receiver ;
    String subject ;
    String text ;


    public EmailNotificationSender(String sender, String receiver, String subject, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
    }

    @Override
    public String toString() {
        return "EmailNotificationSender{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public void notifyUser() {
        System.out.println("Email Notification data: "+this.toString());
    }
}
class SMSNotificationSender implements  Notification{
    String mobileNumber;
    String text;

    public SMSNotificationSender(String mobileNumber, String text ) {
        this.mobileNumber = mobileNumber;
        this.text = text;
    }

    @Override
    public String toString() {
        return "SMSNotificationSender{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public void notifyUser() {
        System.out.println("Sms Notification data: "+this.toString());
    }

}
class WhatsappNotificationSender implements  Notification{
    String mobileNumber;
    String text;
    String id;

    public WhatsappNotificationSender(String mobileNumber, String text, String id) {
        this.mobileNumber = mobileNumber;
        this.text = text;
        this.id = id;
    }
    @Override
    public void notifyUser() {
        System.out.println("whatsapp send data : "+this.toString());
    }

    @Override
    public String toString() {
        return "WhatsappNotificationSender{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", text='" + text + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
    }
}