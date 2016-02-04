package ghost;

import java.util.Hashtable;

public class MapperRegistry implements DataSource {

    private Hashtable<Class<? extends DomainObject>, Mapper> mappers = new Hashtable<>();
    
    @Override
    public void load(DomainObject obj) {
        getMapper(obj.getClass()).load(obj);
    }
    
    private Mapper getMapper(Class<? extends DomainObject> clazz) {
        return mappers.get(clazz);
    }
    
    public void mapClass(Class<? extends DomainObject> clazz, Mapper mapper) {
        mappers.put(clazz, mapper);
    }
}
