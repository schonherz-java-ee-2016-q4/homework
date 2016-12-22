package hu.schonherz.java.training.utility.file.reader;

import java.io.File;
import java.util.List;

import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public interface FileProcessor<T> {
    
    List<T> read(File file);
    
    default ServerType getServerType(String string) {
        switch (string) {
        case "Linux":
            return ServerType.LINUX;
        case "LinuxWeb":
            return ServerType.LINUX_WEB;
        case "LinuxDBandWEB":
            return ServerType.LINUX_DB_AND_WEB;
        case "Win":
            return ServerType.WINDOWS;
        case "WinWeb":
            return ServerType.WINDOWS_WEB;
        case "WinDBandWEB":
            return ServerType.WINDOWS_DB_AND_WEB;
        }
        return null;
    }

    default ServerStatus getServerStatus(String string) {
        switch (string) {
        case "RUNNING":
            return ServerStatus.RUNNING;
        case "STOPPED":
            return ServerStatus.STOPPED;
        }
        return null;
    }
}
