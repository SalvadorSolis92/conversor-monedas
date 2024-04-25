package view;

import controller.RestControllesExchangeRate;

import java.util.Scanner;

/**
 * Esta clase simula la vista que tendrá el usuario del sistema
 */
public class MenuCambio {

    //Variable para comunicarse con el controlador
    private RestControllesExchangeRate controller;

    public MenuCambio() {
        this.controller = new RestControllesExchangeRate();
    }

    /**
     * Muestra en consola el menú de interacción
     * para ingresar parametros al sistema
     */
    public void muestraMenu(){
        Integer op = 0;
        Double cantidad = 0.0;

        Scanner scanner = new Scanner(System.in);
        Scanner scannerMonBase = new Scanner(System.in);

        while (op != 7){
            System.out.println(
                    """
                            ***********************************
                            Bienvenido al conversor de monedas Alura
                            Por favor ingresa una opción 
                            1) Dólar a Peso Mexicano
                            2) Peso Mexicano a Dólar
                            3) Euro a Peso Mexicano
                            4) Peso Mexicano a Euro
                            5) Peso Mexicano a Peso Colombiano
                            6) Peso Colombiano a Peso Mexicano
                            7) Salir""");
            op = scanner.nextInt();
            switch (op){
                case 1://Dólar a Peso Mexicano
                    System.err.println("Por favor, introduce el monto en dólares que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("USD","MXN", cantidad);
                    break;
                case 2://Peso Mexicano a Dólar
                    System.err.println("Por favor, introduce el monto en pesos Mexicanos que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("MXN","USD", cantidad);
                    break;
                case 3://Euro a Peso Mexicano
                    System.err.println("Por favor, introduce el monto en Euros que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("EUR","MXN", cantidad);
                    break;
                case 4://Peso Mexicano a Euro
                    System.err.println("Por favor, introduce el monto en pesos Mexicanos que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("MXN", "EUR",cantidad);
                    break;
                case 5://Peso Mexicano a Peso Colombiano
                    System.err.println("Por favor, introduce el monto en pesos Mexicanos que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("MXN", "COP", cantidad);
                    break;
                case 6://Peso Colombiano a Peso Mexicano
                    System.err.println("Por favor, introduce el monto en pesos Colombianos que deseas convertir");
                    cantidad = scannerMonBase.nextDouble();
                    this.controller.convertirDivisa("COP","MXN", cantidad);
                    break;
                case 7:
                    System.err.println("""
                            Gracias por usar el conversor de Monedas
                            Este progrema fue desarrollado por Salvador Solis
                            . . .
                            """ );
                    break;
                default:
                    System.err.println("Por favor, elige una opción valida");
                break;
            }
        }//while
        scanner.close();
        scannerMonBase.close();
    }
}
