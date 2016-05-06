import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       // MyArray myArray = new MyArray(10);
       // myArray.generateArr(100);
        //ArrPredicate arrPredicate = new ArrPredicate();
       //System.out.println(ArrPredicate.filterInteger(myArray.arrToList(),ArrPredicate.lessThan(50).negate()));
       /// System.out.println("");
        //System.out.println(ArrPredicate.filterInteger(myArray.arrToList(),ArrPredicate.between(40,60)));
        Company company = new Company();
        Employee employee1 = new Employee(20, "Test", 300, "Testov");
        company.addEmployee(employee1);
        company.addEmployee(new Employee());
        company.addEmployee(new Employee());
        company.addEmployee(new Employee());
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
        System.out.println();
        System.out.println(empPredicate.filterEmp(company.arrToList(),empPredicate.ageLessThan(20)));

        System.out.println();
        Object object;
        Iterator companyIterator = company.iterator();
        while (companyIterator.hasNext()){
            object=companyIterator.next();
            System.out.println(object.toString());

           if (object.equals(employee1)){
                companyIterator.remove();
            }
        }//
        System.out.println();
       company.printAllEmployees();


    }
}
