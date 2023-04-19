public abstract class MatrixMultiply 
{
    // revieve 2 matrices, return product
    abstract public static Matrix multiply(Matrix m1, Matrix m2);
    
    // revieve 2 matrices and which row of m1 and which col of m2 is getting calculated
    public static int calc(Matrix m1, Matrix m2, int r, int c)
    {
        int sol = 0;
        for(int k = 0; k < m1.width (); k++)
        {
            sol += m1.get(k,r) * m2.get(c,k);
        }
        return sol;
    }

    // return if m1 and m2 can be multipled together
    public static boolean isValid(Matrix m1, Matrix m2)
    {
        return m1.width()==m2.height();
    }

    public static void invalidSize(Matrix m1, Matrix m2)
    {
        System.out.println("Invalid Matrix Sizes.");
        System.out.println("Matrix 1 Width Must Match Matrix 2 Height.");
        System.out.println("Matrix 1 Width: " + m1.width());
        System.out.println("Matrix 2 Height: " + m2.height());
    }
}
