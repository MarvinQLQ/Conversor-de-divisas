import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        double monto = 0;
        ArrayList<Divisa> historialDivisas = new ArrayList<>();

        ConsultarDivisas consultarDivisas = new ConsultarDivisas();
        System.out.println("*******************************************");
        System.out.println("\n Bienvenido a el conversor de Divisas de Marvin");
        String menu = """
                
                1 - Dolar ==> Peso Argentino
                2 - Peso Argentino ==> Dolar
                3 - Dolar ==> Peso Mexicano
                4 - Peso Mexicano ==> Dolar
                5 - Dolar ==> Peso Colombiano
                6 - Peso Colombiano ==> Dolar
                7 - Convertir otras Divisas
                8 - Historial de converciones 
                9 - Salir
                
                ** Escribe el numero de la opcion deseada **
                """;


        while (opcion != 9) {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Conversion de Dolar a Peso Argentino");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        Divisa divisa = consultarDivisas.compararDivisas("USD", "ARS", monto);
                        System.out.println("El valor de "+monto+"USD "+"Corresponde a "+divisa.conversion_result()+"ARS");
                        historialDivisas.add(divisa);
                        break;
                    case 2:
                        System.out.println("Conversion de Peso argentino a Dolar");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        divisa = consultarDivisas.compararDivisas("ARS", "USD", monto);
                        System.out.println("El valor de "+monto+"ARS "+"Corresponde a "+divisa.conversion_result()+"USD");
                        historialDivisas.add(divisa);
                        break;
                    case 3:
                        System.out.println("Conversion de Dolar a Peso Mexicano");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        divisa = consultarDivisas.compararDivisas("USD", "MXN", monto);
                        System.out.println("El valor de "+monto+"USD "+"Corresponde a "+divisa.conversion_result()+"MXN");
                        historialDivisas.add(divisa);
                        break;
                    case 4:
                        System.out.println("Conversion de Peso mexicano a Dolar");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        divisa = consultarDivisas.compararDivisas("MXN", "USD", monto);
                        System.out.println("El valor de "+monto+"MXN "+"Corresponde a "+divisa.conversion_result()+"USD");
                        historialDivisas.add(divisa);
                        break;
                    case 5:
                        System.out.println("Conversion de Dolar a Peso Colombiano");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        divisa = consultarDivisas.compararDivisas("USD", "COP", monto);
                        System.out.println("El valor de "+monto+"USD "+"Corresponde a "+divisa.conversion_result()+"COP");
                        historialDivisas.add(divisa);
                        break;
                    case 6:
                        System.out.println("Conversion de Peso Colombiano a Dolar");
                        System.out.println("\nDigite el monto a Convertir ");
                        monto = teclado.nextDouble();
                        divisa = consultarDivisas.compararDivisas("COP", "USD", monto);
                        System.out.println("El valor de "+monto+"COP "+"Corresponde a "+divisa.conversion_result()+"USD");
                        historialDivisas.add(divisa);
                        break;
                    case 8:
                        System.out.println("Historial de Conversiones");
                        System.out.println(historialDivisas);
                        break;
                    default:
                        System.out.println("Opcion invalida ");
                        break;
                }


            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando Operacion");
            } catch (Exception e) {
                throw new RuntimeException(e);

            }

        }
}
    }
