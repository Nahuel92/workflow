package org.nahuelrodriguez.portfolio.configuration;

import com.netflix.conductor.client.automator.TaskRunnerConfigurer;
import com.netflix.conductor.client.http.TaskClient;
import io.quarkus.runtime.StartupEvent;
import org.nahuelrodriguez.portfolio.TestWorker;

import javax.enterprise.event.Observes;
import java.util.List;

public class TaskRunnerConfiguration {
    private final TestWorker worker;
    private final WorkerConfiguration configuration;

    public TaskRunnerConfiguration(final TestWorker worker, final WorkerConfiguration configuration) {
        this.worker = worker;
        this.configuration = configuration;
    }

    private TaskClient getTaskClient() {
        final var taskClient = new TaskClient();
        taskClient.setRootURI(configuration.getServerurl());
        return taskClient;
    }

    private TaskRunnerConfigurer getTaskRunnerConfigurer() {
        return new TaskRunnerConfigurer.Builder(getTaskClient(), List.of(worker))
                .withThreadCount(configuration.getThreadcount())
                .build();
    }

    void onStart(@Observes final StartupEvent ev) {
        getTaskRunnerConfigurer().init();
    }
}
