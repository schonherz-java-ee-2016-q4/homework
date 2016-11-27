package hu.schonherz.java.training.domain.server;

public class Server {
    private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;
    
    public Server(int id, String name, ServerType type, ServerStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
	}

	public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ServerType getType() {
        return type;
    }

    public void setType(final ServerType type) {
        this.type = type;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public void setStatus(final ServerStatus status) {
        this.status = status;
    }
}
