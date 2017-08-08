package com.scofevil.thinkingInJava.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws Exception {
        String[] aa = new String[1];
        aa[0] = "com.scofevil.thinkingInJava.annotation.Member";
        for (String className : aa) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            //if the name is empty, use the class name
            if (tableName.length() < 1)
                tableName = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1)
                    continue;
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    //Use field name if name not specified
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    //Use field name if name not specified
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();
                    columnDefs
                            .add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(
                                    sString.constraints()));
                }

            }
            StringBuilder createCommand = new StringBuilder("CREATE　TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ")";
            System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);

        }
    }

    private static String getConstraints(Constraints con) {
        String re = "";
        if (!con.allowNull())
            re += " NOT NULL ";
        if (con.primaryKey())
            re += " PRIMARY KEY ";
        if (con.unique())
            re += " UNIQUE ";
        return re;

    }
}
