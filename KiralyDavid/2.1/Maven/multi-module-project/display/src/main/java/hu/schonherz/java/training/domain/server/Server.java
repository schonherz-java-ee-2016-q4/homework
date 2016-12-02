package hu.schonherz.java.training.domain.server;

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

		public Server createServer() {
			return new Server(this);
		}
	}
}