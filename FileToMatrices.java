import java.util.*;

public class FileToMatrices 
{
    public static ArrayList<Matrix> getMatrices(FileReader file)
    {
        ArrayList<Matrix> matrices = new ArrayList<Matrix>();
        Matrix m = new Matrix();
        for(String l: file.getContents())
        {
            if (l.isEmpty() && !m.isEmpty())
            {
                matrices.add(m);
                m = new Matrix();
            }
            else
                m.addRow(l);
        }
        if(!m.isEmpty())
            matrices.add(m);

        return matrices;
    }
}