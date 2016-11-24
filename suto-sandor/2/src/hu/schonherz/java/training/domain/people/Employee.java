package hu.schonherz.java.training.domain.people;

import java.io.Serializable;

public class Employee implements Serializable {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

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
