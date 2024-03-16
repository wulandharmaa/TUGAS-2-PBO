import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Book[] bookList;
    private List<Student> userStudent;
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
        // Inisialisasi daftar buku
        bookList = new Book[]{
                new Book("buset1", "Matdis", "Bejo", "Author1", 4),
                new Book("novi10", "Aljabar", "Sultan", "Author2", 6),
                new Book("sejarah1", "Sejarah Indonesia", "Alex", "Author3", 12),
                new Book("bindo3", "Bahasa Indonesia", "Max", "Author3", 5)
        };

        // Inisialisasi daftar user student
        userStudent = new ArrayList<>();
    }

    static String[][] users = {{"admin", "admin"}};

    // Fungsi untuk login user mahasiswa
    public static void mahasiswaLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your NIM (input 99 untuk back): ");
        String nim = input.nextLine();
        if (nim.equals("99")) {
            // Kembali ke menu utama
            return;
        }
        if (nim.length() == 15) {
            System.out.println("Login berhasil untuk mahasiswa dengan NIM " + nim);
            Student student = new Student("", nim, "", "");
            student.menuStudent();
        } else {
            System.out.println("Panjang NIM harus 15 karakter. Silakan coba lagi.");
        }
    }

    // Fungsi untuk login user admin
    public static void adminLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String username = input.next();
        System.out.print("Enter your password (admin): ");
        String password = input.next();
        if (username.equals(users[0][0]) && password.equals(users[0][1])) {
            System.out.println("Login berhasil sebagai admin");
            Admin admin = new Admin();
            admin.menuAdmin();
        } else {
            System.out.println("Invalid credentials for admin.");
        }
    }

    // Main program
    public static void main(String[] args) {
        Main library = new Main();
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            choice = input.next();

            switch (choice) {
                case "1":
                    mahasiswaLogin();
                    break;
                case "2":
                    adminLogin();
                    break;
                case "3":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (!choice.equals("3"));
    }
}


