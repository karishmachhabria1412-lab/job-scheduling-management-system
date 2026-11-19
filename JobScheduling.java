import java.util.Scanner;

public class JobScheduling {

    static int queue[] = new int[50];
    static String jobName[] = new String[50];

    static int front = -1;
    static int rear = -1;

    // Add Job
    static void addJob(Scanner sc) {

        if (rear == 49) {
            System.out.println("Queue is Full!");
            return;
        }

        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Job Name: ");
        String name = sc.nextLine();

        if (front == -1) {
            front = 0;
        }

        rear++;

        queue[rear] = id;
        jobName[rear] = name;

        System.out.println("Job Added Successfully!");
    }

    // Display Jobs with Front and Rear Positions
    static void displayJobs() {

        if (front == -1 || front > rear) {
            System.out.println("No Jobs Available!");
            System.out.println("Front Position: -1");
            System.out.println("Rear Position: -1");
            return;
        }

        System.out.println("\nPending Jobs:");

        for (int i = front; i <= rear; i++) {

            if (i == front) {
                System.out.print("FRONT --> ");
            }

            if (i == rear) {
                System.out.print("REAR --> ");
            }

            System.out.println("Job ID: " + queue[i]
                    + "  Job Name: " + jobName[i]
                    + "  Index: " + i);
        }

        System.out.println("\nFront Position: " + front);
        System.out.println("Rear Position: " + rear);
    }

    // Execute Job
    static void executeJob() {

        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("\nExecuting Job:");
        System.out.println("Job ID: " + queue[front]);
        System.out.println("Job Name: " + jobName[front]);

        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }

        System.out.println("Job Executed Successfully!");
    }

    // Search Job
    static void searchJob(Scanner sc) {

        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Enter Job ID to Search: ");
        int id = sc.nextInt();

        for (int i = front; i <= rear; i++) {

            if (queue[i] == id) {
                System.out.println("Job Found!");
                System.out.println("Job Name: " + jobName[i]);
                return;
            }
        }

        System.out.println("Job Not Found!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== JOB SCHEDULING MANAGEMENT =====");
            System.out.println("1. Add Job");
            System.out.println("2. Display Jobs");
            System.out.println("3. Execute Job");
            System.out.println("4. Search Job");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addJob(sc);
                    break;

                case 2:
                    displayJobs();
                    break;

                case 3:
                    executeJob();
                    break;

                case 4:
                    searchJob(sc);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}