/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.util;

/**
 *
 * @author rajiv
 */
public class StringUtil {

    // converting the objects into a comma seperated list
    public static String toCommaSeparatedString(Object[] itemList) {
        StringBuilder stringBuilder = new StringBuilder();
        // forming the list by appending ',' afetr each Object
        for (Object item : itemList) {
            stringBuilder.append(item).append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        // returning the object list as a string
        return stringBuilder.toString();
    }
}
