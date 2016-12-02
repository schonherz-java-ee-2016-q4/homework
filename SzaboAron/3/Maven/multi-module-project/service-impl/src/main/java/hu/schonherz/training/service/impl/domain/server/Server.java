package hu.schonherz.training.service.impl.domain.server;

public class Server {
    private int id;
    private String name;
    private ServerType type;
    private ServerStatus status;

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

    @Override
    public String toString() {
        return id + " - " + name + " - " + type;
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Server other = (Server) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (status != other.status)
            return false;
        if (type != other.type)
            return false;
        return true;
    }
}