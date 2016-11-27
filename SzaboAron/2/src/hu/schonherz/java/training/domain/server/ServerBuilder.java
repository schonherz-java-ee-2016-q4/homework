package hu.schonherz.java.training.domain.server;

public class ServerBuilder {
    private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;

    public ServerBuilder(int id, String name) {
        super();
        this.id = id;
        this.name = name;
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
        Server server = new Server();
        server.setId(id);
        server.setName(name);
        server.setStatus(status);
        server.setType(type);
        return server;
    }

}
