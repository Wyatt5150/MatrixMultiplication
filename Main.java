import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        RunTimer timer = new RunTimer();

        // load files into array of matrices
        ArrayList<Matrix> matrices = FileToMatrices.getMatrices(new FileReader("Matrices.txt"));
        //ArrayList<Matrix> matrices = FileToMatrices.getMatrices(new FileReader("Massive_Input.txt"));
        //printMatrices(matrices);
        
        //* 
        timer.start();
        run(matrices, new BasicMultiply());
        timer.stop();// */
        //*  
        timer.start();
        run(matrices, new RowMultiply(12));
        timer.stop();// */
        //* 
        timer.start();
        run(matrices, new CellMultiply(12));
        timer.stop();// */
         //* 
         timer.start();
         run(matrices, new BadCellMultiply(12));
         timer.stop();// */
    }

    private static void run(ArrayList<Matrix> matrices, MatrixMultiply mult)
    {
        int i = 0;
        // process matrices in sets of 2
        while(i+1 < matrices.size())
        {
            // run things
            Matrix sol = mult.multiply(matrices.get(i),matrices.get(i+1));
            
            // print equation
            if(sol != null) printEquation(matrices.get(i), matrices.get(i+1), sol);

            System.out.println();
            i+=2;
        }
    }

    private static void printMatrices(ArrayList<Matrix> matrices)
    {
        for(Matrix m: matrices)
        {
            m.print();
            System.out.println();
        }
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