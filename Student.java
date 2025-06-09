public class Student {
    String name;
    int rollNumber;
    int[] marks;
    double percentage;
    String grade;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculatePercentage();
        calculateGrade();
    }

    private void calculatePercentage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        this.percentage = total / (double) marks.length;
    }

    private void calculateGrade() {
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else grade = "F";
    }

    public void displayDetails() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll No.   : " + rollNumber);
        System.out.printf("Percentage : %.2f%%\n", percentage);
        System.out.println("Grade      : " + grade);
    }

    public void saveToFile() {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("output/student_report.txt");
            writer.write("--- Student Report ---\n");
            writer.write("Name        : " + name + "\n");
            writer.write("Roll Number : " + rollNumber + "\n");
            writer.write("Percentage  : " + String.format("%.2f", percentage) + "%\n");
            writer.write("Grade       : " + grade + "\n");
            writer.close();
            System.out.println("Report saved to output/student_report.txt");
        } catch (Exception e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }
}
