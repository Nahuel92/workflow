package org.nahuelrodriguez.portfolio;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import lombok.RequiredArgsConstructor;
import org.nahuelrodriguez.portfolio.properties.WorkerProperties;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class TestWorker implements Worker {
    private final WorkerProperties configuration;

    @Override
    public String getTaskDefName() {
        return configuration.getTaskdefname();
    }

    @Override
    public TaskResult execute(final Task task) {
        System.out.println(task.getInputData());

        final var result = new TaskResult();
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
