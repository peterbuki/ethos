package com.peterbuki.ethos.collector;

import java.io.*;

import static java.lang.Thread.sleep;

public class RollingFileWriter {

    private final String filename;
    private final Thread thread;
    private boolean running;
    private int counter=0;

    /**
     * Constructor
     *
     * @param filename the file to be written
     */
    public RollingFileWriter(String filename) {
        this.filename = filename;
        this.thread = new Thread(new ThreadClass(), "fileappender");
    }

    /**
     * Start writing the file
     */
    public void start()
    {
        running = true;
        thread.start();
    }

    public void stop()
    {
        running = false;

    }

    private class ThreadClass implements Runnable {
    @Override
    public void run() {
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(filename));
            while (running)
            {
                writer.write(String.format("%d,%d,%d,%d\n", counter, counter + 2, counter * 2, counter * counter));
                writer.flush();
                counter++;
                sleep(100);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e);
            running = false;
        } catch (InterruptedException e) {
        }

        File file = new File(filename);
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }
}
}
