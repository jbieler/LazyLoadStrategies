package virtualproxy;

import java.util.List;

public interface VirtualListLoader { 
    List<DomainObject> load();
}