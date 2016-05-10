import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Company company = new Company();
        Employee employee1 = new Employee(20, "Test", 300, "Testov");
        company.addEmployee(employee1);
        company.addEmployee(new Employee());
       // company.addEmployee(new Employee());
       // company.addEmployee(new Employee());
        Employee employee2 = new Employee(25, "Test1", 400, "Testov1");
        company.addEmployeeByIndex(employee2,2);
       //company.printAllEmployees();

        //company.removeElementByIndex(2);

        //company.removeElementByIndex(4);
       // company.printAllEmployees();

      //  company.removeFirstElementByPatern(employee2);
      //  company.printAllEmployees();


        company.addEmployee(employee1);
        company.addEmployee(employee1);

        EmpPredicate empPredicate = new EmpPredicate();

        ArrayList ar = company.ageLessThan(30,empPredicate);
        for(Object emp:ar){
            System.out.println(emp.toString());//Полиморфизм в действии, сучечки!
        }

        //comp.printAllEmployees();


    }
}
