package com.example.service.database;

public class DataBaseContextHolder {

   public static final String WRITE = "write";
   public static final String READ = "read";

    private static final ThreadLocal<String> context = new ThreadLocal<>();

    public static void setDataBaseType(String dataBaseType){
        if(dataBaseType == null) throw new NullPointerException();
        context.set(dataBaseType);
    }

    public static String getDataBaseType(){
        return context.get() == null ? WRITE : context.get();
    }

    public static void clearDataBaseType(){
        context.remove();
    }
}
