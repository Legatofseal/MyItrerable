import java.util.Comparator;

/**
 * Created by Legat on 07.05.2016.
 */
public class EmpComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return (o1.getSurname()+o1.getName()).compareToIgnoreCase(o2.getSurname()+o2.getName());
    }
}
