package hu.schonherz.java.training.domain.server;

public class ServerBuilder {
	private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;
	
    public ServerBuilder() {
		
	}
    
    public ServerBuilder id(int id) {
    	this.id = id;
    	return this;
    }
    public ServerBuilder name(String name) {
    	this.name = name;
    	return this;
    }
    public ServerBuilder type(ServerType type) {
    	this.type = type;
    	return this;
    }
    public ServerBuilder status(ServerStatus status) {
    	this.status = status;
    	return this;
    }
    
    public Server build() {
    	return new Server(id, name, type, status);
    }

}
