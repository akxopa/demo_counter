package com.learnjavacore;

import java.io.IOException;

public class CounterCommands {

    public void printPrompt() {
        System.out.print("> ");
    }

    public void processCommand(String command, CounterFile cf) throws IOException {
        switch (command) {
            case "/inc":
                incCounter(cf);
                break;
            case "/stop":
                stopApplication(cf);
                break;
            case "/reset":
                resetCounter(cf);
                break;
            default:
                System.err.println("Неизвестная команда. Попробуйте еще раз.");
        }
    }

    public void incCounter(CounterFile cf) throws IOException {
        if (CounterFile.myCounter != null) {
            CounterFile.myCounter.increment();
            cf.saveCounter();
            System.out.println(CounterFile.myCounter.toString());
        } else {
            System.err.println("Счетчик не найден. Запустите приложение снова для загрузки состояния.");
        }
    }

    public void stopApplication(CounterFile cf) throws IOException {
        if (CounterFile.myCounter != null) {
            System.out.println(CounterFile.myCounter.toString());
            cf.saveCounter();
            System.out.println("\n...\nЗавершаю работу");
            System.exit(0);
        } else {
            System.err.println("Счетчик не найден. Запустите приложение снова для загрузки состояния.");
        }
    }

    public void resetCounter(CounterFile cf) throws IOException {
        if (CounterFile.myCounter != null) {
            CounterFile.myCounter.setCounter(0);
            System.out.println("Счетчик сброшен\n");
            System.out.println(CounterFile.myCounter.toString());
            cf.saveCounter();
            
        }
    }
}
