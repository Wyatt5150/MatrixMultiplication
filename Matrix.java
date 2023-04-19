import java.util.*;
public class Matrix 
{
    private ArrayList<ArrayList<Integer>> matrix;
    ArrayList<Integer> mostDigits;

    public Matrix()
    {
        matrix = new ArrayList<ArrayList<Integer>>();
        mostDigits = new ArrayList<Integer>();
    }

    public int height()      { return matrix.size(); }
    public int width()       { return matrix.get(0).size();}
    public int get(int x,int y) { return matrix.get(y).get(x); }
    public boolean isEmpty()    { return matrix.isEmpty(); }

    // adds row to the bottom of matrix
    public void addRow(String row)
    {
        if(height()==0)
        {
            addFirstRow(row);
            return;
        }

        matrix.add(new ArrayList<Integer>());
        Scanner line = new Scanner(row);
        int col = 0;
        while(line.hasNext())
        {
            int num =line.nextInt();

            if(Math.pow(10,mostDigits.get(col)) <= num)
                mostDigits.set(col,numOfDig(num));

            matrix.get(height()-1).add(num);
            col++;
        }
        line.close();
    }
    public void print()
    {
        for(int i = 0; i<height();i++)
        {
            printRow(i);
            System.out.println();
        }
    }
    public void printRow(int r)
    {
        if(r >= height())
        {
            String spaces = "";
            int total = 0;
            for(int num : mostDigits)
                total += num+1;
            total +=3;
            while(total>0)
            {
                spaces += " ";
                total--;
            }
            System.out.print(spaces);
        }
        else
        {
            System.out.print("| ");
            ArrayList<Integer> row = matrix.get(r);
            for(int col =0; col < row.size();col++)
            {
                System.out.print(normalizedNumber(row.get(col),col)+ " ");
            }
            System.out.print("|");
        }
    }

    private void addFirstRow(String row)
    {
        matrix.add(new ArrayList<Integer>());
        Scanner line = new Scanner(row);
        while(line.hasNext())
        {
            int num =line.nextInt();
            mostDigits.add(numOfDig(num));

            matrix.get(height()-1).add(num);
        }
        line.close();
    }
    private String normalizedNumber(int num, int col)
    {
        String s = ""+num;
        for(int dig = numOfDig(num); dig < mostDigits.get(col); dig++)
            s = " " + s;
        return s;
    }
    private int numOfDig(int num)
    {
        if(num == 0)
            return 1;
        int dig = (int)Math.log10(Math.abs(num))+1;
        if(num<0)
            dig++;
        return dig;
    }
}
