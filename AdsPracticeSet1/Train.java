class Coach {
    String id, type; 
    Coach next;
    Coach(String id, String type) { 
        this.id = id; 
        this.type = type; 
    }
}

public class Train {
    private Coach head = new Coach("ENGINE", "ENGINE");
    private Coach tail = head;
    private int count = 0;

    public void attach(String id, String type) {
        Coach c = new Coach(id, type);
        tail.next = c; 
        tail = c; 
        count++;
    }

    public boolean detach(String id) {
        if (id.equals("ENGINE")) return false;
        Coach prev = head;
        while (prev.next != null && !prev.next.id.equals(id)) {
            prev = prev.next;
        }
        if (prev.next == null) return false;
        if (prev.next == tail) tail = prev;
        prev.next = prev.next.next; 
        count--;
        return true;
    }

    public static void main(String[] args) {
        Train train = new Train();
        train.attach("C1", "AC");
        train.attach("C2", "Sleeper");
        System.out.println("Train coaches attached successfully.");
    }
} 
