package ghost;

public class DomainObject {

    public enum LoadStatus {GHOST, LOADING, LOADED};
    
    private LoadStatus status;
    private long key;
    
    public DomainObject(long key) {
        this.key = key;
        this.status = LoadStatus.GHOST;
    }
    
    public boolean isGhost() {
        return status == LoadStatus.GHOST;
    }
    
    private boolean isLoading() {
        return status == LoadStatus.LOADING;
    }
    
    public boolean isLoaded() {
        return status == LoadStatus.LOADED;
    }
    
    public void markLoading() {
        assert isGhost() : "Object has to be in state ghost";
        status = LoadStatus.LOADING;
    }
    
    public void markLoaded() {
        assert isLoading() : "Object has to be in loading ghost";
        status = LoadStatus.LOADED;
    }
    
    protected void load() {
        if(isGhost())
            SimpleDataSource.load(this);
        assert isLoaded();
    }
}
