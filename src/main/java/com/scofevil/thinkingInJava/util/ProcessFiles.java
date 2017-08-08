package com.scofevil.thinkingInJava.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    private Strategy strategy;
    private String   ext;
    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {

            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
        ;
    }

    public void start(String args[]) {
        try {
            if (args.length == 0)
                processDirectoryTree(".");
            else
                for (String each : args) {
                    File fileArg = new File(each);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        if (!each.endsWith("." + ext))
                            each += "." + ext;
                        strategy.process(new File(each).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processDirectoryTree(String string) throws IOException {
        processDirectoryTree(new File(string));
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File each : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(each);
        }
    }

    public interface Strategy {
        void process(File file);
    }
}
