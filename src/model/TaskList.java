package model;

import java.util.*;

public class TaskList implements Iterable<Task> {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public Task getLast() {
        if (!tasks.isEmpty()) {
            return tasks.get(tasks.size() - 1);
        }
        return null;
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
    
    public Task get(int index) {
    return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }
}