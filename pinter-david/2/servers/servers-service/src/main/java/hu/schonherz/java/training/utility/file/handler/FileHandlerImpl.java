package hu.schonherz.java.training.utility.file.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.utility.file.processor.FileProcessor;
import hu.schonherz.java.training.utility.file.processor.FileProcessorImpl;
import hu.schonherz.java.training.utility.map.MultiMap;
import java.net.URI;
import java.net.URISyntaxException;

public class FileHandlerImpl implements FileHandler<Server, SystemAdministrator> {

    private final String projectDir = "project";
    private final String filesDir = "/files/";
    private final String serverFileName = "servers.txt";
    private final String sysAdminFileName = "sysadmins.txt";

    private final Path pathToServerFile = Paths.get("resources", filesDir, serverFileName);
    private final Path pathToSysadminFile = Paths.get("resources", filesDir, sysAdminFileName);

    private final File serverFile;
    private File sysAdminFile;

    private long serverFileModDateCache;
    private long sysAdminFileModDateCache;
    private FileProcessor fileProcessor;
    
    private MultiMap<Server, SystemAdministrator> serverMap;

    public FileHandlerImpl() throws FileNotFoundException, URISyntaxException {
        URI serverFileURI = getClass().getResource(filesDir+serverFileName).toURI();
        serverFile = new File(serverFileURI);

        if (!serverFile.exists()) {
            throw new FileNotFoundException("Server file not found");
        }

        serverFileModDateCache = serverFile.lastModified();

        sysAdminFile = new File(getClass().getResource(filesDir + sysAdminFileName).toURI());

        if (!sysAdminFile.exists()) {
            throw new FileNotFoundException("Sysadmin file not found");
        }

        sysAdminFileModDateCache = sysAdminFile.lastModified();
        fileProcessor = new FileProcessorImpl(serverFile, sysAdminFile);
        serverMap = fileProcessor.process();
    }

    @Override
    public MultiMap<Server, SystemAdministrator> refresh() {

        boolean isServerFileModified = sysAdminFileModDateCache != sysAdminFile.lastModified();
        boolean isSysAdminFileModified = serverFileModDateCache != serverFile.lastModified();

        if (isServerFileModified || isSysAdminFileModified) {
            sysAdminFileModDateCache = sysAdminFile.lastModified();
            serverFileModDateCache = serverFile.lastModified();
            System.out.println("File modified");
            serverMap =  fileProcessor.process();
        }

        return serverMap;
    }

}
