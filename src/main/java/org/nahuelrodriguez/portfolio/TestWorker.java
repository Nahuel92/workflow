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
    private final WorkerProperties props;

    @Override
    public String getTaskDefName() {
        return props.getTaskdefname();
    }

    @Override
    public TaskResult execute(final Task task) {
        final var result = new TaskResult();
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
