public class ListaDobleEnlazada
{
 //Referencia al inicio
  private Nodo Inicio;
 //Referencia al final
  private Nodo Fin;
  private int NoElementos;
  
  public ListaDobleEnlazada()
  {
    Inicio = null;
    Fin= null;
    NoElementos=0;
  }
   public int obtenerNoElementos()
   {
    return NoElementos;
   }
   
  public void agregarAlInicio(Nodo AG)
  {
  //Caso cuando no tengo Nodos
   if(Inicio ==null)
   {
    Inicio=AG;
    Fin=AG;
    NoElementos++;
   }else{
   //Mi lista al menos tiene un Nodo
   AG.Siguiente= Inicio;
   Inicio.Anterior= AG;
   Inicio= AG;
   NoElementos++; 
   }
  }
 
  public void agregarAlFin(Nodo AG)
  {
  //Caso cuando no tengo Nodos
   if(Fin==null)
   {
    Fin=AG;
    Inicio=AG;
    NoElementos++;
   }else{
    //Mi lista al menos tiene un Nodo
    Fin.Siguiente=AG;
    AG.Anterior = Fin;
    Fin=AG;
    NoElementos++;
   }
  }
   
  public boolean buscar(Nodo AB)
  {
  //Nodo no es null
   if(AB != null)
   {
    if(Inicio != null)
    {
      if(Inicio.obtenerData() == AB.obtenerData())
      {
       return true;
      }
    }
    if(Fin != null)
    {
      if(Fin.obtenerData() == AB.obtenerData())
      {
       return true;
      }
    }
    //Si el elemento a buscar no está ni en inicio o fin
    Nodo ref = Inicio;
    boolean Encontrado= false;
    while((ref != null) && !Encontrado)
    {
    
        if(ref.obtenerData() == AB.obtenerData())
        {
         Encontrado = true;
        }
        ref = ref.Siguiente;
     }
    return Encontrado;
   }
   return false;// si AB es null no tengo nada que buscar
  }
  
  public Nodo eliminarAlInicio()
  {
     if(Inicio == null)
     {
      return null;
     }else{
      Nodo Ret = Inicio;
      Inicio = Inicio.Siguiente;
      Inicio.Anterior= null;
      Ret.Siguiente = null;
      Ret.Anterior = null;
      NoElementos--;
      return Ret;
     }
  }
  
  public Nodo eliminarAlFin()
  {
     if(Fin == null)
     {
      return null;
     }else{
     
       Nodo eliminar = Fin;
       Fin = Fin.Anterior;
       Fin.Siguiente = null;
       
       eliminar.Siguiente = null;
       eliminar.Anterior = null;
       
       NoElementos--;
       return eliminar;
     }
  }
   
  public Nodo eliminarPorNodo(Nodo AB)
  {
   if(AB == null)
   {
    return null;
   }
     if(Fin == null)
     {
      return null;
     }else{
     
      /////////////////////////
      if(Inicio.obtenerData()== AB.obtenerData())
      {
       return this.eliminarAlInicio();
      }
      ////////////////////////
      if(Fin.obtenerData()== AB.obtenerData())
      {
       return this.eliminarAlFin();
      }
      ////////////////////////
        
       Nodo refRojo = Inicio;
       Nodo refAzul= null;
       Nodo refElim=null;
       boolean Encontrado=false;
       while((refRojo != null) && !Encontrado)
       {
        if(refRojo.obtenerData() == AB.obtenerData())
        {
         Encontrado = true;
         refElim = refRojo;
         NoElementos--;
        }
        refRojo = refRojo.Siguiente;
       } 
       if(Encontrado)
       {
         refRojo = refElim.Anterior;
         refAzul = refElim.Siguiente;
         refRojo.Siguiente = refAzul;
         refAzul.Anterior = refRojo;
         refElim.Siguiente =null;
         refElim.Anterior =null;
         
       }
       
      return refElim;
     }
  }
  
  public String toString()
   {
     String temp="";
     if(Inicio==null)
     {
      return "";
     }
     Nodo ref=Inicio;
     while(ref!=null)
     {
      temp = temp + "  " + ref.toString();
      ref=ref.Siguiente;
     }
     return temp;
   }
    public String toStringReverse()
   {
     String temp="";
     if(Fin==null)
     {
      return "";
     }
     Nodo ref=Fin;
     while(ref!=null)
     {
      temp = temp + "  " + ref.toString();
      ref=ref.Anterior;
     }
     return temp;
   }

   
   public Nodo porIndice(int p)
   {
    if(Inicio == null)
    {
     return null;
    }
    if(p >= NoElementos)
    {
     return null;
    }
    if(p < 0)
    {
     return null;
    }
    int i=0;
    Nodo ref= Inicio;
    for(;i < p; i++)
    {
      ref = ref.Siguiente;
    }
    
    //Obtener tipo de Dato para Nodo
    switch(ref.obtenerTipo())
    {
     case 1:
            ref = new Nodo<Integer>((int) ref.obtenerData(),1);
     break; 
     case 2:
            ref = new Nodo<Double>((double) ref.obtenerData(),2);
     break; 
     case 3:
            ref = new Nodo<String>(" "+ ref.obtenerData(),3);
     break; 
     case 4:
            ref = new Nodo<Float>((float)ref.obtenerData(),4);
     break; 
     case 5:
            ref = new Nodo<Boolean>((boolean)ref.obtenerData(),5);
     break;
     case 6:
            ref = new Nodo<Character>((char)ref.obtenerData(),6);
     break;
     case 7:
            ref = new Nodo<Short>((short)ref.obtenerData(),7);
     break;   
     case 8:
            ref = new Nodo<Long>((long)ref.obtenerData(),8);
     break;
     /*
      //Para un caso personalizado, como estudiante
      //Si se quiere implementar entonces tendríamos 
      //que modificar la clase ListaDobleEnlazada
     
     default:
     
          ref = new Nodo(ref.obtenerData(),ref.obtenerTipo()); 
     no lleva break*/
    }
    
    return ref;
   }
}