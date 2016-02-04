package ghost;

/**
 * Binding to implementation! But mocking possible via DataSource
 */
public class SimpleDataSource {

    private static DataSource instance;
    
    private SimpleDataSource() {
    }
    
    public static void init(DataSource ds) {
        instance = ds;
    }
    
    public static void load(DomainObject obj) {
        assert instance != null : "Please init DataSource before usage";
        instance.load(obj);
    }
}
