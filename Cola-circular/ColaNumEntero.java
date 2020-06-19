public class ColaNumEntero {
		private int Esquina[];
		private int Frente;
		private int Siguiente;
		public ColaNumEntero (int N){
			Esquina = new int[N];
			//Posicion inicial de Sigiente
			Siguiente =0;
			//Posicion inicial de frente
			Frente = -1;
		}
		public boolean colaLlena(){
			if(Siguiente ==Esquina.length){
				return true;
			}else{
				return false;
			}
		}
		public int ObtenerFrente() {
			return Frente;
    }
		//se agregan los elementos
		public void encolar(int Num) throws ExceptionColaLlena{
		//Si la cola esta vasia
			if(colaVacia()&&(evalEspacio()==true)){
				System.out.println("//rRei");
				Frente = -1;
				Siguiente = 0;
		}
		if(colaLlena()){
			throw new ExceptionColaLlena(); 
		}
			Esquina[Siguiente] = Num;
			Siguiente++;
			//cuando se agrega el primer el elemento
			if(Siguiente == 1){}
				Frente = 0;
			}
		//sacar los elementos
		public int sacar()throws ExceptionColaVacia{
			if(colaVacia()){
			throw new ExceptionColaVacia();
			}
			int valor = Esquina[Frente];
			Frente ++;
			return valor;
		}
		public boolean colaVacia(){
			if(Frente == Siguiente){
				return true;
			}
			else if(Frente == -1){
				return true;
			}else {
				return false;
			}
		}
		public  boolean  evalEspacio () {
			int  Vacias ;
			Vacias = (( Frente + 1 ) % Esquina.length);
				if ( Vacias > 0 ) {
					return true ;
				}else{
					return false;
				}
		}
}
