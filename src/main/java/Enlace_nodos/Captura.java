package Enlace_nodos;

/**
 *
 * @author Jorge Malaver
 */
//import java.util.Random();
import Creacion_nodo.Nodo;
import java.util.Random;
import javax.swing.JOptionPane;


public class Captura {
    public int i,total,numero,num1,num2,num3;
    public Nodo p,q,cab=null,aux;
     String mostrar="";
     Random rnd = new Random();
    public void Generacion_enlace(){
        num3= 1+ rnd.nextInt(12);    
    for(i=0;i<=num3;i++) {
        
        if(cab==null){
            num2= 1+ rnd.nextInt(15);
            q=new Nodo();
            q.num=num2;
            q.sig=null;
            q.ant=null;
            cab=q;
            p=q;
        }
        else{
            num2= 1+ rnd.nextInt(15);
            q=new Nodo();
             q.num=num2;
             q.ant=cab;
             cab.sig=q;
             q.sig=null;
             cab=q;
                   
        }
    }  // cierra for
       
        
  }  // cierra el metodo  
   
  public void imprimir(){
      
      aux=p;
      while(aux.sig!=null){
        // System.out.print(aux.num + "  ");
        mostrar = mostrar + "    " + aux.num;
          aux=aux.sig;
      } // while
          
     JOptionPane.showMessageDialog(null,"RESULTADOS\n" + mostrar);
      mostrar="";
  }// imprimir 
  
  public void eliminarPorNumero(int numero) {
    Nodo actual = p;
    while (actual != null) {
        if (actual.num == numero) {
            // Si es el primer nodo
            if (actual.ant == null) {
                p = actual.sig;
                if (p != null) {
                    p.ant = null;
                }
            } else {
                actual.ant.sig = actual.sig;
            }
            // Si es el último nodo
            if (actual.sig == null) {
                cab = actual.ant;
            } else {
                actual.sig.ant = actual.ant;
            }
            JOptionPane.showMessageDialog(null, "Nodo con número " + numero + " eliminado.");
            return;
        }
        actual = actual.sig;
    }
    JOptionPane.showMessageDialog(null, "No se encontró un nodo con el número " + numero + ".");
  }

  public void eliminarPrimerosN(int n) {
    int count = 0;
    while (p != null && count < n) {
        Nodo siguiente = p.sig;
        p = siguiente;
        if (p != null) {
            p.ant = null;
        }
        count++;
    }
    if (p == null) {
        cab = null;
    }
    JOptionPane.showMessageDialog(null, "Se eliminaron los primeros " + count + " nodos.");
  }
    
  public String obtenerListaComoTexto() {
    StringBuilder sb = new StringBuilder();
    Nodo actual = p;
    while (actual != null) {
        sb.append(actual.num).append(" ");
        actual = actual.sig;
    }
    return sb.length() > 0 ? sb.toString() : "(Lista vacía)";
}
}// ciarra la clase
