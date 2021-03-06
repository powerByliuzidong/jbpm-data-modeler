package org.jbpm.datamodeler.editor.client.util;

public class DataModelerUtils {

    public static final String EXTERNAL_PREFIX = "- ext - ";
    public static final String MULTIPLE = "[0..N]";

    public static DataModelerUtils getInstance() {
        return new DataModelerUtils();
    }

    public String extractClassName(String fullClassName) {

        if (fullClassName == null) return null;
        int index = fullClassName.lastIndexOf(".");
        if (index > 0) {
            return fullClassName.substring(index+1, fullClassName.length());

        } else {
            return fullClassName;
        }
    }

    public String extractPackageName(String fullClassName) {
        if (fullClassName == null) return null;
        int index = fullClassName.lastIndexOf(".");
        if (index > 0) {
            return fullClassName.substring(0, index);

        } else {
            return null;
        }
    }

    public String[] getPackageTerms(String packageName) {
        return packageName.split("\\.");
    }
}