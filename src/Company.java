import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Legat on 29.04.2016.
 */
public class Company implements Iterable {
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

    public Employee[] getArraryEmp() {
        return arraryEmp;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public boolean removeElementByIndex(int index) {
        if (index < 0 || index > currentSize - 1) {

            return false;
        } else if (index==currentSize-1) {

            arraryEmp[index]=null;
            currentSize--;
            return true;

        }
        else {
            for (int i = index; i < currentSize - 1; i++) {
                arraryEmp[i] = arraryEmp[i + 1];
            }
            arraryEmp[currentSize - 1] = null;
            currentSize--;
            return true;
        }


    }

    public boolean removeFirstElementByPatern(Object emp) {
        int number = -1;
        for (int i = 0; i < currentSize; i++) {
            if (arraryEmp[i].equals(emp)) {
                number = i;
                break;

            }

        }
        if (number==-1){
            return false;
        }
        else {
            removeElementByIndex(number);
            return true;
        }


    }

    public boolean removeAllElemenByPatern (Object emp){
        int number = -1;
        for (int i = 0; i < currentSize; i++) {
            if (arraryEmp[i].equals(emp)) {
                number = i;
                removeElementByIndex(number);

            }

        }
        removeFirstElementByPatern(emp);
        if (number==-1){
            return false;
        }
        else {
            return true;
        }
    }


}
