package pt.pa.adts;

public class FullQueueException extends Exception {
    public FullQueueException(){
        super("Queue está cheia");
    }
}