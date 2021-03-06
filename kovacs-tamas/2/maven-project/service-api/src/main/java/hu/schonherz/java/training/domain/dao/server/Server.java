package hu.schonherz.java.training.domain.dao.server;

public class Server {
    private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;

    private Server(int id, String name, ServerType type, ServerStatus status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public static ServerBuilder builder() {
        return new ServerBuilder();
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

    public static class ServerBuilder {
        private int id;
        private String name;
        private ServerType type;
        private ServerStatus status;

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
            if (name == null || type == null || status == null) {
                throw new IllegalStateException("Illegal null parameter!");
            }

            return new Server(id, name, type, status);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Server other = (Server) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Server [id=").append(id).append(", name=").append(name).append(", type=").append(type)
                .append(", status=").append(status).append("]");
        return builder.toString();
    }



}
