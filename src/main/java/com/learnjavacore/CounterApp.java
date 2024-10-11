package com.learnjavacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Счетчик
 * Приложение, по команде /inc увеличивает счетчик на 1, команда /reset для сброса счетчика, /stop останавлиавет приложение.
 * При остановке приложения, данные счетчика сохраняются.
 */
 
public class CounterApp 
{
    public static void main( String[] args ) throws IOException
    {
        CounterFile cf = new CounterFile();
        cf.loadCounter();

        CounterCommands cm = new CounterCommands();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (Scanner scanner = new Scanner(reader)) {
            while (true) {
                cm.printPrompt();
                cm.processCommand(scanner.nextLine(), cf);
            }
        }

    }
}
