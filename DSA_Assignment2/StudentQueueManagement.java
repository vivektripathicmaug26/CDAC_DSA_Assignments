import java.util.ArrayList;
import java.util.Scanner;

public class StudentQueueManagement {
    public static void main(String[] args) {

        ArrayList<Integer> queue = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Submit Assignment");
            System.out.println("3. Search Student");
            System.out.println("4. Display Queue");
            System.out.println("5. Count Students");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    queue.add(studentId);

                    System.out.println("Student added successfully.");
                    break;

                case 2:

                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        int removedStudent = queue.remove(0);

                        System.out.println(
                            "Student " + removedStudent +
                            " submitted the assignment."
                        );
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    if (queue.contains(searchId)) {
                        System.out.println(
                            "Student " + searchId + " is waiting."
                        );
                    } else {
                        System.out.println(
                            "Student " + searchId + " is not waiting."
                        );
                    }

                    break;

                case 4:

                    System.out.println("Current Queue: " + queue);
                    break;

                case 5:

                    System.out.println(
                        "Current number of students: " + queue.size()
                    );
                    break;

                case 6:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        
    }

}
