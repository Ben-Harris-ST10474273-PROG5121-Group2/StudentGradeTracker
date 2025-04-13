/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradetracker; 
import java.util.Scanner; //Imports scanner class
import java.util.ArrayList; //Imports array class

public class GradeTracker {
    private ArrayList<String> studentNames; 
    private ArrayList<Double> studentGrades; 
    private Scanner scanner; 
    
    //Constructor to create a GradeTracker object
    public GradeTracker() {
        studentNames = new ArrayList<>(); //initializes an empty names arraylit
        studentGrades = new ArrayList<>(); //initializes an empty grades array list
        scanner = new Scanner(System.in); //initializes a scanner for user inputs
    }
    
    //Method to run the program
    public void start() { 
        System.out.println("Welcome to the Student Grade Tracker!\n"); //Welcome message & new line
        
        int choice; // var. choice created for the option chosen
        
        /**
        *Do loop that does the code in the curly braces first and then checks 
        * the while code and if it is true the loop repeats.
        * It repeats if the user does not select 5.
        */ 
        do { 
            displayMenu(); //Shows the diplay menu
            System.out.print("\nEnter your choice: ");
            
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                /**
                 * Executes methods based on the input chosen, var. 
                 * choice is compared to the menu # options
                 */
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        calculateAverage();
                        break;
                    case 4:
                        searchStudent();
                        break;
                    case 5:
                        System.out.println("\nExiting the program. Thank you!");
                        break;
                        //Handles invalid menu choices
                    default:
                        System.out.println("Invalid choice. Please enter a whole number between 1 and 5.");
                }
                
               //Exeption handling for non-numerical inputs
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0; // Reset choice to continue loop
            }
            
        } while (choice != 5); //While choice does not = 5 then loop repeats
        
        scanner.close(); //closes the scanner 
    }
    
   
      //Displays the main menu
    
    private void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add a new student and grade");
        System.out.println("2. Display list of students and their grades");
        System.out.println("3. Calculate average grade for the subject");
        System.out.println("4. Search for a student and display their grade");
        System.out.println("5. Exit");
    }
    
   
     //Adds a new student and their grade to the tracker
     
    public void addStudent() {
        System.out.print("Enter student's name: "); //Promts user for input
        String name = scanner.nextLine().trim(); //Stores the input from the whole line and trims white spaces
        
        //Deal with an empty input
        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            return; //Return control to the code that called the method
        }
        
        System.out.print("Enter " + name + "'s grade: "); //Promts user for input
        try {
            double grade = Double.parseDouble(scanner.nextLine()); //Sotres the input and converts it to a doubkle val.
            
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                return; //Return control to the code that called the method
            }
            
            studentNames.add(name); //adds the name to the array list
            studentGrades.add(grade); //adds the grade to the array list
            System.out.println(name + "'s grade has been added successfully.");
            
            //Exeption handling for non numerica inputs
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade. Please enter a number.");
        }
    }
    
    /**
     * Displays all students and their grades
     */
    public void displayStudents() {
        
        //checks if the array is empty 
        if (studentNames.isEmpty()) { 
            System.out.println("No students in the record."); //Displays message
            return; //Returns control to the code that called the method
        }
        
        System.out.println("List of students and their grades:"); //Displays message
        
        //for loop that repeats until all student names and grades have been displayed
        for (int i = 0; i < studentNames.size(); i++) {
            
            //prints the info, (i+1) accounts for the array val. place strarting at 0
            System.out.println((i + 1) + ". " + studentNames.get(i) + " - " + studentGrades.get(i)); 
        }
    }
    
    /**
     * Calculates and displays the average grade
     */
    public void calculateAverage() {
        
        //checks if grade is empty
        if (studentGrades.isEmpty()) {
            
            //Displays message if code is empty
            System.out.println("No grades available to calculate average.");
            return;//Returns control to the code that called the method
        }
        
        double sum = 0; //Ensure counting begins at 0, so that the method can be called more than once accurately
         
        //runs for each grade val. in the array list
        for (double grade : studentGrades) {
            sum += grade; //adds grade vals one at a time, sum = sum + grade 
        }
        
        double average = sum / studentGrades.size(); //divides the sum by the number of people
        
        //Displays avg. to two decimal places as a float
        System.out.printf("Average grade for the subject: %.2f\n", average); 
    }
    
    /**
     * Searches for a student and displays their grade
     */
    public void searchStudent() {
        
        //checks if the name array is empty
        if (studentNames.isEmpty()) {
            System.out.println("No students in the record."); //Diplays message if true
            return; //Returns control to the code that called the method
        }
        
        System.out.print("Enter student's name to search: "); //Promts user for input
        String name = scanner.nextLine().trim(); //stores input from the whole line and removes  white spaces
        
        boolean found = false; //used to track if student was found
        
        //Checks is the array string at position i equals the user input ignorning capital letters in both
        for (int i = 0; i < studentNames.size(); i++) {
         //It checks every index until the i position val. equals String name   
           
            if (studentNames.get(i).equalsIgnoreCase(name)) {
                System.out.println(name + "'s grade: " + studentGrades.get(i));
                found = true;
                break; //Stops searching after the student is found
            }
        }
        
        //Displays a message if the student is not found
        if (!found) {
            System.out.println("Student not found in the records.");
        }
    }
}
