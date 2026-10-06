class Patient {
    String name; 
    Patient prev, next;
    Patient(String n) { 
        this.name = n; 
    }
}

public class WaitingList {
    private Patient head, tail;
    private int size;

    public void addNormal(String name) {
        Patient p = new Patient(name);
        if (tail == null) {
            head = tail = p;
        } else {
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
        size++;
    }

    public void addEmergency(String name) {
        Patient p = new Patient(name);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head.prev = p;
            head = p;
        }
        size++;
    }

    public String callNext() {
        if (head == null) return null;
        String name = head.name;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return name;
    }

    public static void main(String[] args) {
        WaitingList list = new WaitingList();
        list.addNormal("John");
        list.addEmergency("Alice");
        System.out.println("Next patient: " + list.callNext());
    }
}
