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
	    // Определяем файл
	    File file = new File(fileName);
	 
	    try {
	        // Проверяем, что если файл не существует, то создаем его
	        if(!file.exists()) {
	            file.createNewFile();
	        }
	 
	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //Записываем текст в файл
	            out.print(text);
	            out.close();
	            return file;
	        } 
	        finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишется
	            out.close();
	        }
	    } 
	    catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}

	public static String read(String fileName) throws FileNotFoundException {
	    //Этот спец. объект для построения строки
	    StringBuilder sb = new StringBuilder();
	 
	    File file = exists(fileName);
	 
	    try {
	        //Объект для чтения файла в буфер
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            //В цикле построчно считываем файл
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } 
	        finally {
	            //Также не забываем закрыть файл
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    //Возвращаем полученный текст с файла
	    return sb.toString();
	}

	public static void delete(String nameFile) throws FileNotFoundException {
	    exists(nameFile);
	    new File(nameFile).delete();
	}
}



// В main 
/*import java.io.FileNotFoundException;

public class Main {

	//private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
	//private static String fileName = "C:/Users/User/Workspace/Work1/a.txt";
	
	public static void main(String[] args) throws FileNotFoundException{
	
		//Чтение файла
		//String textFromFile = FileWorker.read(fileName);
		//System.out.println(textFromFile);
			
		//Запись в файл
		//FileWorker.write(fileName, text);	
	}
}*/
