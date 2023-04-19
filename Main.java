import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        RunTimer timer = new RunTimer();
        timer.start();

        FileToMatrices converter = new FileToMatrices(new FileReader("Matrices.txt"));
        ArrayList<Matrix> matrices = converter.getMatrices();
        /* 
        for(Matrix m: matrices)
        {
            m.print();
            System.out.println();
        }//*/ 

        printEquation(matrices.get(0), matrices.get(1), matrices.get(2));

        timer.stop();
    }

    private static void printEquation(Matrix m1, Matrix m2, Matrix m3)
    {
        int mid = m1.height()/2;
        int r =0;
        for(r = 0; r < mid; r++)
        {
            printLine(m1,m2,m3,r,"   ");
        }
        
        printLine(m1,m2,m3,r," = ");
        r++;

        while(r<m1.height()||r<m2.height())
        {
            printLine(m1,m2,m3,r,"   ");
            r++;
        }
    }
    private static void printLine(Matrix m1, Matrix m2, Matrix m3, int r, String eq)
    {
        m1.printRow(r);
        m2.printRow(r);
        System.out.print(eq);
        m3.printRow(r);
        System.out.println();
    }
}