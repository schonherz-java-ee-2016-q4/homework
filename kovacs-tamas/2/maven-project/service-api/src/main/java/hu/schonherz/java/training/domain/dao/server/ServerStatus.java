package hu.schonherz.java.training.domain.dao.server;

import java.util.Optional;

public enum ServerStatus {
    STOPPED,
    RUNNING;

    public static Optional<ServerStatus> decodeFromStr(String str) {
        if (str != null && !str.isEmpty()) {
            str = str.toUpperCase();
            if (str.contains(ServerStatus.RUNNING.name())) {
                return Optional.of(ServerStatus.RUNNING);
            }
            if (str.contains(ServerStatus.STOPPED.name())) {
                return Optional.of(ServerStatus.STOPPED);
            }
        }

        return Optional.empty();
    }
}
