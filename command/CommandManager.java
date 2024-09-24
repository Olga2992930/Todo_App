package command;

import java.util.Scanner;

import main.Main;

public class CommandManager {

    public Scanner commandScanner;

    private HelpCommand helpCommand;
    private StopCommand stopCommand;
    private CreateTaskCommand createTaskCommand;
    private ListCommand listCommand;
    private ViewTaskCommand viewTaskCommand;
    private RemoveTaskCommand removeTaskCommand;
    private CompleteTaskCommand completeTaskCommand;

    public CommandManager(Main main) {
        helpCommand = new HelpCommand(main);
        stopCommand = new StopCommand(main);
        createTaskCommand = new CreateTaskCommand(main);
        listCommand = new ListCommand(main);
        viewTaskCommand = new ViewTaskCommand(main);
        removeTaskCommand = new RemoveTaskCommand(main);
        completeTaskCommand = new CompleteTaskCommand(main);
        commandScanner = new Scanner(System.in);
    }

    public void readCommand() {
        String input = commandScanner.nextLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("Kommandot får inte vara tomt.");
        }

        String[] args = input.split(" ");
        if (args.length == 0) {
            throw new IllegalArgumentException("Kommandot får inte vara tomt.");
        }

        String command = args[0];

        if (command.equalsIgnoreCase("help")) {
            helpCommand.run(args);
        } else if (command.equalsIgnoreCase("stop")) {
            stopCommand.run(args);
        } else if (command.equalsIgnoreCase("create")) {
            createTaskCommand.run(args);
        } else if (command.equalsIgnoreCase("list")) {
            listCommand.run(args);
        } else if (command.equalsIgnoreCase("view-task")) {
            viewTaskCommand.run(args);
        } else if (command.equalsIgnoreCase("remove-task")) {
            removeTaskCommand.run(args);
        } else if (command.equalsIgnoreCase("complete")) {
            completeTaskCommand.run(args);
        } else {
            throw new IllegalArgumentException(
                    "'" + command + "' är inte ett kommando. Skriv 'help' för en lista på kommandon.");
        }

        // help
        // create Städa 10:00 -> ["create", "Städa", "10:00"]
    }
}
