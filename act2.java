import java.util.Scanner;

public class act2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("Enter two numbers for division:");
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = x/y;
            System.out.println(x + "/"+ y+"="+ z);
            
        }
        catch (ArithmeticException ex){
            System.out.println("Catch block");
            System.out.print(ex.toString());
        }
        finally{
            System.out.println("Finally block");
            System.out.println("Application designed and developed by Ritvik");
            sc.close();
        }
        System.out.println("Done");
    }
    
}