package Hassen;

import java.util.*;
public class Route{

       private int num;
       private String nom;
       private Vector<Feu> f;
       private Vector<Vehicules> v;
      
       public Route(int num, String nom) {
             this.num = num;
             this.nom = nom;
             f= new Vector<Feu>();
             v= new Vector<Vehicules>();
       }
      
       public Vector<Vehicules> getVehicules()
       {
             return v;
       }
      
       public int getNum()
       {
             return num;
       }
      
       public String getString()
       {
             return nom;
       }
      
      
       public Vector<Feu> getF() {
             return f;
       }

       public void addFeu(Feu f1) {
             f.add(f1);
       }


       public void addVehicule(Vehicules v1) {
             v.add(v1);
       }

      

}