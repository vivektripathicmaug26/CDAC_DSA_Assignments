class Job {
    String id, owner;
    int pages;
    Job(String id, String owner, int pages) {
        this.id = id; 
        this.owner = owner; 
        this.pages = pages;
    }
}

class Node {
    Job job;
    Node next;
    Node(Job j) { 
        job = j; 
    }
}

public class PrintQueue {
    private Node front, rear;
    private int size;

    public void enqueue(Job j) {
        Node newNode = new Node(j);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Job dequeue() {
        if (front == null) return null;
        Job j = front.job;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return j;
    }

    public boolean cancel(String jobId) {
        if (front == null) return false;
        if (front.job.id.equals(jobId)) {
            dequeue();
            return true;
        }
        Node curr = front;
        while (curr.next != null) {
            if (curr.next.job.id.equals(jobId)) {
                if (curr.next == rear) rear = curr;
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void printSchedule() {
        int time = 0;
        Node temp = front;
        while (temp != null) {
            time += temp.job.pages * 6;
            System.out.println("Job " + temp.job.id + " finishes at " + time + " s");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        queue.enqueue(new Job("J1", "Alice", 5));
        queue.enqueue(new Job("J2", "Bob", 3));
        queue.printSchedule();
    }
}