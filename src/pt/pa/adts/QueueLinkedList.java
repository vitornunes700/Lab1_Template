package pt.pa.adts;

/**
 * Double linked list implementation of the queue data structure
 *
 * @param <T> The queue element type.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;


    /**
     * Creates a new double linked list implementation of the queue data structure
     */
    public QueueLinkedList(int capacity) {
        clear();
        this.capacity = capacity;
    }

    /**
     * Enqueues a new element in the queue
     *
     * @param element element to enqueue
     * @throws FullQueueException when the queue is full
     */
    public void enqueue(T element) throws FullQueueException {
        if(size() == capacity)
            throw new FullQueueException();

        Node newNode = newNode = new Node(element, header, header.next);

        header.next.prev = newNode;
        header.next = newNode;

        size++;
    }

    /**
     * Dequeue the top element of the queue
     *
     * @return the dequeued element
     * @throws EmptyQueueException when the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();

        Node node = trailer.prev;

        node.prev.next = trailer;
        trailer.prev = node.prev;

        size--;

        return node.element;

    }

    /**
     * Returns the top element of the queue
     *
     * @return top element of the queue
     * @throws EmptyQueueException when the queue is empty
     */
    public T front() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return trailer.prev.element;
    }

    /**
     * Returns the size of the queue
     *
     * @return size of the queue
     */
    public int size() {
        return this.size;
    }

    /**
     * Verifies if the queue is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Removes all the elements from the queue
     */
    public void clear() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);

        header.next = trailer;
        size = 0;
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
