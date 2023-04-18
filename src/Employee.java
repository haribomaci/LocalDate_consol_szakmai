import java.time.LocalDate;

public class Employee {
    Integer id;
    String name;
    String city;
    Double salary;
    LocalDate birth;

    //inicializálunk mindent ctrl. generate constructor

    public Employee(int id, String name, String city, Double salary, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.birth = birth;
    }


    
}
