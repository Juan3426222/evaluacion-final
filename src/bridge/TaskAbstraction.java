package bridge;

public class TaskAbstraction {
    private TaskImplementation implementation;

    public TaskAbstraction(TaskImplementation implementation) {
        this.implementation = implementation;
    }

    public void execute(String taskDescription) {
        implementation.send(taskDescription);
    }
}