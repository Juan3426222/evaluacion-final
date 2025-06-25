package adapter;

import model.Task;

public class TaskAdapter implements Task {
    private ExternalTask externalTask;

    public TaskAdapter(ExternalTask externalTask) {
        this.externalTask = externalTask;
    }

    @Override
    public void perform() {
        System.out.println("(Adaptada) Ejecutando tarea externa: " + externalTask.getTitle() + " [Nivel: " + externalTask.getLevel() + "]");
    }

    @Override
    public String toString() {
        return "(Adaptada) " + externalTask.getTitle() + " [Nivel: " + externalTask.getLevel() + "]";
    }
}
