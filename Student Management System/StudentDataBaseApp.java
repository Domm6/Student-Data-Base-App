import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDataBaseApp{
    public static void main(String[] args) {

        // Ask how many new students we want to add
        try{
        System.out.println("Enter number of new students to enroll: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        Student[] students = new Student[numberOfStudents];

        // Create n number of new studetns
        for(int i = 0; i < numberOfStudents; i++){
            students[i] = new Student();
            students[i].enroll();
            students[i].viewBalance();
            students[i].payTuition();
        }
        System.out.println();

        // List of all students and info
        System.out.println("Here is a list of all the students and their inforamtion: ");
        for(int i = 0; i < numberOfStudents; i++){
            students[i].showInfo();
            System.out.println();
        }
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a valid number of students. ");
        } 
           
    }
}

    class Student{
        private String firstName;
        private String lastName;
        private int gradeYear;
        private String gradeYearName;
        private String studentId;
        private int numberOfCourses;
        private String courses = null;
        private double tuitionBalance = 0;
        private static double costOfCourse = 600;
        private static int id = 1000;


        // Constructor: prompt user to enter student's name and year
        public Student(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student first name: ");
            this.firstName = scanner.nextLine();
            System.out.println("Enter student last name: ");
            this.lastName = scanner.nextLine();
            System.out.println("1 - Freshman\n2 = Sophmore\n3 = Junior \n4 = Senior\nEnter student class level: ");
            this.gradeYear = scanner.nextInt();

            if(gradeYear == 1){
                gradeYearName = "Freshman";
            } else if(gradeYear == 2){
                gradeYearName = "Sophmore";
            } else if(gradeYear == 3){
                gradeYearName = "Junior";
            } else if(gradeYear == 4){
                gradeYearName = "Senior";
            } else {
                while (1 != 0){
                
                System.out.println("That is not a valid grade year. Please enter a valid year");
                }
            }
            generateStudentID();            
        }


        // Generate an ID
            private void generateStudentID(){
                // Grade level + ID
                id++;
                this.studentId = gradeYear + "" + id;
               
            }


        // Enroll in courses
        public void enroll(){
            do{
                System.out.println("Enter course to enroll (Q to quit): ");
                Scanner scanner = new Scanner(System.in);
                String course = scanner.nextLine();

                if(!course.equalsIgnoreCase("q")){
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse; 
                } else {
                    break; 
                } 
               } while (1 != 0);

               System.out.println("Tuitoin Balance: " + tuitionBalance);

        }   
            

        // View balance
        public void viewBalance(){
            System.out.println("Tuitoin balance is: $" + tuitionBalance);
        }


        // Pay tuition
        public void payTuition(){
            Scanner scanner = new Scanner(System.in);


            try{            
            System.out.println("Would you like to make a payment? Press 1 for yes or 2 for no.");
            double makePayment = scanner.nextInt();
            if(makePayment == 1){
            System.out.println("How much would you like to pay? ");
            double payment = scanner.nextDouble();
            tuitionBalance = tuitionBalance - payment;
            System.out.println("Thank you for your payment of $" + payment);
            viewBalance();
            } else if(makePayment == 2){
                System.out.println("Alright. No payment will be made.");
            }                
            } catch (InputMismatchException e) {
                System.out.println("Please enter only 1 or 2.");
            } catch (Exception e) {
                System.out.println("Somethign went wrong");
            }


        }


        // Show status
        public void showInfo(){
            System.out.println("Name: " + firstName + " "  + lastName);
            System.out.println("Grade: " + gradeYearName);
            System.out.println("Student ID: " + studentId);
            System.out.println("Courses Enrolled: " + courses);
            System.out.println("Remaining Balance: $" + tuitionBalance);
        }

    }