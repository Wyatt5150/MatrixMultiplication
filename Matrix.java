import java.util.*;
public class Matrix 
{
    private ArrayList<ArrayList<Integer>> matrix;

    public Matrix()
    {
        matrix = new ArrayList<ArrayList<Integer>>();
    }

    public int getHeight()      { return matrix.size(); }
    public int getWidth()       { return matrix.get(0).size();}
    public int get(int x,int y) { return matrix.get(y).get(x); }
    public boolean isEmpty()    { return matrix.isEmpty(); }

    public void addRow(String row)
    {
        matrix.add(new ArrayList<Integer>());
        Scanner line = new Scanner(row);
        while(line.hasNext())
        {
            matrix.get(getHeight()-1).add(line.nextInt());
        }
    }
    public void print()
    {
        for(ArrayList<Integer> line : matrix )
        {
            for(Integer i : line)
            {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
}
