package main;
/*

<-----> Todo Applikation <----->
En applikation för att schemalägga "tasks" som kan avklaras.

Funktionalitet:
1. Skapa "tasks"
    - Schemalägga tasks
    - Prioritera task
    - Upprepande tasks
    - Organisera/gruppera tasks
2. Radera "tasks"
3. Uppdatera "tasks" (uppdatera titel, tid)
4. Avklara "tasks"
5. Lista upp tasks
    - Visa i ordning
    - Visa tid
    - Visa i grupper

Implementation:
- Spara "tasks" till fil

- Task klass - representerar en task
- TaskManager klass - hanterar alla tasks
- Validation klass - utility klass för att validera information
- CommandManager klass - hantera kommandon
- TimeManager klass - hanterar påminnelser om schemalagda tasks

 */

import command.CommandManager;
import task.TaskManager;

public class Main {
    public boolean running = true;
    public CommandManager commandManager = new CommandManager(this);
    public TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        System.out.println("Välkommen till todo applikationen!");
        System.out.println("Skriv 'help' för en lista på kommandon.");

        Main main = new Main();

        while (main.running) {
            try {
                main.commandManager.readCommand();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}