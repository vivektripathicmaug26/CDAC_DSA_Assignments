public class SleeperCoach {
    private boolean[] booked;
    private int n;

    public SleeperCoach(int n) {
        this.n = n;
        this.booked = new boolean[n + 1]; 
    }

    public static String berthType(int seatNo) {
        int rem = seatNo % 8;
        if (rem == 1 || rem == 4) return "LB";
        if (rem == 2 || rem == 5) return "MB";
        if (rem == 3 || rem == 6) return "UB";
        if (rem == 7) return "SL";
        if (rem == 0) return "SU";
        return "";
    }

    public int book(String preferred) {
        preferred = preferred.toUpperCase();
        for (int s = 1; s <= n; s++) {
            if (!booked[s] && berthType(s).equals(preferred)) {
                booked[s] = true;
                return s;
            }
        }
       
        for (int s = 1; s <= n; s++) {
            if (!booked[s]) {
                booked[s] = true;
                return s;
            }
        }
        return -1; 
    }

    public boolean cancel(int seatNo) {
        if (seatNo < 1 || seatNo > n || !booked[seatNo]) {
            System.out.println("Error: Invalid or unbooked seat.");
            return false;
        }
        booked[seatNo] = false;
        return true;
    }

    public int available() {
        int count = 0;
        for (int s = 1; s <= n; s++) {
            if (!booked[s]) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        SleeperCoach coach = new SleeperCoach(24);
        System.out.println("Booked Seat: " + coach.book("LB"));
        System.out.println("Available Seats: " + coach.available());
    }
}
