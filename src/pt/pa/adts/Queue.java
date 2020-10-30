package pt.pa.adts;

/**
 * Defines a queue data structure type
 *
 * @param <T> The queue element type.
 */
public interface Queue<T> {

    //TODO: definir operações do ADT e documentá-las

    /**
     * Enqueues a new element in the queue
     * @param element element to enqueue
     * @throws FullQueueException when the queue is full
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Dequeue the top element of the queue
     * @return the dequeued element
     * @throws EmptyQueueException when the queue is empty
     */
    T dequeue() throws  EmptyQueueException;

    /**
     * Returns the top element of the queue
     * @return top element of the queue
     * @throws EmptyQueueException when the queue is empty
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the size of the queue
     * @return size of the queue
     */
    int size();

    /**
     * Verifies if the queue is empty
     */
    boolean isEmpty();

    /**
     * Removes all the elements from the queue
     */
    void clear();

}
