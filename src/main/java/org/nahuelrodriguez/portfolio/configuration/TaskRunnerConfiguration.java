package org.nahuelrodriguez.portfolio.configuration;

import com.netflix.conductor.client.automator.TaskRunnerConfigurer;
import com.netflix.conductor.client.http.TaskClient;
import io.quarkus.runtime.StartupEvent;
import lombok.RequiredArgsConstructor;
import org.nahuelrodriguez.portfolio.TestWorker;
import org.nahuelrodriguez.portfolio.properties.WorkerProperties;

import javax.enterprise.event.Observes;
import java.util.List;

@RequiredArgsConstructor
public class TaskRunnerConfiguration {
    private final WorkerProperties configuration;
    private final TestWorker worker;

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
