package com.scofevil.thinkInJava.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scofevil.thinkInJava.util.PPrint;
import com.scofevil.thinkInJava.util.U;

/**
 * @author luhaifeng
 * 文件遍历类，提供walk方法遍历根目录下面的所有文件和文件夹
 */
public class TreeInfo implements Iterable<File> {
    private static final String matchAll = ".*";
    public List<File>           files    = new ArrayList<File>();
    public List<File>           dirs     = new ArrayList<File>();

    public Iterator<File> iterator() {
        return files.iterator();
    }

    void addAll(TreeInfo other) {
        files.addAll(other.files);
        dirs.addAll(other.dirs);
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

    public String toString() {
        return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles" + PPrint.pformat(files);
    }
}
