public class MyQueue {

    // Attributes
    private Node front, rear;

    // constructor
    public MyQueue() {

        // initialize front and rear as null
        this.front = null;
        this.rear = null;
    }

    // getter
    public Node getFront() {
        return front;
    }
    public Node getRear() {
        return rear;
    }

    // methods
    // Insert one node at the end of the queue.
    public void enqueue(String data) {
        // create new node with data
        Node node = new Node(data);

        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
    }

    // Get and remove the front node from the queue. 
    public String dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return null;
        }
        Node node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return node.getData();
    }

    // Return TRUE when the queue is empty, otherwise, return FALSE.
    public boolean isEmpty() {
        return front == null;
    }

    // Print out the data saved in nodes from the first to the last. 
    public void displayQueue() {
        Node node = front;
        if( front == null) {
            System.out.println("Queue is empty");
        }
        while(node != null) {
            node.printNode();
            node = node.getNext();
        }
    }
    // method for queue size
    public int queueSize() {
        Node node = front;
        int counter = 0;
        while(node != null) {
            node = node.getNext();
            counter++;
        }
        return counter;   
    }
}