import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Legat on 06.05.2016.
 */
public class EmpPredicate {
   public Predicate<Employee> ageLessThan(int x){
       return empl -> empl.getAge()<x;
   }
    public Predicate<Employee> ageMoreThan(int x){
        return employee -> employee.getAge()>x;
    }
    //public Predicate<Employee>
    public Predicate<Employee> ageBetween (int x, int y){
        return employee -> employee.getAge()<x||employee.getAge()>y;
    }
    public Predicate<Employee> nameEq (String string){
        return employee -> employee.getName()==string;
    }

    public static Predicate<Integer> between (int x, int y){
        return p->p>x&&p<y;
    }
    public static List<Employee> filterEmp (ArrayList<Employee> intList, Predicate<Employee> predicate) {
        return intList.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }//
}
