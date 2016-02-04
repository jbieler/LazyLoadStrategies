package ghost;

import java.sql.ResultSet;

public class EmployeeMapper extends Mapper {

    @Override
    protected void doLoadLine(ResultSet result, DomainObject obj) {
        Employee employee = (Employee) obj; // Downcast
        employee.setName("Rolf"); // Do not actually use ResultSet at the moment
        //Use other Mappers to resolve associations, for example Department
    }

}
