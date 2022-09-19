import java.util.Scanner;

// MISSING MAIN CLASS

public class DivSales
{
    private static double corpSales;
    double salesArray[] = new double[4];


    public double setSales(double sale1, double sale2, double sale3, double sale4)
    {
        salesArray[0] = sale1;
        salesArray[1] = sale2;
        salesArray[2] = sale3;
        salesArray[3] = sale4;
        corpSales += (sale1+sale2+sale3+sale4);
        for(int i = 0; i<salesArray.length; i++)
        {
            if(salesArray[i] <= 0)
            {
                System.out.println("SetSales: Cannot enter 0 sales.");
            }
        }
        return corpSales;
    }


    public double divSales(int index)
    {
        if(index > 3 || index < 0)
        {
            System.out.println("Index for sales not valid!");
        }
        return salesArray[index];
    }

    public static void main(String args[])
    {
        DivSales[] divisions = new DivSales[3];
        divisions[0] = new DivSales();
        divisions[1] = new DivSales();
        divisions[2] = new DivSales();

        Scanner s = new Scanner(System.in);
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Please enter the four quarterly sales for Div " + (i+1) + " separated by space:");
            String[] strArray = s.nextLine().split(" ");
            divisions[i].setSales(Double.parseDouble(strArray[0]), Double.parseDouble(strArray[1]), Double.parseDouble(strArray[2]), Double.parseDouble(strArray[3]));
            if(divisions[i].salesArray[i] <= 0)
            {
                System.out.println("Sales cannot be 0.");
                break;
            }
        }
        s.close();

        // printing sales
        System.out.println("div  q1    q2    q3    q4");
        for(int i = 0; i < divisions.length; i++)
        {
            System.out.print((i+1) + "   ");
            for(int j = 0; j < divisions[i].salesArray.length; j++)
            {
                System.out.print(divisions[i].divSales(j) + "   ");
            }
            System.out.println();
        }

        System.out.println("Sales for the corporate year: " + corpSales);

    }
}
