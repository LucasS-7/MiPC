package com.mycompany.entradasteatromoro;
import java.util.Scanner;

public class Entradas {
    static double descuento, valorEntrada, valorTotal=0;
    static int tipoEntrada=3, contadorEntrada, opcion = 5;
    static String zonaEntrada= "";
    
    public static void Menu(){
    System.out.println("SELECCIONE UNA OPCION: ");   
    System.out.println("1-VENTA ENTRADAS");
    System.out.println("2-PROMOCIONES");
    System.out.println("3-BUSQUEDA ENTRADA");
    System.out.println("4-ELIMINAR ENTRADA");
    System.out.println("5-SALIR DEL PROGRAMA");
    } 
    public static void VentaEntrada(){ 
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("SELECCIONE LA ENTRADA QUE DESEA COMPRAR: ");
                    System.out.println("1-ENTRADA      VIP    || $15.000");
                    System.out.println("2-ENTRADA PLATEA BAJA || $12.000");
                    System.out.println("3-ENTRADA PLATEA ALTA || $10.OOO");
                    tipoEntrada = scanner.nextInt();
                    
        //VALOR DE ENTRADA SEGUN ZONA DE ASIENTO            
        switch (tipoEntrada){
                case 1: valorEntrada=15000; zonaEntrada="VIP";break;
                case 2: valorEntrada=12000; zonaEntrada="PLATEA BAJA";break;
                case 3: valorEntrada=10000; zonaEntrada="PLATEA ALTA";break;
                default:System.out.println("Por favor, ingrese una opcion valida");return;}
        
        //APLICAR DESCUENTO SEGUN EDAD 
        System.out.print("POR FAVOR INGRESE SU EDAD: ");
        int edad = scanner.nextInt();
        if(edad>=65){System.out.println("Eres ADULTO MAYOR, tienes un 15% de Dcto.");descuento = 0.15;}                            
        else if (edad>9  && edad<26){System.out.println ("Eres ESTUDIANTE, tienes un 10% de Dcto.");descuento=0.10;}
        else {System.out.println("Lo siento, NO tienes descuentos aplicables");descuento=0;} contadorEntrada++;
    } 
    public static void MostrarPromociones(){
    System.out.println("**************PROMOCIONES*************");
    System.out.println("SI ERES ESTUDIANTE, TIENES UN 10% DE DESCUENTO");
    System.out.println("SI ERES ADULTO MAYOR, TIENES UN 15% DE DESCUENTO");
    System.out.println("**************************************");
    } 
    public static void MostrarEntrada(){
                if(contadorEntrada>=1){
                valorTotal = valorEntrada-(valorEntrada*descuento);
                System.out.println("***************************************");
                System.out.println("Su asiento se encuentra en la Zona: "+zonaEntrada);
                System.out.println("Precio Base Entrada: $"+ (int)valorEntrada);
                System.out.println("Descuento aplicado de: %"+(int)(100*descuento));
                System.out.println("Precio final a pagar: $"+ (int)valorTotal);
                System.out.println("***************************************");
                }
                else {System.out.println("PARA ESTA OPCION DEBE COMPRAR UNA ENTRADA PRIMERO");
                System.out.println("***************************************");}} 
    public static void EliminarEntrada(){
                Scanner scanner = new Scanner(System.in);
                if(contadorEntrada>=1){
                System.out.println("DESEA ELIMINAR SU ENTRADA? (1-SI/2-NO)");
                int eliminarEntrada = scanner.nextInt();
                
                if (eliminarEntrada==1){System.out.println("ENTRADA ELIMINADA!");contadorEntrada--;} //OPCION 1: ELIMINAR ENTRADA
                else if (eliminarEntrada==2){System.out.println("ENTRADA CONSERVADA");}              //OPCION 2: NO ELIMINAR, SE CONSERVA
                else {System.out.println("DEBE INGRESAR UNA OPCION VALIDA");}
                }
                else {System.out.println("PARA ESTA OPCION DEBE COMPRAR UNA ENTRADA PRIMERO");
                System.out.println      ("***************************************");}
    
    
    
    } 
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("**BIENVENIDO A TEATRO MORO**");
        
       while (opcion>=1 && opcion<=5 ){
            Entradas.Menu();
            opcion= scanner.nextInt();
        
        //SEGUN OPCION DEL MENÚ    
         switch (opcion){
            
        //OPCION 1: VENTA DE ENTRADA    
           case 1: 
                Entradas.VentaEntrada();
                break; 
        //OPCION 2: PROMOCIONES 
            case 2:
                Entradas.MostrarPromociones();
                break;
        //OPCION 3:MOSTRAR DATOS DE LA ENTRADA        
            case 3:
                Entradas.MostrarEntrada();
                break;
        //OPCION 4: ELIMINAR ENTRADA        
            case 4:
                Entradas.EliminarEntrada();
                break;
        //OPCION 5: SALIR DEL PROGRAMA        
            case 5:    
                System.out.println("SALIENDO DEL PROGRAMA... NOS VEMOS PRONTO!");
                break;
            default: System.out.print("INGRESE UNA OPCION VALIDA"); 
      }  
    }
   scanner.close();     
  }
}    
