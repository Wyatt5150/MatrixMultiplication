import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

class FileReader
{
    private int size = 0;
    private String[] contents;
    private File file;
    
    public FileReader(String input)
    {
        file = new File(input);
        readSize();
        readFile();
    }

    //Returns Number Of Lines In File
    public int size()
    {
        return size;
    }
    //Returns File Content In String Arrays
    public String[] getContents()
    {
        return contents;
    }

    //Determines Number Of Lines In File
    //Could have combined ReadSize() and ReadFile() if using ArrayList, 
    //but wanted to use built in String Array instead to minimize imports
    private void readSize()
    {
        try
        {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                scan.nextLine();
                size++;
            }
            scan.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("Error with opening file.\nPlease check file name and try again.");
            e.printStackTrace();
        }
    }
    //Reads File And Stores Lines In Array Of Strings
    private void readFile()
    {
        contents = new String[size];
        try
        {
            Scanner scan = new Scanner(file);
            for(int i = 0; i < size; i++)
            {
                contents[i] = scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}