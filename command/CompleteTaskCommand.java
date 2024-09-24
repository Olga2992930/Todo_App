package command;

import main.Main;
import task.Task;

public class CompleteTaskCommand {
    public Main main;

    public CompleteTaskCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: complete <name>");
            return;
        }

        String taskName = args[1];
        Task task = main.taskManager.getTask(taskName);
        if (task == null) {
            System.out.println("Den tasken finns inte.");
            return;
        }

        try {
            main.taskManager.markCompleted(task);
            System.out.println("Markerade task '" + task.title + "' som avklarad.");
        } catch (Exception e) {
            System.out.println("Kunde inte markera task som avklarad.");
        }
    }
}
