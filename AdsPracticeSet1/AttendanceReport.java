public class AttendanceReport {

    static int countPresent(int[] att) {
        int count = 0;
        for (int day : att) {
            if (day == 1) {
                count++;
            }
        }
        return count;
    }

    static double percentage(int present, int total) {
        if (total == 0)
            return 0.0;
        return ((double) present / total) * 100.0;
    }

    static void longestStreak(int[] att, int value) {
        int current = 0, best = 0, bestEnd = -1;
        for (int i = 0; i < att.length; i++) {
            if (att[i] == value) {
                current++;
                if (current > best) {
                    best = current;
                    bestEnd = i;
                }
            } else {
                current = 0;
            }
        }
        if (best == 0) {
            System.out.println("0 days");
        } else {
            int startDay = (bestEnd - best + 2);
            System.out.println(best + " days (day " + startDay + " to day " + (bestEnd + 1) + ")");
        }
    }

    static int daysNeeded(int present, int total) {
        int additionalDays = 0;
        while (((double) (present + additionalDays) / (total + additionalDays)) * 100.0 < 75.0) {
            additionalDays++;
        }
        return additionalDays;
    }

    public static void main(String[] args) {
        int[] att = { 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0 };
        int total = att.length;
        int present = countPresent(att);
        double pct = percentage(present, total);

        System.out.println("Days present: " + present + " of " + total);
        System.out.println("Attendance: " + String.format("%.2f", pct) + "%");
        System.out.println("Eligible: " + (pct >= 75.0 ? "YES" : "NO"));

        System.out.print("Longest presence: ");
        longestStreak(att, 1);

        System.out.print("Longest absence: ");
        longestStreak(att, 0);

        if (pct < 75.0) {
            System.out.println("Days needed for 75%: " + daysNeeded(present, total));
        }
    }
}
