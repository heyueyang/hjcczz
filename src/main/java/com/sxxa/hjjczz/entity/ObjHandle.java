package com.sxxa.hjjczz.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Lenovo on 2020/7/2.
 */
public class ObjHandle {
    public void setFields(String key,String value){
        String[] strs=getFiledName(this);
        for (String s:strs)
        {
            if (key.equals(s))
            {
                setFieldValueByName(this,s,value);
                break;
            }
        }
    }
    public static void setFieldValueByName(Object obj, String fieldName, Object value){
        try {
            // 获取obj类的字节文件对象
            Class c = obj.getClass();
            // 获取该类的成员变量
            Field f = c.getDeclaredField(fieldName);
            // 取消语言访问检查
            f.setAccessible(true);
            // 给变量赋值
            f.set(obj, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
        }
        return null;
    }
}
