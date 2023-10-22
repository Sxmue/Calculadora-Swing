package ui;

import lombok.extern.java.Log;
import org.example.Calculadora;
import org.example.Main;

import javax.swing.*;
import java.util.Objects;

/**
 * Clase para la ventana
 */
@Log
public class VentanaCalculadora extends JFrame {

    /*Instancia de calculadora*/
    Calculadora c = new Calculadora();

    /*String que almacena todas las operaciones*/
    String cuenta = "";

    /*String que guarda la ultima operacion matematica*/
    String ultimaOperacion = "";

    private JPanel panel1;
    private JLabel txtHistory;
    private JLabel txtOp;
    private JButton btnNumNegativo;
    private JButton btnReciproco;
    private JButton btnPorcentaje;
    private JButton btnDivision;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnMultiplicar;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnRestar;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnMas;
    private JButton tbn0;
    private JButton btnComa;
    private JButton btnIgual;
    private JButton btnAlCuadrado;
    private JButton btnRaizCuadrado;
    private JButton btnC;
    private JButton btnBorrar;


    /**
     * Constructor de la clase VentanaCalculadora
     */
    public VentanaCalculadora() {


        //Configuracion de la ventana
        windowConfiguration();




        /*----------------------------LISTENERS---------------------------------------*/
        btnAlCuadrado.addActionListener(e -> {

            if (!cuenta.isEmpty() && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {

                cuenta = c.cuadrado(cuenta);
                if (cuenta.length() > 13) {
                    txtOp.setText(cuenta.substring(0, 13));

                } else txtOp.setText(cuenta);
            }

        });

        btnRaizCuadrado.addActionListener(e -> {
            if (!cuenta.isEmpty() && esNumero(cuenta.charAt(0)) && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {

                cuenta = c.raizCuadrado(cuenta);
                if (cuenta.length() > 13) {
                    txtOp.setText(cuenta.substring(0, 13));

                } else txtOp.setText(cuenta);
            }

        });

        btnC.addActionListener(e -> {

            cuenta = "0";
            txtOp.setText(cuenta);
            ultimaOperacion = "";
            txtHistory.setText(ultimaOperacion);
        });

        btnBorrar.addActionListener(e -> {
            if (!cuenta.isEmpty()) {
                cuenta = cuenta.substring(0, cuenta.length() - 1);
                txtOp.setText(cuenta);
            }

        });

        btnNumNegativo.addActionListener(e -> {
            if (!cuenta.isEmpty() && esNumero(cuenta.charAt(0)) && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {
                cuenta = "-" + cuenta;
                txtOp.setText(cuenta);
            }

        });

        btnReciproco.addActionListener(e -> {

            if (!cuenta.isEmpty() && esNumero(cuenta.charAt(0)) && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {
                cuenta = c.reciproco(cuenta);
                if (cuenta.length() > 13) {
                    txtOp.setText(cuenta.substring(0, 13));

                } else txtOp.setText(cuenta);
            }


        });

        btnPorcentaje.addActionListener(e -> {

            if (!cuenta.isEmpty() && esNumero(cuenta.charAt(0)) && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {

                cuenta = c.porcentaje(cuenta);
                if (cuenta.length() > 13) {
                    txtOp.setText(cuenta.substring(0, 13));

                } else txtOp.setText(cuenta);
            }


        });

        btnDivision.addActionListener(e -> {

            if (!cuenta.contains("/")&& !cuenta.isEmpty()) {
                cuenta += "/";
                txtOp.setText(cuenta);
            }

        });
        btnMas.addActionListener(e -> {

            if (!cuenta.contains("+") && Boolean.TRUE.equals(!tieneSimbolo(cuenta)) && !cuenta.isEmpty()) {
                cuenta += "+";
                txtOp.setText(cuenta);
            }

        });

        btnComa.addActionListener(e -> {

            if (!Objects.equals(cuenta, "")) {
                cuenta += ".";
                txtOp.setText(cuenta);
            }

        });
        btnIgual.addActionListener(e -> {

            if (Boolean.TRUE.equals(tieneSimbolo(cuenta)) || contarMenos()==2  ) {

                txtOp.setText("");
                operation(cuenta);
                ultimaOperacion = c.getLastOperation();
                txtHistory.setText(ultimaOperacion);
                cuenta = c.getLastResult();
            }

        });

        btnMultiplicar.addActionListener(e -> {

            if (!cuenta.contains("x")&& !cuenta.isEmpty()) {
                cuenta += "x";
                txtOp.setText(cuenta);
            }

        });

        btnRestar.addActionListener(e -> {

            if (cuenta.equals("0")) {

                cuenta = "-";
                txtOp.setText(cuenta);
            }

            if(cuenta.isEmpty()){
                cuenta += "-";
                txtOp.setText(cuenta);
            }





            if (!cuenta.isEmpty() && !cuenta.equals("0") && !cuenta.equals("-")) {

                if (cuenta.contains("-") ){

                    if((Boolean.FALSE.equals(tieneSimbolo(cuenta)))) {
                        cuenta += "-";
                        txtOp.setText(cuenta);

                    }else if(Boolean.TRUE.equals(tieneSimbolo(cuenta) && cuenta.charAt(0)!='-') && contarMenos()<2 && !cuenta.contains("x") && !cuenta.contains("/")){

                            cuenta += "-";
                            txtOp.setText(cuenta);

                    }else if(Boolean.TRUE.equals(tieneSimbolo(cuenta) && cuenta.charAt(0)!='-') && contarMenos()<2 && (cuenta.contains("x") || cuenta.contains("/")) && cuenta.charAt(cuenta.length()-1)!='-' ){

                        cuenta += "-";
                        txtOp.setText(cuenta);

                    }


                }

                if (!cuenta.contains("-") && Boolean.TRUE.equals(!tieneSimbolo(cuenta))) {

                    cuenta += "-";
                    txtOp.setText(cuenta);

                }


                if ((cuenta.charAt(cuenta.length() - 1) != '-') &&

                        (tieneSimbolo(cuenta) && !esNumero((cuenta.charAt(cuenta.length() - 1))))) {


                    if (cuenta.contains("-")) {

                        if (!comprobarMenos()) {
                            cuenta += "-";
                            txtOp.setText(cuenta);
                        }

                    } else {

                        cuenta += "-";
                        txtOp.setText(cuenta);
                    }

                }




            }

        });


        /*------------------NUMEROS------------------*/
        btn7.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "7";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 7;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn8.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "8";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 8;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn9.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "9";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 9;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn4.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "4";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 4;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn5.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "5";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 5;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn6.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "6";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 6;
                    txtOp.setText(cuenta);
                }
            }
        });

        btn1.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "1";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 1;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn2.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "2";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 2;
                    txtOp.setText(cuenta);
                }
            }
        });
        btn3.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "3";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 3;
                    txtOp.setText(cuenta);
                }
            }
        });
        tbn0.addActionListener(e -> {
            if (cuenta.length() <= 13) {
                if (Objects.equals(cuenta, "0")) {
                    cuenta = "0";
                    txtOp.setText(cuenta);
                } else {
                    cuenta += 0;
                    txtOp.setText(cuenta);
                }
            }
        });


    }

    /**
     * Metodo para la configuracion de la ventana
     */
    private void windowConfiguration() {
        this.setResizable(false);
        this.setContentPane(panel1);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Main.class.getClassLoader().getResource("img/calculadora.png")).getImage());
    }

    /**
     * Metodo para mostrar la ventana
     */
    public void load() {
        setVisible(true);
    }

    /**
     * Metodo que selecciona la operacion matematica deseada
     *
     * @param s String con la operacion matematica completa
     */
    public void operation(String s) {

        if (s.contains("+")) {

            txtOp.setText(c.suma(cuenta));

        } else if (s.contains("x")) {

            txtOp.setText(c.multiplicar(cuenta));

        } else if (s.contains("/")) {

            txtOp.setText(c.dividir(cuenta));

        } else if (s.contains("-")) {

            //COMPROBAR 6--9
            if (contarMenos() == 3 || contarMenos() == 2) {
                txtOp.setText(c.suma(cuenta));
            } else {
                txtOp.setText(c.resta(cuenta));
            }

        }
    }

    /**
     * Metodo que comprueba si una operacion tiene ya el simbolo puesto o no
     *
     * @param s String con la operacion matematica
     * @return boolean con el resultado de la comprobacion
     */
    public Boolean tieneSimbolo(String s) {

        boolean simbolo = false;

        if (s.contains("+")) {

            simbolo = true;

        } else if (s.contains("x")) {

            simbolo = true;

        } else if (s.contains("/")) {

            simbolo = true;

        } else if (s.contains("-")) {

            if (s.charAt(0) != '-') {

                if(s.charAt(s.length()-1)!='-' ) {
                    if (s.charAt(s.lastIndexOf("-") - 1) == '-' || (esNumero(s.charAt(s.indexOf("-") - 1)) && esNumero(s.charAt(s.indexOf("-") + 1)))) {

                        simbolo = true;

                    }
                }else {
                    simbolo = true;
                }

            } else if (s.charAt(0) == '-') {

                if (s.lastIndexOf('-') != 0 &&

                        ( s.lastIndexOf("-") == s.length() ||

                                s.charAt(s.lastIndexOf("-") - 1) == '-')) {

                    simbolo = true;


                }

            }
        }


        return simbolo;
    }

    /**
     * Metodo para la comprobacion de los simbolos menos
     *
     * @return boolean con el resultado de la comprobacion
     */
    public boolean comprobarMenos() {
        boolean result = false;
        int index = 0;

        index = cuenta.lastIndexOf("-");

        if ((index > 0) && cuenta.charAt(index - 1) == '-') {

            result = true;
        }

        return result;
    }

    /**
     * Metodo para contar cuantos simbolos menos tiene una expresion matematica
     *
     * @return numero de simbolos menos en la expresion matematica
     */
    public Integer contarMenos() {
        int contador = 0;
        for (int x = 0; x < cuenta.length(); x++) {
            if (cuenta.charAt(x) == '-') {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Metodo para comprobar si un caracter determinado es un numero o no
     *
     * @param c el caracter recibido para la comprobacion
     * @return boolean con el resultado de la comprobacion
     */
    public boolean esNumero(char c) {
        return switch (c) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }

}



