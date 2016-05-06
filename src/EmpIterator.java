import java.util.Iterator;

/**
 * Created by Legat on 05.05.2016.
 */
public class EmpIterator implements Iterator{
    private int index=-1;
    private Company company;

    public EmpIterator(Company company) {
        this.company = company;
    }



    @Override
    public boolean hasNext() {
        if (company.getCurrentSize()-1<=index){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Object next() {
        index++;
        return company.getArraryEmp()[index];

    }

    @Override
    public void remove() {
    company.removeElementByIndex(index);
        index--;
    }
}
