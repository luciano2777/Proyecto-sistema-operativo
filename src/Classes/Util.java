/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Juan
 */
public class Util {
    
    public static String getStatusStr(int status){
        switch (status) {
            case 0 -> {
                return "RUNNING";
            }
            case 1 -> {
                return "BLOCKED";
            }
            case 2 -> {
                return "READY";
            }
            case 3 -> {
                return "TERMINATED";
            }            
        }
        return null;
    }
    
}
