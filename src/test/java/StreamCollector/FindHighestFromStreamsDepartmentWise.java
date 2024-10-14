package StreamCollector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class FindHighestFromStreamsDepartmentWise {

    public static void main(String[] ar) {
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee("Ram", "IT", 1000);
        Employee e2 = new Employee("Shyam", "IT", 2000);
        Employee e3 = new Employee("Manoj", "Health", 3000);
        Employee e4 = new Employee("Mohit", "Health", 4000);
        Employee e5 = new Employee("Shivam", "Teacher", 5000);
        Employee e6 = new Employee("Deepu", "Teacher", 6000);

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);

        Map<String, Employee> collect = list.stream().collect(Collectors.groupingBy(Employee::getDepartMent, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
        log.info("{}", collect.toString());
        Map<String, Employee> collect1 = list.stream().collect(Collectors.toMap(Employee::getDepartMent, Function.identity(), (existingEmployee, newEmployee) -> existingEmployee.getSalary() > existingEmployee.getSalary() ? existingEmployee : newEmployee));
        log.info("{}", collect1.toString());
    }
}

@Data
@AllArgsConstructor
class Employee {
    String name;
    String departMent;
    Integer salary;
}

