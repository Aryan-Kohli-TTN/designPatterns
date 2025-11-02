import java.util.ArrayList;
import java.util.List;

interface EmployeeComponent{
    void showDetails();
}
class Employee implements EmployeeComponent{
    String name = null;
    double salary = 10000;
    public Employee(String name,double salary) {
        this.name=name;
        this.salary=salary;
    }

    @Override
    public void showDetails() {
        System.out.println("name : "+name +"salary: "+ salary);
    }
}
class Manager implements EmployeeComponent{
    String name = null;
    double salary = 10000;
    List<EmployeeComponent> employeeComponents;
    public Manager(String name,double salary) {
        this.name=name;
        this.salary=salary;
        this.employeeComponents=new ArrayList<>();
    }
    public Manager(String name,double salary,List<EmployeeComponent> employeeComponents) {
        this.name=name;
        this.salary=salary;
        this.employeeComponents=employeeComponents;
    }
    public void addEmployee(EmployeeComponent e){
        employeeComponents.add(e);
    }

    @Override
    public void showDetails() {
        System.out.println("name : "+name +"salary: "+ salary+" Employees under me : "+employeeComponents.size());
        for (EmployeeComponent e : employeeComponents) {
            e.showDetails();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        EmployeeComponent emp1 = new Employee("Aryan", 30000);
        EmployeeComponent emp2 = new Employee("Ravi", 25000);
        EmployeeComponent emp3 = new Employee("Neha", 27000);

        Manager manager1 = new Manager("Rajesh", 60000);
        manager1.addEmployee(emp1);
        manager1.addEmployee(emp2);

        Manager generalManager = new Manager("Vikram", 100000);
        generalManager.addEmployee(manager1);
        generalManager.addEmployee(emp3);

        generalManager.showDetails();
    }
}