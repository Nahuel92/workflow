package org.nahuelrodriguez.portfolio.properties;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

@ConfigProperties(prefix = "worker")
@Data
public class WorkerProperties {
    private String taskdefname;
    private int threadcount;
    private String serverurl;
}
