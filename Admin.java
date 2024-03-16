import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private Scanner scanner;
    private List<Student> userStudent;

    public Admin() {
        this.scanner = new Scanner(System.in);
        this.userStudent = new ArrayList<>();
    }

    public void menuAdmin() {
        int choice;
        do {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            choice = readIntegerInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out from admin account.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    private int readIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    private void displayBooks(Book[] books) {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book.getId() + " (" + book.getTitle() + ") " + " (" + book.getAuthor() + ") - " + book.getStock() + " copies available");
        }
    }

    private void addBook() {
        // Implement add book functionality
    }

    private void removeBook() {
        // Implement remove book functionality
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        String nim;
        do {
            System.out.print("Enter student NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM Harus 15 Digit");
            }
        } while (nim.length() != 15);

        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();

        System.out.print("Enter student program: ");
        String studyProgram = scanner.nextLine();

        userStudent.add(new Student(name, nim, faculty, studyProgram));
        System.out.println("Student successfully registered.");
    }

    public void displayStudent() {
        System.out.println("List of Registered Students:");
        for (Student student : userStudent) {
            System.out.println("Name: " + student.getName());
            System.out.println("Faculty: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Program: " + student.getStudyProgram());
            System.out.println();
        }
    }
}

