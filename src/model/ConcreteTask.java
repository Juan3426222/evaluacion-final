package model;

public class ConcreteTask implements Task, Cloneable {
    private String description;
    private String priority;

    public ConcreteTask(String description, String priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void perform() {
        System.out.println("Realizando tarea: " + description + " [Prioridad: " + priority + "]");
    }

    @Override
    public String toString() {
        return description + " (" + priority + ")";
    }
}