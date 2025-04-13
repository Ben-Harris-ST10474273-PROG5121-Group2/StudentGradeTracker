
# Student Grade Tracker

A Java application for teachers to manage and track student grades.

## Features
- **Add Students**: Add new students with their grades
- **View Grades**: Display all students and their corresponding grades
- **Calculate Average**: Compute the class average for the subject
- **Search Function**: Find specific student grades quickly
- **Input Validation**: Ensures only valid grades (0-100) are accepted

## Requirements
- Java Development Kit (JDK) 8 or later
- Any Java-compatible IDE or command line

## Getting Started

### Installation
```bash
git clone https://github.com/yourusername/student-grade-tracker.git
cd student-grade-tracker
Running the Program

# Compile
javac StudentGradeTracker.java

# Execute
java StudentGradeTracker
Usage
After launching the program, you'll see an interactive menu:


1. Add a new student and grade
2. Display list of students and their grades
3. Calculate average grade for the subject
4. Search for a student and display their grade
5. Exit
Key Operations:
Adding Students:

Enter student name

Input grade (0-100)

Confirmation message appears

Viewing Grades:

Displays formatted list of all entries

Calculating Average:

Automatically computes from current data

Searching:

Case-sensitive name search

Returns grade or "not found"

Code Architecture
Component	Purpose
ArrayList	Dynamic storage of student-grade pairs
Scanner	Handles all user input
Validation	Ensures grade integrity (0-100 range)
Modular Methods	Separated logic for each function

Example Session
Welcome to the Student Grade Tracker!

Menu:
1. Add student
2. View grades
3. Calculate average
4. Search student
5. Exit

Choice: 1
Enter name: Maria
Enter Maria's grade: 92
Maria added successfully!

Choice: 4
Search name: Maria
Maria's grade: 92
Important Notes
Session Storage: Data persists only during current runtime

Grade Requirements: Must be integers between 0-100

Name Sensitivity: Searches are case-sensitive ("alice" ≠ "Alice")
