package nemethmarcell.domain.people;

/**
 * Created by Marci on 2016. 11. 22..
 */
import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 7950521176579703924L;

    protected String name;
    protected int employeeID;

    public Employee() {
        super();
    }

    public Employee(final String name, final int employeeID) {
        super();
        this.setName(name);
        this.setEmployeeID(employeeID);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

}