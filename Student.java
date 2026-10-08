
import java.util.Scanner;

class Student {

    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship percentage
    double calculateScholarship() {
        if (marks >= 85) {
            return 20;
        } else if (marks >= 70) {
            return 10;
        } else {
            return 0;
        }
    }

    // Calculate final fee
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();

        return fee - (fee * scholarship / 100);
    }

    // Display all details
    void displayDetails() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();
        double scholarshipAmount = fee * scholarship / 100;
        double finalFee = calculateFinalFee();

        System.out.println("\n----- Student Course Details -----");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Course Credits : " + courseCredits);

        System.out.println("Eligibility  : Eligible");
        System.out.println("Total Fee    : Rs. " + fee);
        System.out.println("Scholarship  : " + scholarship + "%");
        System.out.println("Scholarship Amount : Rs. " + scholarshipAmount);
        System.out.println("Final Fee    : Rs. " + finalFee);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read student details
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        sc.nextLine(); // consume newline

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        // Create object using parameterized constructor
        Student s = new Student(name, roll, marks, course, credits);

        // Check eligibility
        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("\nStudent is not eligible for course registration.");
            System.out.println("Minimum required marks: 50");
        }

        sc.close();
    }
}
