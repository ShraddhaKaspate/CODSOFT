import java.util.Scanner;

class Gradecal {
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of subjects");
        int n = sc.nextInt();
        int sum = 0;
        float avg;
        String grade;
        int marks[] = new int[n];
        
        System.out.println("Enter marks of subjects");
        for (int i = 0; i < n; i++)
         {
            System.out.println("Enter marks of subject " + (i + 1));
            marks[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++)
       {
            sum = sum + marks[i];
        }
        
        avg = sum / (float) n;
        
        if (avg >= 90 && avg <= 100)
         {
            grade = "A+";
        } else if (avg >= 80 && avg < 90) 
        {
            grade = "A";
        } else if (avg >= 70 && avg < 80)
         {
            grade = "B";
        } else if (avg >= 60 && avg < 70)
         {
            grade = "C";
        } else if (avg >= 50 && avg < 60)
         {
            grade = "D";
        } else if (avg >= 40 && avg < 50)
         {
            grade = "E";
        } else 
        {
            grade = "Fail";
        }

        System.out.printf("Total Marks: %d\nAverage Marks: %.2f\nGrade: %s", sum, avg, grade);
    }
}
