import java.util.*;

public class FileToMatrices 
{
    FileReader file;
    public FileToMatrices(FileReader f)
    {
        file=f;
    }
    public ArrayList<Matrix> getMatrices()
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