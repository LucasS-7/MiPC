package com.mycompany.entradasteatromoro;
import java.util.Scanner;

public class Entradas {
    static double descuento, valorEntrada, valorTotal=0;
    static int tipoEntrada=3, contadorEntrada, opcion = 5;
    static String zonaEntrada= "";
    static int columnas  = 5;
    static int filas = 6;
    static char [][] asientos = new char [filas][columnas];
    
    public static void Menu(){
    System.out.println("SELECCIONE UNA OPCION: ");   
    System.out.println("1-VENTA ENTRADAS");
    System.out.println("2-PROMOCIONES");
    System.out.println("3-BUSQUEDA ENTRADA");
    System.out.println("4-ELIMINAR ENTRADA");
    System.out.println("5-SALIR DEL PROGRAMA");
    } 
    public static  void InicializarAsientos(){
        
                    for (int filas=0;filas<6;filas++){
                       for(int columnas=0;columnas<5;columnas++){
                           asientos[filas][columnas] = ' ';
                      }
                    }
    }
    public static void MostrarAsientos(){
                    System.out.println("**********************************************");
                    System.out.println("Plano de los Asientos de la zona "+zonaEntrada);
                    System.out.println("[ ] --> Asiento Disponible/ [X] --> Asiento Reservado");
                    for (int filas= 0;filas<6;filas++){
                     System.out.print("Fila"+ filas +": ");
                     for (int columnas=0;columnas<5;columnas++){
                     System.out.print(" ");
                     if (asientos [filas][columnas]=='X'){System.out.print("[X]");}
                     else System.out.print("[ ]");
                     }
         System.out.println();
        }
     }
    public static boolean ReservaDeAsientos(int filas, int columnas){
                if (asientos[filas][columnas]== 'X'){return false;}
                else{asientos [filas][columnas]='X'; return true;}
    }
    public static void VentaEntrada(){ 
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("SELECCIONE LA ENTRADA QUE DESEA COMPRAR: ");
                    System.out.println("1-ENTRADA      VIP    || $15.000");
                    System.out.println("2-ENTRADA PLATEA BAJA || $12.000");
                    System.out.println("3-ENTRADA PLATEA ALTA || $10.OOO");
                    tipoEntrada = scanner.nextInt();}           
    public static void ValorEntradaPorZona(){                
        //VALOR DE ENTRADA SEGUN ZONA DE ASIENTO            
        switch (tipoEntrada){
                case 1: valorEntrada=15000; zonaEntrada="VIP";break;
                case 2: valorEntrada=12000; zonaEntrada="PLATEA BAJA";break;
                case 3: valorEntrada=10000; zonaEntrada="PLATEA ALTA";break;
                default:System.out.println("Por favor, ingrese una opcion valida");return;}}
    public static void DescuentoPorEdad(){    
        //APLICAR DESCUENTO SEGUN EDAD 
        Scanner scanner = new Scanner(System.in);
        System.out.print("POR FAVOR INGRESE SU EDAD: ");
        int edad = scanner.nextInt();
        if(edad>=65){System.out.println("Eres ADULTO MAYOR, tienes un 15% de Dcto.");descuento = 0.15;}                            
        else if (edad>9  && edad<26){System.out.println ("Eres ESTUDIANTE, tienes un 10% de Dcto.");descuento=0.10;}
        else {System.out.println("Lo siento, NO tienes descuentos aplicables");descuento=0;} contadorEntrada++;
        System.out.println("***********************************");
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
                System.out.println("*** UBICACION DE SU ASIENTO ***");
                System.out.println("****** "+zonaEntrada+" ********");
                       for (int filas= 0;filas<6;filas++){
                     System.out.print("Fila"+ filas +": ");
                     for (int columnas=0;columnas<5;columnas++){
                     System.out.print(" ");
                     if (asientos [filas][columnas]=='X'){System.out.print("[X]");}
                     else System.out.print("[ ]");
                     }
                System.out.println();
                     }
                System.out.println("***************************************");
                }
                else {System.out.println("PARA ESTA OPCION DEBE COMPRAR UNA ENTRADA PRIMERO");
                System.out.println("***************************************");}} 
    public static void EliminarEntrada(){
                Scanner scanner = new Scanner(System.in);
                if(contadorEntrada>=1){
                System.out.println("DESEA ELIMINAR SU ENTRADA? (1-SI/2-NO)");
                int eliminarEntrada = scanner.nextInt();
                
                if (eliminarEntrada==1){
                    for (int filas=0;filas<6;filas++){
                       for(int columnas=0;columnas<5;columnas++){
                           asientos[filas][columnas] = ' ';}}
                    System.out.println("ENTRADA ELIMINADA!");contadorEntrada--;}    //OPCION 1: ELIMINAR ENTRADA
                else if (eliminarEntrada==2){System.out.println("ENTRADA CONSERVADA");}              //OPCION 2: NO ELIMINAR, SE CONSERVA
                else {System.out.println("DEBE INGRESAR UNA OPCION VALIDA");}
                }
                else {System.out.println("PARA ESTA OPCION DEBE COMPRAR UNA ENTRADA PRIMERO");
                System.out.println      ("***************************************");} 
    } 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("**BIENVENIDO A TEATRO MORO**");
        
       while (opcion>=1 && opcion<=5){
            Entradas.Menu(); //MOSTRAR MENÚ
            opcion= scanner.nextInt();
        
        //SEGUN OPCION DEL MENÚ    
         switch (opcion){
            
        //OPCION 1: VENTA DE ENTRADA    
           case 1: 
                Entradas.VentaEntrada(); // SELECCION TIPO DE ENTRADA
                Entradas.ValorEntradaPorZona(); // ASGINAR VALOR DE LA ENTRADA SEGUN TIPO DE ENTRADA
                Entradas.MostrarAsientos(); // MOSTRAR ASIENTOS DISPONIBLES
                
                //PEDIMOS AL USUARIO INGRESAR DONDE DESEA TENER SU ASIENTO (FILA Y COLUMNA)
                System.out.println("Por favor ingrese N* de FILA (0 AL 5)");
                filas = scanner.nextInt();
                System.out.println("Por favor ingrese N* de COLUMNA (0 AL 4)");
                columnas = scanner.nextInt();
                if (Entradas.ReservaDeAsientos(filas, columnas))System.out.println("ASIENTO RESERVADO!");
                else System.out.println("LO SENTIMOS ASIENTO OCUPADO");  
                
                Entradas.DescuentoPorEdad(); //DESCUENTO ASOSIADO SEGUN EDAD 
                break; 
        //OPCION 2: PROMOCIONES 
            case 2:
                Entradas.MostrarPromociones(); //MOSTRAR PROMOCIONES SEGUN (3ERA EDAD Y SEGUN SI ES ESTUDIANTE)
                break;
        //OPCION 3:MOSTRAR DATOS DE LA ENTRADA        
            case 3:
                Entradas.MostrarEntrada(); //MOSTRAR LOS DATOS DE LA ENTRADA (UBICACION/PRECIO/DESCUENTO)
                
                break;
        //OPCION 4: ELIMINAR ENTRADA        
            case 4:
                Entradas.EliminarEntrada(); // ELIMINAMOS ENTRADA
                break;
        //OPCION 5: SALIR DEL PROGRAMA        
            case 5:    
                System.out.println("SALIENDO DEL PROGRAMA... NOS VEMOS PRONTO!");
                opcion++;
                break;
                
            default: System.out.print("INGRESE UNA OPCION VALIDA"); 
      }  
    }
   scanner.close();     
  }
}    
