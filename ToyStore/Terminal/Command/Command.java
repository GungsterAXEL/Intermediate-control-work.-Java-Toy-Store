package ToyStore.Terminal.Command;

public class Command {
    private static String COMMANDLIST =
            "add - Добавить случайную позицию игрушек.\n" +
                    "del - Удалить случайную позицию игрушек.\n" + '\n' +
                    "print - Вывести содержимое магазина с сортировкой по ID.\n" +
                    "print-c - Вывести содержимое магазина с сортировкой по количеству.\n" +
                    "print-p - Вывести содержимое магазина с сортировкой по цене.\n" + '\n' +
                    "roll - Участвовать в лотерее.\n" +
                    "break - Выход.\n";

    public static String getCOMMANDLIST() {
        return COMMANDLIST;
    }

    private String command;

    public Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean getHelp() {
        return this.command.equals("HELP");
    }

    public boolean getBreak() {
        return this.command.equals("BREAK");
    }

    public boolean addToy() {
        return this.command.equals("ADD");
    }

    public boolean delToy() {
        return this.command.equals("DEL");
    }

    public boolean tryRoll() {
        return this.command.equals("ROLL");
    }

    public boolean printByID() {
        return this.command.equals("PRINT");
    }

    public boolean printByAmount() {
        return this.command.equals("PRINT-C");
    }

    public boolean printByPrice() {
        return this.command.equals("PRINT-P");
    }

}
