public class TestThrow{

    static void checkVotingEligibility(int age, String studentName) {

        if (age < 18) {
            throw new ArithmeticException(
                studentName + " is not eligible to vote (Age must be 18)"
            );
        } else {
            System.out.println(studentName + " is eligible to vote!");
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println("Checking registration for Vivan...");
            checkVotingEligibility(15, "Vivan");
        } catch (ArithmeticException e) {
            System.out.println("Caught Illegal Exception: " + e.getMessage());
        }
    }
}
