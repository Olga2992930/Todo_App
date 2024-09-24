package command;

import main.Main;

public class HelpCommand {
    public Main main;

    public HelpCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        System.out.println("Kommandon:");
        System.out.println(" help - Skriv ut all hjälp information.");
        System.out.println(" create <name> - Skapa en ny task.");
    }
}
