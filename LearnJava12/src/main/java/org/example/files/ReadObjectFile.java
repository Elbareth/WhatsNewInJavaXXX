package org.example.files;

import org.example.helper.*;

import java.io.*;

public class ReadObjectFile {
    public void readFile()
    {
        try {
            InputStream inputStream = new FileInputStream("pliczek.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Employee employee = (Employee) objectInputStream.readObject();
            EmployeeExt employeeExt = (EmployeeExt) objectInputStream.readObject();
            TinySingletonObject tinySingletonObject = (TinySingletonObject) objectInputStream.readObject();
            System.out.println(employee);
            System.out.println(employeeExt);
            System.out.println(tinySingletonObject);
            TinySingletonObject tinySingletonObject2 = TinySingletonObject.getInstance();
            Boolean theSameObject = tinySingletonObject == tinySingletonObject2;
            System.out.println("This objects are the same = "+theSameObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile()
    {
        try {
            File file = new File("pliczek.ser") ;
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            Language language = new Language("Javka <3", 5);
            Employee employee = new Employee("Kitku Kitten", "Mały myszkowy zespół",language);
            stream.writeObject(employee);
            LanguageExt languageExt = new LanguageExt("Javka <3", 5);
            EmployeeExt employeeExt = new EmployeeExt("Kitku Kitten", "Mały myszkowy zespół",languageExt);
            stream.writeObject(employeeExt);
            TinySingletonObject tinySingletonObject = TinySingletonObject.getInstance();
            stream.writeObject(tinySingletonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
