package hu.schonherz.java.training.report;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.utility.map.MultiMap;

public class StoppedServerReporter implements Reporter {
    private MultiMap<Server, SystemAdministrator> reportData;

    public StoppedServerReporter(MultiMap<Server, SystemAdministrator> reportData) {
        this.reportData = reportData;
    }

    @Override
    public String getReportString() {
        StringBuilder builder = new StringBuilder();
        
        Map<Server, List<SystemAdministrator>> stopped = reportData.entrySet().stream()
            .filter(e -> e.getKey().getStatus().equals(ServerStatus.STOPPED))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            
        stopped.entrySet().stream()
            .forEach(e -> {
                builder.append(e.getKey().getId())
                    .append(" - ")
                    .append(e.getKey().getName())
                    .append(" - ")
                    .append(e.getKey().getType())
                    .append("\n");
                
                builder.append("----------------------------------------------\n");
                
                e.getValue().stream().forEach(
                    sysAdmin -> {
                    builder.append(sysAdmin.getEmployeeID())
                        .append(" - ")
                        .append(sysAdmin.getName())
                        .append("\n");
                });
            });
        
        return builder.toString();
    }

}
