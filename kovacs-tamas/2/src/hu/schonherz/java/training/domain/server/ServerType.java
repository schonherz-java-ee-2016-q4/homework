package hu.schonherz.java.training.domain.server;

import java.util.Optional;

public enum ServerType {
    LINUX,
    LINUX_WEB,
    LINUX_DB_AND_WEB,
    WINDOWS,
    WINDOWS_WEB,
    WINDOWS_DB_AND_WEB;

    public static Optional<ServerType> decodeFromStr(String str) {
        if (str == null) {
            return Optional.empty();
        }
        if (str.isEmpty()) {
            return Optional.empty();
        }

        str = str.toLowerCase();
        if (str.contains("linux")) {
            if (str.contains("web")) {
                if (str.contains("db")) {
                    return Optional.of(LINUX_DB_AND_WEB);
                }
                return Optional.of(LINUX_WEB);
            }
            return Optional.of(LINUX);
        }

        if (str.contains("win")) {
            if (str.contains("web")) {
                if (str.contains("db")) {
                    return Optional.of(WINDOWS_DB_AND_WEB);
                }
                return Optional.of(WINDOWS_WEB);
            }
            return Optional.of(WINDOWS);
        }

        return Optional.empty();
    }

}
