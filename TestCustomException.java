// Step 1: Create Custom Exception Class
class InvalidStudentMarksException extends Exception {
    // Constructor passing message to parent Exception class
    public InvalidStudentMarksException(String message) {
        super(message);
    }
}

// Step 2: Use Custom Exception in Business Logic
public class TestCustomException {
    static void validateVivaanMarks(double marks) throws InvalidStudentMarksException {
        if (marks < 0.0 || marks > 100.0) {
            throw new InvalidStudentMarksException("Marks must be between 0 and 100! Input was: " + marks);
        } else {
            System.out.println("Vivaan's Marks Validated Successfully: " + marks);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Validating Exam Score for Vivaan...");
            validateVivaanMarks(105.0); // Invalid marks trigger custom exception
        } catch (InvalidStudentMarksException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}
