package org.nahuelrodriguez.portfolio;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.nahuelrodriguez.portfolio.configuration.WorkerConfiguration;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestWorker implements Worker {
    private final WorkerConfiguration configuration;

    public TestWorker(final WorkerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getTaskDefName() {
        return configuration.getTaskdefname();
    }

    @Override
    public TaskResult execute(final Task task) {
        System.out.println(getTaskDefName());
        return null;
    }
}
