package hu.nemethmarcell.domain.server;

/**
 * Created by Marci on 2016. 11. 22..
 */
public class Server {
    private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;

    private Server(ServerBuilder builder) {
        super();
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.status = builder.status;
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


    public static class ServerBuilder


    {
        private int id;
        private String name;
        private ServerType type;
        private ServerStatus status;

        public ServerBuilder() {


        }

        public ServerBuilder setNewId(int id) {
            this.id = id;
            return this;
        }

        public ServerBuilder setNewName(String name) {
            this.name = name;
            return this;

        }

        public ServerBuilder setNewType(ServerType type) {
            this.type = type;
            return this;
        }

        public ServerBuilder setNewStatus(ServerStatus status) {
            this.status = status;
            return this;
        }

        public Server build() {
            return new Server(this);
        }
    }

}
