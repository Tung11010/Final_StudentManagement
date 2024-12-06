package StudentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Method to print all students
    void PrintList() {
        System.out.println("\tStudent Information List");
        System.out.println("\t*********************");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // Method to add a new student
    void AddStudent() {
        // Input validation for student ID
        String ID = "";
        while (ID.isEmpty()) {
            System.out.print("Enter Student ID: ");
            ID = scanner.nextLine().trim();
            if (ID.isEmpty()) {
                System.out.println("ID cannot be empty.");
            }
        }

        // Input validation for student name
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter Student Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        }

        // Input marks with validation
        double marks = inputMarks(scanner);

        // Create and add the student to the list
        Student stu = new Student(ID, name, marks);
        students.add(stu);
    }

    // Method to edit a student by ID
    void EditStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to delete a student by ID
    void DeleteStudentByID(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(id)) {
                students.remove(i);
                System.out.println("Student with ID " + id + " has been removed.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to find a student by ID
    void FindStudent(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to sort students by marks using Merge Sort (Ascending order)
    void MergeSortByMarks() {
        System.out.println("Sorting by marks using Merge Sort (Ascending)... ");
        students = mergeSort(students);
        PrintList();
    }

    private ArrayList<Student> mergeSort(ArrayList<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList;
        }

        int mid = studentList.size() / 2;
        ArrayList<Student> left = new ArrayList<>(studentList.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(studentList.subList(mid, studentList.size()));

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    // Merge two sorted lists
    private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
        ArrayList<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMarks() <= right.get(j).getMarks()) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    // Method to sort students by marks using Bubble Sort (Ascending order)
    void BubbleSortByMarks() {
        System.out.println("Sorting by marks using Bubble Sort (Ascending)... ");
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Swap the two students
                    Collections.swap(students, j, j + 1);
                }
            }
        }
        PrintList();
    }

    // Method to input marks with validation
    private double inputMarks(Scanner sc) {
        double marks = -1;
        while (marks < 0 || marks > 10) {
            try {
                System.out.print("Enter Student Marks (0-10): ");
                marks = sc.nextDouble();
                if (marks < 0 || marks > 10) {
                    System.out.println("Marks must be between 0 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for marks.");
                sc.nextLine(); // Clear buffer
            }
        }
        return marks;
    }

    // Method to start the program and handle menu choices
    void Start() {
        int choice;
        do {
            System.out.println("\tMENU");
            System.out.println("1. Display all students");
            System.out.println("2. Add new student");
            System.out.println("3. Edit student");
            System.out.println("4. Delete student");
            System.out.println("5. Sort students by marks (Merge Sort)");
            System.out.println("6. Sort students by marks (Bubble Sort)");
            System.out.println("7. Search student by ID");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after integer input

            switch (choice) {
                case 1:
                    PrintList();
                    break;
                case 2:
                    AddStudent();
                    break;
                case 3:
                    System.out.print("Enter the ID of the student to edit: ");
                    String editID = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    double newMarks = inputMarks(scanner);
                    EditStudent(editID, newName, newMarks);
                    break;
                case 4:
                    System.out.print("Enter the ID of the student to delete: ");
                    String delID = scanner.nextLine();
                    DeleteStudentByID(delID);
                    break;
                case 5:
                    MergeSortByMarks();
                    break;
                case 6:
                    BubbleSortByMarks();
                    break;
                case 7:
                    System.out.print("Enter the ID of the student to search for: ");
                    String searchID = scanner.nextLine();
                    FindStudent(searchID);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
        scanner.close();
    }

    public static void main(String[] args) {
        StudentManagementSystem studentManager = new StudentManagementSystem();
        studentManager.Start();
    }
}
