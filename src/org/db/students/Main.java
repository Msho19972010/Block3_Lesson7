package org.db.students;

import java.util.Scanner;

public class Main {
    private static StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {
        while(true) {
            //Output a list of variants
            printMessage();
            //reading an action's number and additional data
            Command command = readCommand();
            if(command.getAction() == Action.EXIT) {
                return;
            } else if(command.getAction() == Action.ERROR){
                continue;
            } else {
                //perform an action
                STUDENT_COMMAND_HANDLER.processCommand(command);
            }
        }


    }

    private static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try{
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if(action == Action.CREATE || action == Action.UPDATE) {
                System.out.println("Sequence: 'Surname,Name,Course,Town,Age'");
            }
            if(action.isRequiredAdditionalData()) {
                String data = scanner.nextLine();
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        } catch(Exception ex) {
            System.out.println("The problem of input processing. " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("------------------------");
        System.out.println("0. Exit");
        System.out.println("1. Creating data");
        System.out.println("2. Updating data");
        System.out.println("3. Deleting data");
        System.out.println("4. Statistic outputting by courses");
        System.out.println("6. Searching by surnames");
        System.out.println("------------------------");
    }
}
