public class Nodo<T>
{
 public Nodo Anterior;
 public Nodo Siguiente;
 private int Tipo;
 private  T Data;
 /*
  *Si tipo = 1 entonces es un int
  *Si tipo = 2 entonces es double
  *Si tipo = 3 entonces es String
  *Si tipo = 4 entonces es float
  *Si tipo = 5 entonces es boolean
  *Si tipo = 6 entonces es char
  *Si tipo = 7 entonces es short
  *Si tipo = 8 entonces es long
  *Si tipo > 10 entonces es personalizado (Estudiante etc)
 */
  public Nodo (T Data, int Tipo)
  {
   this.Tipo = Tipo;
   this.Data = Data;
   Anterior = null;
   Siguiente = null;
  }
  public T obtenerData()
  {
   return Data;
  }
  public void asignarData(T Data)
  {
   this.Data = Data;
  }
  public String toString()
  {
   return "" + Data;
  }
  public int obtenerTipo()
  {
   return Tipo;
  }
}