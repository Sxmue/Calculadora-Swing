package org.example;

import lombok.Data;

/**
 * Clase que representa una Calculadora
 */
@Data
public class Calculadora {

    /*Primer valor de la calculadora*/
    private Number a;

    /*Segundo valor de la calculadora*/
    private Number b;

    /*Simbolo de la operacion*/
    private char simbolo;

    /*Variable que guarda la ultima operacion realizada*/
    private String lastOperation;

    /*Variable que guarda el ultimo resultado obtenido*/
    private String lastResult;


    /**
     * Metodo que ejecuta la operacion sumar
     * @param c String con la operacion matematica
     * @return resultado de la operacion
     */
    public String suma(String c) {

        converter(c);

        Number result = 0;

        result = a.doubleValue() + b.doubleValue();
        if (result.doubleValue() % 1 == 0) {

            result = result.intValue();

        } else {

            result = result.doubleValue();

        }
        lastOperation = c;
        lastResult = result.toString();

        return result.toString();
    }
    /**
     * Metodo que ejecuta la operacion restar
     * @param c String con la operacion matematica
     * @return resultado de la operacion
     */
    public String resta(String c) {
        converter(c);

        Number result = 0;

        result = a.doubleValue() - b.doubleValue();
        if (result.doubleValue() % 1 == 0) {

            result = result.intValue();

        } else {

            result = result.doubleValue();
        }

        lastOperation = c;

        lastResult = result.toString();

        return result.toString();
    }

    /**
     * Metodo que ejecuta la operacion multiplicar
     * @param c String con la operacion matematica
     * @return resultado de la operacion
     */
    public String multiplicar(String c) {
        converter(c);

        Number result = 0;

        result = a.doubleValue() * b.doubleValue();
        if (result.doubleValue() % 1 == 0) {

            // Si el resultado no tiene decimales, devolver como entero
            result = result.intValue();
        } else {
            // Si el resultado tiene decimales, devolver como double
            result = result.doubleValue();
        }

        lastOperation = c;

        lastResult = result.toString();

        return result.toString();

    }

    /**
     * Metodo que ejecuta la operacion dividir
     * @param c String con la operacion matematica
     * @return resultado de la operacion
     */
    public String dividir(String c) {
        converter(c);

        Number result = 0;

        result = a.doubleValue() / b.doubleValue();
        if (result.doubleValue() % 1 == 0) {

            // Si el resultado no tiene decimales, devolver como entero
            result = result.intValue();
        } else {
            // Si el resultado tiene decimales, devolver como double
            result = result.doubleValue();
        }

        lastOperation = c;

        lastResult = result.toString();

        return result.toString();

    }

    /**
     * Metodo que ejecuta el boton porcentaje de la calculadora
     * @param c String con la expresion matematica
     * @return resultado de la operacion
     */
    public String porcentaje(String c) {
        Number result=0;

        if(c.contains(".")) {
            a = Double.parseDouble(c);
        }
        else{
            a = Integer.parseInt(c);
        }

        result = a.doubleValue()/ 100;

        result = result.doubleValue();

        return result.toString();

    }

    /**
     * Metodo que ejecuta el boton reciproco (1/x) de la calculadora
     * @param c String con la expresion matematica
     * @return resultado de la operacion
     */
    public String reciproco(String c) {

        Number result=0;

        if(c.contains(".")) {
            a = Double.parseDouble(c);
        }
        else{
            a = Integer.parseInt(c);
        }

        result = 1 / a.doubleValue();

        if (result.doubleValue() % 1 == 0) {

            result = result.intValue();

        } else {

            result = result.doubleValue();
        }


        return result.toString();
    }


    /**
     * Metodo que obtiene el cuadrado de un numero
     * @param c String con la expresion matematica
     * @return resultado de la operacion
     */
    public String cuadrado(String c) {
        Number result=0;

        if(c.contains(".")) {
            a = Double.parseDouble(c);
        }
        else{
            a = Integer.parseInt(c);
        }

        result = Math.pow(a.doubleValue(),2);

        if (result.doubleValue() % 1 == 0) {

            result = result.intValue();

        } else {

            result = result.doubleValue();
        }


        return result.toString();

    }


    /**
     * Metodo que obtiene la raiz cuadrada de un numero
     * @param c String con la expresion matematica
     * @return resultado de la operacion
     */
    public String raizCuadrado(String c) {
        Number result=0;

        if(c.contains(".")) {
            a = Double.parseDouble(c);
        }
        else{
            a = Integer.parseInt(c);
        }

        result = Math.sqrt(a.doubleValue());

        if (result.doubleValue() % 1 == 0) {

            result = result.intValue();

        } else {

            result = result.doubleValue();
        }


        return result.toString();

    }


    /**
     * Metodo que transforma una expresion matematica en carácteres en numeros para su posterior procesado
     * @param s String con la expresion matematica
     */

    private void converter(String s) {

        String[] num = new String[0];

        if (s.length() > 1) {

            num = splitString(s, num);


            if (num.length == 2) {

                length2(num);

            } else if (num.length == 4) {

                length4(num);

            } else if (num.length == 3) {
                length3(num);

            } else if (num.length == 1) {

                length1(num);


            } else {
                a = 0;
                b = 0;
            }


        } else {

            if (s.contains(".")) {
                a = Double.parseDouble(s);
            } else {
                a = Integer.parseInt(s);

            }

        }
    }

    /**
     * Metodo de uso interno en el metodo converter
     * @param num Array de String con los numeros separados
     */
    private void length1(String[] num) {
        if (num[0].contains(".")) {

            a = Double.parseDouble(num[0]);
            b = 0;

        } else {
            a = Integer.parseInt(num[0]);
            b = 0;
        }
    }

    /**
     * Metodo de uso interno en el metodo converter
     * @param num Array de String con los numeros separados
     */
    private void length3(String[] num) {
        int index = 0;
        if (num[0].isEmpty()) {
            index = 1;
        }
        a = Integer.parseInt(num[index]);
        b = -Integer.parseInt(num[2]);
        if (num[1].contains(".")) {

            a = -Double.parseDouble(num[index]);
            b = Integer.parseInt(num[2]);

        } else if (num[2].contains(".")) {

            a = Integer.parseInt(num[index]);
            b = -Double.parseDouble(num[2]);

        }
    }

    /**
     * Metodo de uso interno en el metodo converter
     * @param num Array de String con los numeros separados
     */
    private void length4(String[] num) {
        a = -Integer.parseInt(num[1]);
        b = -Integer.parseInt(num[3]);

        if (num[1].contains(".")) {
            a = -Double.parseDouble(num[1]);
            b = Integer.parseInt(num[3]);
        } else if (num[2].contains(".")) {
            a = -Integer.parseInt(num[1]);
            b = Double.parseDouble(num[3]);
        }
    }

    /**
     * Metodo de uso interno en el metodo converter
     * @param num Array de String con los numeros separados
     */
    private void length2(String[] num) {
        if (num[0].contains(".") && num[1].contains(".")) {
            a = Double.parseDouble(num[0]);
            b = Double.parseDouble(num[1]);

        } else if (num[1].contains(".")) {

            a = Integer.parseInt(num[0]);
            b = Double.parseDouble(num[1]);

        } else if (num[0].contains(".")) {
            a = Double.parseDouble(num[0]);
            b = Integer.parseInt(num[1]);
        } else {
            a = Integer.parseInt(num[0]);
            b = Integer.parseInt(num[1]);
        }
    }

    /**
     * Metodo para la sepacacion de la expresion matematica segun el simbolo
     * @param s String con la expresion matematica
     * @param num Array en el que se almacenan los numeros
     * @return Array final con el resultado
     */
    private static String[] splitString(String s, String[] num) {
        if (s.contains("+")) {
            num = s.split("\\+");

        }else if (s.contains("x")) {
            num = s.split("x");

        } else if (s.contains("/")) {
            num = s.split("/");
        } else if (s.contains("-")) {
            num = s.split("-");
        }
        return num;
    }
}








