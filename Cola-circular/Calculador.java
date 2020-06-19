import  java.io.BufferedReader ;
import  java.io.IOException ;
import  java.io.InputStreamReader ; 
public class Calculador {
	public static void main (String[] args) throws IOException {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	String tmp=""; {
		int op1=0,op2=0,op3=0,op4=0,op5=0;
		double NumeSacado=0,NumeNuevo=0;
	BufferedReader Teclado =new BufferedReader (new InputStreamReader(System.in));
	ColaNumEntero Calcu=new ColaNumEntero(5);
	System.out.println("	Bienvenido a este programa!!! ");
	System.out.println("Elije la operacion:");
	System.out.println(" / DIVISION");
	System.out.println(" * MULTIPLICACION");
	System.out.println(" - RESTA");
	System.out.println(" + SUMA");
	tmp=(Teclado.readLine());
	try {
		System.out.println("Escribe el operando 1:");
		op1=Integer.parseInt(Teclado.readLine());
		Calcu.encolar(op1);
		System.out.println("Escribe el operando 2:");
		op2=Integer.parseInt(Teclado.readLine());
		Calcu.encolar(op2);
		System.out.println("Escribe el operando 3:");
		op3=Integer.parseInt(Teclado.readLine());
		Calcu.encolar(op3);
		System.out.println("Escribe el operando 4:");
		op4=Integer.parseInt(Teclado.readLine());
		Calcu.encolar(op4);
		System.out.println("Escribe el operando 5:");
		op5=Integer.parseInt(Teclado.readLine());
		Calcu.encolar(op5);
	}catch (ExceptionColaLlena Err) {
		System.out.println(Err.getMessage()); 
	}
	switch(tmp){
		case "/":
			try {
				while(!Calcu.colaVacia()){
					NumeSacado=Calcu.sacar();
						if(Calcu.ObtenerFrente()==1) {
							NumeNuevo=NumeSacado;
						}else{
							NumeNuevo=(NumeNuevo)/(NumeSacado);
						}
				}
			}catch(ExceptionColaVacia Err) {
				System.out.println(Err.getMessage());
			}
			break;
		case "*":
			try { 
				while(!Calcu.colaVacia()){  
					NumeSacado=Calcu.sacar();
						if(Calcu.ObtenerFrente()==1){
							NumeNuevo=NumeSacado;
						}else{ 
							NumeNuevo=NumeNuevo*NumeSacado;
						}
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
		case "-":
			try {
				while(!Calcu.colaVacia()){  
					NumeSacado=Calcu.sacar();
						if(Calcu.ObtenerFrente()==1){
							NumeNuevo=NumeSacado-NumeNuevo;
						}else{
							NumeNuevo=NumeNuevo-NumeSacado;
						} 
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
		case "+":
			try {
				while(!Calcu.colaVacia()){
					NumeSacado=Calcu.sacar();
					NumeNuevo=NumeSacado+NumeNuevo;
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
			default:
				System.out.println("NO SE A PODIDO ENCONTRAR LA OPCION DE LA OPERACION. INTENTE OTRA VEZ");
			break;
	}//Switch
	System.out.println("El resulado es: "+ NumeNuevo);
	System.out.println("Notacion Polaca: " + tmp + " " + op1 + " " + 
	op2 + " " + op3 + " " + op4 + " " + op5);
	}/////String
	}//static
}///public
