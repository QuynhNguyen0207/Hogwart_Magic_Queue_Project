public class MyStack {
    // Attributes
    private Node top;
    
    // Constructors
    public MyStack() {
        Node top = null;
    }
    
    // Push a node into stack
    public void push(Node node) {
        Node temp = top;
        top = node;
        node.setNext(temp);
    }
    
    // Get and remove the top node from the stack
    public Node pop() {
        if(top != null) {
            Node temp = this.top;
            this.top = this.top.getNext();
            return temp;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }

    // Get the top node in the stack
    public Node peek() {
        if(top != null) {
            return top;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    } 
}