import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {
    ArrayList<Employee> empList;
    ArrayList<Employee> otherList;
    
    
    public MainConsole() throws FileNotFoundException  {
        empList = new ArrayList<>();
        otherList = new ArrayList<>();
        beolvas();
        feladat02();
        feladat03();
    }
    
    public void beolvas() throws FileNotFoundException{
        File file = new File("dolgozo.csv" );
        Scanner scan = new Scanner(file, "utf-8");
        String firstLine = scan.nextLine(); //első sor eltárolása 
        

        while(scan.hasNext()){
            String line = scan.nextLine(); //line változóban tároljuk az adatokat
            String [] lineArray = line.split(",");
            // System.out.println(line);

            Employee emp = new Employee(
                Integer.parseInt(lineArray[0]),
                lineArray[1],
                lineArray[2],
                Double.parseDouble(lineArray[3]),
                LocalDate.parse(lineArray[4])
                );
                empList.add(emp);
        }
       // csinálunk egy olyan osztályt  ami soronként kezeli az adatokat, Employee.java
    }
    public void feladat02(){
        //tegyük másik listába
        System.out.println("Feladat 2");
        for(Employee emp : this.empList){
        System.out.println(emp.name);
        if(emp.birth.getYear()< 2003){
            this.otherList.add(emp);
        }
        }
    }
    public void feladat03() throws FileNotFoundException{
        //Írjuk másik állományba
        System.out.println("feladat03");
        PrintWriter pw = new PrintWriter("koraiak.csv");
        // pw.append("aaa");
        for(Employee emp: this.otherList){
            pw.append(emp.id.toString());
            pw.append(",");
            pw.append(emp.name);
            pw.append(",");
            pw.append(emp.city);
            pw.append(",");
            pw.append(emp.salary.toString());
            pw.append(",");
            pw.append(emp.birth.toString());
            pw.append("\n");

        }
        pw.close();
    }
}
