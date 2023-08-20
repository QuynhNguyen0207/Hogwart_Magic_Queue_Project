public class Node {
    // Attributes
    private String data;
    private Node next;
    private char charAt;

    // Implement Basic Constructor
    public Node() {
        this.next = null;
    }

    // Implement Parametric Constructor
    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    // Implement Mutators
    public void setData (String data) {
        this.data = data;
    }
    public void setNext (Node next) {
        this.next = next;
    }
    public void setData(char charAt) {
        this.charAt = charAt;
    }

    // Implement Accessors
    public String getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public char getCharAt() {
        return charAt;
    }

    // Methods
    public void printNode() {
        System.out.print(this.getData() + " ");
    }
}
