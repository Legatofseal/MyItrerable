import java.util.*;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;

/**
 * Created by Legat on 29.04.2016.
 */
public class Company extends ArrayList implements Iterable, Collection {
    private Employee[] arraryEmp;
    private int companySize = 10;
    private int currentSize = 0;

    public Company() {
        this.arraryEmp = new Employee[companySize];
    }

    @Override
    public Iterator iterator() {
        return new EmpIterator(this);
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    private boolean isFull() {
        return currentSize == companySize;
    }

    public void createNewArray() {
        this.companySize = companySize * 2;
        Employee[] tmpArray = new Employee[companySize];
        for (int i = 0; i < companySize / 2; i++) {
            tmpArray[i] = arraryEmp[i];
        }
        arraryEmp = tmpArray;
    }

    public void addEmployee(Employee employee) {
        if (isFull()) {
            createNewArray();
        }
        arraryEmp[currentSize] = employee;
        currentSize++;
    }

    public void printAllEmployees() {

        for (int i = 0; i < currentSize; i++) {
            System.out.println(arraryEmp[i].toString());


        }
        System.out.println("");
    }

    public void addEmployeeByIndex(Employee emp, int index) {
        if (index < 0 || index > currentSize) {
            throw new ArrayIndexOutOfBoundsException("Out of Bound");
        }
        if (isFull()) {
            createNewArray();
        }
        Employee[] tmpArr = arraryEmp;
        for (int i = index; i < currentSize; i++) {
            tmpArr[i + 1] = arraryEmp[i];
        }
        tmpArr[index] = emp;
        arraryEmp = tmpArr;

        // arraryEmp[currentSize] = employee;
        currentSize++;
    }

    Employee[] getArraryEmp() {
        return arraryEmp;
    }

    public int getCurrentSize() {
        return currentSize;
    }


    public boolean removeElementByIndex(int index) {
        if (index < 0 || index > currentSize - 1) {

            return false;
        } else if (index == currentSize - 1) {

            arraryEmp[index] = null;
            currentSize--;
            return true;

        } else {
            for (int i = index; i < currentSize - 1; i++) {
                arraryEmp[i] = arraryEmp[i + 1];
            }
            arraryEmp[currentSize - 1] = null;
            currentSize--;
            return true;
        }


    }

    public boolean removeFirstElementByPatern(Object emp) {
        // int number = -1;
        for (int i = 0; i < currentSize; i++) {
            if (arraryEmp[i].equals(emp)) {
                removeElementByIndex(i);
                return true;

            }

        }
        return false;
    }

    public boolean removeAllElemenByPatern(Object emp) {
        boolean check = false;
        for (int i = 0; i < currentSize; i++) {
            if (arraryEmp[i].equals(emp)) {
                check = true;
                removeElementByIndex(i);

            }

        }
        // removeFirstElementByPatern(emp);
        return check;
    }

    public ArrayList<Employee> arrToList() {
        ArrayList<Employee> arraylist = new ArrayList<Employee>(asList(arraryEmp));
        return arraylist;
    }

    public ArrayList<Employee> ageLessThan(int x, EmpPredicate predicate) {

       // ArrayList<Employee> filtedByNull = arrToList().stream().filter(p -> p != null).collect(Collectors.toCollection(ArrayList<Employee>::new));


       // ArrayList<Employee> filtered = filtedByNull.stream().filter(predicate.ageLessThan(x)).collect(Collectors.toCollection(ArrayList<Employee>::new));
        ArrayList<Employee> filtered = arrToList().stream().filter(p -> p != null).
                filter(predicate.ageLessThan(x)).collect(Collectors.toCollection(ArrayList<Employee>::new));
        return filtered;
    }
public void sort (){

}



}
