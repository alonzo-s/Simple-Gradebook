public class Assignment3
{

    public static void main(String[] args)
    {
        // constant variables
        final int MIN_VAL = 0;
        final int MAX_VAL = 100;
        
        // declare variables
        double score;
        char letterGrade;
        
        // call to methods
        score = promptForInt("Welcome to Simple Gradebook", 
                MIN_VAL, MAX_VAL);
        letterGrade = convertToLetter(score);
        
        // display data
        System.out.printf("The average score is %.2f which equates to %C.\n", 
                score, letterGrade);
    }
    
    // Method to input grades and find the average grade.
    public static double promptForInt(String message, int minVal, int maxVal)
    {
        // declare variables
        int testGrade;
        double sum = 0;
        double totalScore = 0;
        int counter = 1;        // used to display student #
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println(message);
        
        // do-while loop used to at least run once
        do
        {
            System.out.printf("Enter the grade for student #%d or (-1 to quit):"
                    + " ", counter);
            testGrade = Integer.parseInt(keyboard.nextLine());
            while ((testGrade < minVal || testGrade > maxVal) && 
                    testGrade != -1)
            {
                System.err.println("Invalid Input. Acceptable range is between "
                        + "0 and 100.");
                System.out.printf("Enter the grade for student #%d or (-1 to "
                        + "quit): ", counter);
                testGrade = Integer.parseInt(keyboard.nextLine());
            }
            // used to increase counter, calc sum, calc average
            if (testGrade != -1)
            {
                counter++;
                sum = sum + testGrade;
                // subtract 1 to not divide by total # of inputs used, but
                // only amount of score entered
                totalScore = sum / (counter-1);
            }
            
        }while (testGrade != -1);
        
        return totalScore;
    }
    
    // Method to convert the average score into a letter grade.
    public static char convertToLetter(double score)
    {
        // declare variables
        char letter;
       
        // "range problem" sort if-else-if statements in ascending order.
        if (score < 60)
        {
            letter = 'F';
        }
        else if (score < 70)
        {
            letter = 'D';
        }
        else if (score < 80)
        {
            letter = 'C';
        }
        else if (score < 90)
        {
            letter = 'B';
        }
        else 
        {
            letter = 'A';
        }

        return letter;
    }
    
}
