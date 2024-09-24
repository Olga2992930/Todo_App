package command;

import main.Main;
import task.Task;

public class ViewTaskCommand {
    public Main main;

    public ViewTaskCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: view-task <name>");
            return;
        }

        String taskName = args[1];
        Task task = main.taskManager.getTask(taskName);
        if (task == null) {
            System.out.println("Den tasken finns inte.");
            return;
        }

        System.out.println(task.toString());
     }
    
}
