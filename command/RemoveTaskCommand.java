package command;

import main.Main;
import task.Task;

public class RemoveTaskCommand {
    public Main main;

    public RemoveTaskCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: remove-task <name>");
            return;
        }

        String taskName = args[1];
        Task task = main.taskManager.getTask(taskName);
        if (task == null) {
            System.out.println("Den tasken finns inte.");
            return;
        }

        main.taskManager.remove(task);
        System.out.println("Raderade task '" + task.title + "'");
    }

}
