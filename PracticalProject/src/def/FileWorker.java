package def;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileWorker {
	
	public static File exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	    else
	    {
	    	return file;
	    }
	}

	public static File write(String fileName, String text) {
	    // ���������� ����
	    File file = new File(fileName);
	 
	    try {
	        // ���������, ��� ���� ���� �� ����������, �� ������� ���
	        if(!file.exists()) {
	            file.createNewFile();
	        }
	 
	        //PrintWriter ��������� ����������� ������ � ����
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //���������� ����� � ����
	            out.print(text);
	            out.close();
	            return file;
	        } 
	        finally {
	            //����� ���� �� ������ ������� ����
	            //����� ���� �� ���������
	            out.close();
	        }
	    } 
	    catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}

	public static String read(String fileName) throws FileNotFoundException {
	    //���� ����. ������ ��� ���������� ������
	    StringBuilder sb = new StringBuilder();
	 
	    File file = exists(fileName);
	 
	    try {
	        //������ ��� ������ ����� � �����
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            //� ����� ��������� ��������� ����
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } 
	        finally {
	            //����� �� �������� ������� ����
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    //���������� ���������� ����� � �����
	    return sb.toString();
	}

	public static void delete(String nameFile) throws FileNotFoundException {
	    exists(nameFile);
	    new File(nameFile).delete();
	}
}



// � main 
/*import java.io.FileNotFoundException;

public class Main {

	//private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
	//private static String fileName = "C:/Users/User/Workspace/Work1/a.txt";
	
	public static void main(String[] args) throws FileNotFoundException{
	
		//������ �����
		//String textFromFile = FileWorker.read(fileName);
		//System.out.println(textFromFile);
			
		//������ � ����
		//FileWorker.write(fileName, text);	
	}
}*/
