package hu.schonherz.java.training.domain.server;

public final class ServerBuilder {
    
    private Server instance;
    
    private ServerBuilder() {}
    
    public static ServerBuilder builder() {
        ServerBuilder back = new ServerBuilder();
        back.instance = new Server();
        
        return back;
    }
    
    public ServerBuilder id(final int id) {
        instance.setId(id);
        return this;
    }
    
    public ServerBuilder name(final String name) {
        instance.setName(name);
        return this;
    }
    
    public ServerBuilder type(final ServerType type) {
        instance.setType(type);
        return this;
    }
    
    public ServerBuilder status(final ServerStatus status) {
        instance.setStatus(status);
        return this;
    }
    
    public Server build() {
        return instance;
    }
}
