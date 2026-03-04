package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    void update(String videoTitle);
}

class Email implements Subscriber{
    private String email;

    public Email(String email){
        this.email = email;
    }

    @Override
    public void update(String videoTitle){
        System.out.println("Notification sent to email Subscriber " + email + "for new Video " + videoTitle);
    }
}

class Mobile implements Subscriber{
    private String username;

    public Mobile(String username){
        this.username = username;
    }

    @Override
    public void update(String videoTitle){
        System.out.println("Notification sent to Mobile Subscriber " + username + "for new Video " + videoTitle);
    }
}

interface channel{
    void addSubscribers(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber(String videoTitle);
}

class YoutubeChannel implements channel{
    private List<Subscriber> subscribers;
    private String channelName;

    public YoutubeChannel(String channelName){
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscribers(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(String videoTitle) {
        for(Subscriber subscriber:subscribers){
            subscriber.update(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle){
        System.out.println("New Video Uploaded");
        notifySubscriber(videoTitle);
    }
}

public class Observer {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel("TakeYouForward");
        Subscriber subscriber1 = new Email("ojas@gmail.com");
        Subscriber subscriber2 = new Mobile("ojas2391");
        youtubeChannel.addSubscribers(subscriber1);
        youtubeChannel.addSubscribers(subscriber2);
        youtubeChannel.uploadVideo("ObserverPattern");
        youtubeChannel.removeSubscriber(subscriber1);
        youtubeChannel.uploadVideo("TestingObserver");
    }
}
