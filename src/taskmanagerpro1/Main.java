package taskmanagerpro1;
import adapter.ExternalTask;
import adapter.TaskAdapter;
import bridge.*;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();
        int option;

        do {
            System.out.println("\n=== MENÚ DE TAREAS ===");
            System.out.println("1. Crear tarea");
            System.out.println("2. Clonar tarea");
            System.out.println("3. Agregar tarea externa");
            System.out.println("4. Notificar por email");
            System.out.println("5. Notificar por SMS");
            System.out.println("6. Ver todas las tareas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Prioridad: ");
                    String priority = scanner.nextLine();
                    ConcreteTask newTask = new ConcreteTask(desc, priority);
                    taskList.addTask(newTask);
                    System.out.println("Tarea creada.");
                    break;
                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("No hay tareas para clonar.");
                    } else {
                        System.out.println("Seleccione la tarea a clonar:");
                        int index = 1;
                        for (Task t : taskList) {
                            System.out.println(index + ". " + t.toString());
                            index++;
                        }
                        System.out.print("Número de tarea: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice > 0 && choice <= taskList.size()) {
                            Task selected = taskList.get(choice - 1);
                            if (selected instanceof ConcreteTask) {
                                ConcreteTask cloned = (ConcreteTask) ((ConcreteTask) selected).clone();
                                taskList.addTask(cloned);
                                System.out.println("Tarea clonada.");
                            } else {
                                System.out.println("La tarea seleccionada no es clonable.");
                            }
                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Título externo: ");
                    String title = scanner.nextLine();
                    System.out.print("Nivel externo: ");
                    int level = scanner.nextInt();
                    scanner.nextLine();
                    Task extTask = new TaskAdapter(new ExternalTask(title, level));
                    taskList.addTask(extTask);
                    System.out.println("Tarea externa agregada.");
                    break;
                case 4:
                    System.out.print("Mensaje a enviar por email: ");
                    String emailMsg = scanner.nextLine();
                    new TaskAbstraction(new EmailNotification()).execute(emailMsg);
                    break;
                case 5:
                    System.out.print("Mensaje a enviar por SMS: ");
                    String smsMsg = scanner.nextLine();
                    new TaskAbstraction(new SmsNotification()).execute(smsMsg);
                    break;
                case 6:
                    System.out.println("\n--- TAREAS REGISTRADAS ---");
                    for (Task task : taskList) {
                        task.perform();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }
}
