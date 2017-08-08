package com.scofevil.thinkingInJava.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author luhaifeng
 *
 */
public final class Directory {
    private static final String matchAll = ".*";

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        if (U.isNull(start))
            return new TreeInfo();
        if (U.isNull(regex))
            regex = matchAll;
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        if (U.isNull(start))
            return new TreeInfo();
        return walk(start, matchAll);
    }

    public static TreeInfo walk(String start) {
        if (U.isNull(start))
            return new TreeInfo();
        return walk(new File(start), matchAll);
    }

    public static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        if (U.isNull(startDir) || U.isNull(startDir.listFiles()))
            return result;
        for (File each : startDir.listFiles()) {
            if (each.isDirectory()) {
                result.dirs.add(each);
                result.addAll(recurseDirs(each, regex));
            } else {
                if (each.getName().matches(regex))
                    result.files.add(each);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(walk("."));
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs  = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles" + PPrint.pformat(files);
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

    }
}
