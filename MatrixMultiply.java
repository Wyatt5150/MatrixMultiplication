public class MatrixMultiply 
{
    // revieve 2 matrices, return product
    //abstract public Matrix multiply(Matrix m1, Matrix m2);
    
    // revieve 2 matrices and which row of m1 and which col of m2 is getting calculated
    public static int calc(Matrix m1, Matrix m2, int r, int c)
    {
        int sol = 0;
        for(int k = 0; k < m1.getWidth (); k++)
        {
            System.out.println(m1.get(r,k) +" "+ m2.get(k,c));
            sol += m1.get(r,k) * m2.get(k,c);
        }
        return sol;
    }

    // return if m1 and m2 can be multipled together
    public static boolean isValid(Matrix m1, Matrix m2)
    {
        return m1.getWidth()==m2.getHeight();
    }

    public static void invalidSize(Matrix m1, Matrix m2)
    {
        System.out.println("Invalid Matrix Sizes.");
        System.out.println("Matrix 1 Width Must Match Matrix 2 Height.");
        System.out.println("Matrix 1 Width: " + m1.getWidth());
        System.out.println("Matrix 2 Height: " + m2.getHeight());
    }
}
