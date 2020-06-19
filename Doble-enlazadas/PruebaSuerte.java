import  java.util.Random ;
import java.io.*;
public class PruebaSuerte
{
 public static void main(String args[])throws IOException
 {
   InputStreamReader r = new InputStreamReader(System.in);
   BufferedReader Teclado =new BufferedReader(r);
 
   ListaDobleEnlazada L = new ListaDobleEnlazada();
   Random gen = new Random();
 
 String resp="";
 int cont=0, val=0;
 int Num=0;//Numero aleatorio
 
    for(int i=1; i<=5; i++)
    {
     System.out.println("Por favor dame un numero entero:");
     val= Integer.parseInt(Teclado.readLine());
     L.agregarAlFin(new Nodo<Integer>(val,1));
     cont++;
    }
   
 do{
     System.out.println("Deseas agregar otro numero S/N");
     resp= Teclado.readLine();
     
     if(resp.compareToIgnoreCase("S")==0)
     {
      System.out.println("Por favor dame un numero entero:");
      val= Integer.parseInt(Teclado.readLine());
      L.agregarAlFin(new Nodo<Integer>(val,1));
      cont++;
     }
   }while(resp.compareToIgnoreCase("S")==0);
 
 //imprime numeros
  System.out.println("*** ____________Tus numeros____________***\n");
  System.out.println(L);
  System.out.println(L.toStringReverse());
  
  System.out.println("\n_______________PROCESANDO..._______________\n");
  
  for(int i=1;i<=cont; i++)
  {
   
   if(i<cont)
   {
      Num=gen.nextInt(2);// 0 es cara y 1 es cruz
      
     // System.out.println("El numero es: "+Num);
      if(Num==0)
      {
       L.eliminarAlInicio();
      }
      if(Num==1)
      {
       L.eliminarAlFin();
      }
    }else{
    System.out.println("Se lanzo la moneda  "+cont+"  veces");
    System.out.println("Tu numero de la suerte: "+L);
     
    }
  }
  
 }
}