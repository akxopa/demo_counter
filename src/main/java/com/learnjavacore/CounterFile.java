package com.learnjavacore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class CounterFile {
    
    static Path dataFile = Path.of("my_count.ser");
    static Counter myCounter;

    public void loadCounter() { // загрузка счетчика
        if (dataFile.toFile().exists()) {
            System.out.println("^".repeat(40));
            System.out.println("Тут уже что-то есть... ");
            aboutCommands();
            System.out.println("^".repeat(40));
            
            try (FileInputStream fin = new FileInputStream(dataFile.toFile()); 
            BufferedReader br = new BufferedReader(new InputStreamReader(fin))) { 
                
                String line = br.readLine();
                int numberCounter = Integer.parseInt(line);
                myCounter = new Counter(numberCounter);
                System.out.println("Счетчик загружен, значение '" + myCounter.getCounter() + "'");

            } catch (Exception e) {
                System.out.println("Этот фаил использовать не получится");
                e.printStackTrace();
            }
        } else {
            myCounter = new Counter(0);
            System.out.println(myCounter.toString());
            aboutCommands();
        }
    }

    public void saveCounter() throws IOException { // сохранение счетчика
        try (FileOutputStream fout = new FileOutputStream(dataFile.toFile(), false)) {
            fout.write(String.valueOf(myCounter.getCounter()).getBytes()); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void aboutCommands() {
        System.out.println("/inc\t увеличивает счетчик на 1\n" + "/reset\t сбрасывает счетчик\n" + "/stop\t завершает приложение");
    }
}
