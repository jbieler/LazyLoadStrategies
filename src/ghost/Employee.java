package ghost;

public class Employee extends DomainObject {

    private String name;
    
    public Employee(long key) {
        super(key);
    }
    
    public boolean isNameNull() {
        return name == null;
    }
    
    public String getName() {
        load();
        return name;
    }
    
    public void setName(String name) {
        load(); // Why load?
        this.name = name;
    }

}
