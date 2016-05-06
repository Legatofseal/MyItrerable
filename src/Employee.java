import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Legat on 29.04.2016.
 */
public class Employee {
    private int salary;
    private int age;
    private String name;
    private String surname;
    private SecureRandom random = new SecureRandom();
    public Employee() {
        this.age = ((int)(Math.random()*50+18));
        this.name=new BigInteger(130, random).toString(32);
        this.salary=((int)(Math.random()*1000+18));
        this.surname=new BigInteger(130, random).toString(32);
    }

    public Employee(String name) {
        this.name = name;
        this.age = ((int)(Math.random()*50+18));

        this.salary=((int)(Math.random()*1000+18));
        this.surname=new BigInteger(130, random).toString(32);
    }

    public Employee(Employee employee) {

    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getSurname() {
        return surname;
    }

    public Employee(int age, String name, int salary, String surname) {
        this.age = age;
        this.name = name;

        this.salary = salary;
        this.surname = surname;
    }
    @Override
    public String toString (){
        return "Name: "+name+" Surname: "+surname+" Age: "+age+" Salary: "+salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals (Object object){
        Employee emp = (Employee)object;
        if (this.name.equals(emp.getName())){
            return true;
        }
        else {
            return false;
        }

    }


}
