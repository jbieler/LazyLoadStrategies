package ghost;

import java.sql.ResultSet;

public abstract class Mapper {

    public void load(DomainObject obj) {
        if (!obj.isGhost())
            return;
        
        ResultSet result = queryDB();
        loadLine(result, obj);
    }

    private ResultSet queryDB() {
        // Use DB connection to gather data
        // SELECT FROM table WHERE key = obj.id
        return null;
    }
    
    private void loadLine(ResultSet result, DomainObject obj) {
        if (obj.isGhost()) {
            obj.markLoading();
            doLoadLine(result, obj);
            obj.markLoaded();
        }
    }

    protected abstract void doLoadLine(ResultSet result, DomainObject obj);        
    
}
