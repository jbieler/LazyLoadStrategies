package ghost;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    @Before
    public void setup() {
        MapperRegistry registry = new MapperRegistry();
        registry.mapClass(Employee.class, new EmployeeMapper());
        SimpleDataSource.init(registry);
    }
    
    @Test
    public void testLazyEmployee() {
        
        Employee e = new Employee(1L);
        
        assertTrue(e.isGhost());
        assertTrue(e.isNameNull());
        
        String nameOfE = e.getName(); // Triggers load
        
        assertThat(nameOfE, equalTo("Rolf"));
        
        assertTrue(e.isLoaded());
        assertFalse(e.isGhost());
    }
    
}
