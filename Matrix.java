import java.util.*;
public class Matrix 
{
    private ArrayList<ArrayList<Integer>> matrix;
    int mostDigits=1;

    public Matrix()
    {
        matrix = new ArrayList<ArrayList<Integer>>();
    }

    public int getHeight()      { return matrix.size(); }
    public int getWidth()       { return matrix.get(0).size();}
    public int get(int x,int y) { return matrix.get(y).get(x); }
    public boolean isEmpty()    { return matrix.isEmpty(); }

    // adds row to the bottom of matrix
    public void addRow(String row)
    {
        matrix.add(new ArrayList<Integer>());
        Scanner line = new Scanner(row);
        while(line.hasNext())
        {
            int num =line.nextInt();
            if(Math.pow(10,mostDigits) < num)
                mostDigits = (int)Math.log10(num)+1;
            matrix.get(getHeight()-1).add(num);
        }
        line.close();
    }
    public void print()
    {
        for(int i = 0; i<getHeight();i++)
        {
            printRow(i);
            System.out.println();
        }
    }
    public void printRow(int r)
    {
        if(r >= getHeight())
        {
            String spaces = "";
            //System.out.println(4 + " " + getWidth() + " " + (mostDigits+1));
            for(int k = 3+getWidth()*(mostDigits+1); k>0; k--)
            {
                spaces += " ";
            }
            System.out.print(spaces);
        }
        else
        {
            System.out.print("| ");
            for(Integer i : matrix.get(r))
            {
                System.out.print(normalizedNumber(i)+ " ");
            }
            System.out.print("|");
        }
    }

    private String normalizedNumber(int num)
    {
        String s = ""+num;
        for(int dig = (int)Math.log10(num)+1; dig < mostDigits; dig++)
            s = " " + s;
        return s;
    }
}
