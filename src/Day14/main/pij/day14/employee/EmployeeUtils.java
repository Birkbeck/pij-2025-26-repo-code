package pij.day14.employee;

/**
 * EmployeeUtils class has utility methods for Employee objects.
 */
public class EmployeeUtils {

    /**
     * Returns a string representing the hierarchy of employees from the top-level
     * manager (CEO) down to the specified employee.
     *
     * @param employee the employee whose hierarchy is to be represented
     * @return a string representing the employee hierarchy
     */

    //
    public static String getEmployeeTreeStructure(Employee employee){

        // base case: if employee has no line manager, return employee name
        if (employee.getLineManager() == null){
            return employee.getName();
        }

        // recursive case: get manager's hierarchy and append employee name
        StringBuilder sb = new StringBuilder();
        var manager = EmployeeUtils.getEmployeeTreeStructure(employee.getLineManager());
        if (!manager.isEmpty()){
            sb.append(manager);
            sb.append("\n|\n");
        }

        // add Employee name
        sb.append(employee.getName());

        return sb.toString();
    }

}
