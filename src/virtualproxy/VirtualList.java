package virtualproxy;

import java.util.List;

public class VirtualList {
    private List<DomainObject> source;
    private VirtualListLoader loader;

    public VirtualList(VirtualListLoader loader){
        this.loader = loader;
    }

    public List<DomainObject> getSource() {
        if (source == null) source = loader.load();
        return source;
    }

    public int size(){
        return getSource().size();
    }

    public boolean isEmpty(){
        return getSource().isEmpty();
    }
}