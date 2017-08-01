import java.util.*;

public class FindCommonManager{
    static class Employee {
        final String name;
        List<Employee> reporters;

        public Employee(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    //Overall flag to indicate find employees
    static boolean firstFound;
    static boolean secondFound;
    
    public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee){
        
        firstFound = false;
        secondFound = false;
        
        Employee searchResult = search(ceo, firstEmployee, secondEmployee);
        
        if(!firstFound || !secondFound || searchResult == null ||searchResult.name.equals(ceo.name))    return null;
        
        
        return searchResult;
    }


    public static Employee search(Employee parent, Employee firstEmployee, Employee secondEmployee){
        
        boolean findFirst = false;
        boolean findSecond = false;
        
        if(parent == null)     return parent; 
        if(parent.name.equals(firstEmployee.name)){
            findFirst = true;
            firstFound = true;
        }
        if(parent.name.equals(secondEmployee.name)){
            findSecond = true;
            secondFound = true;
        }
        

        Employee each;
        
        if(parent.reporters != null){
            for(Employee em : parent.reporters){
            
                each = search(em, firstEmployee, secondEmployee);
                
                if(each != null){
                    if(each.name.equals(firstEmployee.name)){
                        findFirst = true;
                        firstFound = true;
                    }    
                    else if(each.name.equals(secondEmployee.name)){
                        findSecond = true;
                        secondFound = true;
                    }    
                    else return each;
                }
             
            }
        }
        
        if(findFirst&&findSecond)    return parent;
        if(findFirst)    return firstEmployee;
        if(findSecond)    return secondEmployee;
        
        return null;
    }
    

    public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");


        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.reporters = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.reporters = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.reporters = Arrays.asList(dom, samir, michael);
        
        Employee leon = new Employee("Leon");

        System.out.println(closestCommonManager(bill, milton, nina));
        System.out.println(closestCommonManager(bill, nina, porter));
        System.out.println(closestCommonManager(bill, nina, samir));
        System.out.println(closestCommonManager(bill, peter, nina));
        System.out.println(closestCommonManager(bill, leon, michael));
        
        
    }
}