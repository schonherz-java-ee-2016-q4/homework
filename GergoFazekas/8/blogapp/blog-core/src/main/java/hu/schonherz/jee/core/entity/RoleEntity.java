package hu.schonherz.jee.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RoleEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID = 640451545479552238L;
    
    private String name;
    
    public RoleEntity() {
        // TODO Auto-generated constructor stub
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
