package com.porto.logistica.utils;

public class Utils {

    public static boolean validaNumeroConteiner(String numero){
        boolean valido = true;
       // numero = numero.replaceAll("[^a-zA-Z0-9]","");
         if(numero.length() != 11){
             return false;
         }
         if(!numero.substring(0,4).matches("[A-Z]*")){
             return false;
         }
         return numero.substring(4).matches("[0-9]*");

    }
}
