//===================================
// Foundations of Computer Science
// Student: Ngoc Phuong Quynh Nguyen
// id: a1865083
// Semester: 2
// Year: 2022
// Practical Number: 04 (Part 2)
//====================================

public class HanoiTowerIterativeAlgorithm {
    //
    public int capacity;
    public int top;
    public int array[];
    public int dTmp;

    // Implement Basic Constructor
    public HanoiTowerIterativeAlgorithm() {
    }

    // Implement Mutators
    public void setcapacity(int capacity) {
        this.capacity = capacity;
    }

    // Implement Accessors
    public int capacity(int capacity) {
        return capacity;
    }

    // Implement Mutators
    public void settop(int top) {
        this.top = top;
    }

    // Implement Accessors
    public int top(int top) {
        return top;
    }

    // Implement Mutators
    public void setarray(int array[]) {
        this.array = array;
    }

    // Implement Accessors
    public int array(int array) {
        return array;
    }

    // Implement Basic Constructor
    public HanoiTowerIterativeAlgorithm(int[] dTmp) {
    }

    // Implement Mutators(
    public void setdTmp(int dTmp) {
        this.dTmp = dTmp;
    }

    // Implement Accessors
    public int dTmp(int dTmp) {
        return dTmp;
    }

    // Function to create a tower of given capacity
    HanoiTowerIterativeAlgorithm createTower(int capacity) {
        HanoiTowerIterativeAlgorithm hanoiTower = new HanoiTowerIterativeAlgorithm();
        hanoiTower.capacity = capacity;
        hanoiTower.top = -1;
        hanoiTower.array = new int[capacity];
        return hanoiTower;
    }

    // HanoiTower is full when the top is equal to the last index
    boolean isFull(HanoiTowerIterativeAlgorithm hanoiTower) {
        return (hanoiTower.top == hanoiTower.capacity - 1);
    }

    // HanoiTower is empty when the top is equal to -1
    boolean isEmpty(HanoiTowerIterativeAlgorithm hanoiTower) {
        return (hanoiTower.top == -1);
    }

    // Function to add an item to HanoiTower. It increases top by 1
    void push(HanoiTowerIterativeAlgorithm hanoiTower, int item) {
        if (isFull(hanoiTower))
            return;

        hanoiTower.array[++hanoiTower.top] = item;
    }

    // Function to remove an item for HanoiTower. It decreases top by 1
    int pop(HanoiTowerIterativeAlgorithm hanoiTower) {
        if (isEmpty(hanoiTower))
            return Integer.MIN_VALUE;

        return hanoiTower.array[hanoiTower.top--];
    }

    // Function to implement legal movement between two poles
    void moveDisksBetweenTwoPoles(HanoiTowerIterativeAlgorithm Alpha, HanoiTowerIterativeAlgorithm Beta, char a,
            char b) {
        int pole1TopDisk = pop(Alpha);
        int pole2TopDisk = pop(Beta);

        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            push(Alpha, pole2TopDisk);
            moveDisk(b, a, pole2TopDisk);
        }

        // When pole 2 pole is empty
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            push(Beta, pole1TopDisk);
            moveDisk(a, b, pole1TopDisk);
        }

        // When top disk of pole1 > top disk of pole2
        else if (pole1TopDisk > pole2TopDisk) {
            push(Alpha, pole1TopDisk);
            push(Alpha, pole2TopDisk);
            moveDisk(b, a, pole2TopDisk);
        }

        // When top disk of pole1 < top disk of pole2
        else {
            push(Beta, pole2TopDisk);
            push(Beta, pole1TopDisk);
            moveDisk(a, b, pole1TopDisk);
        }
    }

    // Function to show the movement of disks
    void moveDisk(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk + " from " + fromPeg + " to " + toPeg);
    }

    // Function to implement HanoiTower puzzle
    void hanoiTowerInterative(int num_of_disks, HanoiTowerIterativeAlgorithm Alpha, HanoiTowerIterativeAlgorithm Gama,
            HanoiTowerIterativeAlgorithm Beta) {
        int i, total_num_of_moves;
        char a = 'A', g = 'G', b = 'B';

        // If number of disks is even, then interchange destination pole and auxiliary
        // pole
        if (num_of_disks % 2 == 0) {
            char temp = b;
            b = g;
            g = temp;
        }

        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

        // Larger disks will be pushed first
        for (i = num_of_disks; i >= 1; i--)
            push(Alpha, i);

        for (i = 1; i <= total_num_of_moves; i++) {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(Alpha, Beta, a, b);

            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(Alpha, Gama, a, g);

            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(Gama, Beta, g, b);
        }
    }

    public static void main(String args[]) { // Driver code
        // Input: number of disks
        int num_of_disks = 3;
        HanoiTowerIterativeAlgorithm object = new HanoiTowerIterativeAlgorithm();
        HanoiTowerIterativeAlgorithm Alpha, Beta, Gama;

        // Create three towers of size 'num_of_disk' to hold the disks
        Alpha = object.createTower(num_of_disks);
        Beta = object.createTower(num_of_disks);
        Gama = object.createTower(num_of_disks);

        object.hanoiTowerInterative(num_of_disks, Alpha, Gama, Beta);
    }
}