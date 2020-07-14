package org.nahuelrodriguez.portfolio.configuration;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "worker")
public class WorkerConfiguration {
    private String taskdefname;
    private int threadcount;
    private String serverurl;

    public String getTaskdefname() {
        return taskdefname;
    }

    public void setTaskdefname(String taskdefname) {
        this.taskdefname = taskdefname;
    }

    public int getThreadcount() {
        return threadcount;
    }

    public void setThreadcount(int threadcount) {
        this.threadcount = threadcount;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }
}
