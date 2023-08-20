public class Main {
    public static void main(String[] args) {

        // Implement bracketsMatching
        String[] input = { "({})", "({)", "(1+2) * {(2+3)*(3+4)}", "((1+2) * {{2+3)*(3+4}})", " " };
        System.out.println("****bracketsMatching****");
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + bracketsMatching(input[i]));
        }

        // Implement reverseQueue
        System.out.println("****reverseQueue****");
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue("1");
        myQueue.enqueue("4");
        myQueue.enqueue("7");
        myQueue.enqueue("9");
        myQueue.enqueue("2");
        System.out.print("Input: ");
        myQueue.displayQueue();
        System.out.println(" ");
        System.out.print("Output: ");
        reverseQueue(myQueue).displayQueue();

        System.out.println("");

        MyQueue myQueue2 = new MyQueue();
        myQueue2.enqueue("3");
        myQueue2.enqueue("3");
        myQueue2.enqueue("4");
        myQueue2.enqueue("1");
        myQueue2.enqueue("2");
        System.out.print("Input: ");
        myQueue2.displayQueue();
        System.out.println(" ");
        System.out.print("Output: ");
        reverseQueue(myQueue2).displayQueue();
    }

    public static boolean bracketsMatching(String input) {
        // Create new stack to store string input
        MyStack myStack = new MyStack();
        
        // for loop to check CharAt from String input
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                Node temp = new Node();
                temp.setData(input.charAt(i));
                myStack.push(temp);
            } else if (input.charAt(i) == ')') {
                Node temp = myStack.peek();
                if (temp.getCharAt() == '(') {
                    myStack.pop();
                } else {
                    return false;
                }
            } else if (input.charAt(i) == ']') {
                Node temp = myStack.peek();
                if (temp.getCharAt() == '[') {
                    myStack.pop();
                } else {
                    return false;
                }
            } else if (input.charAt(i) == '}') {
                Node temp = myStack.peek();
                if (temp.getCharAt() == '{') {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static MyQueue reverseQueue(MyQueue queue) {

        // Create array to store queue data
        String[] arr = new String[queue.queueSize()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.dequeue();
        }

        // Add data with reverse order
        for (int i = arr.length -1; i >= 0; i--) {
            queue.enqueue(arr[i]);
        }
        return queue;
    }
}