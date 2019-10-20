/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author unifgvieira
 */
public class Cafe{
    
    public Ingrediente IC = new Ingrediente();

    public Ingrediente getIC() {
        return IC;
    }

    public Cafe() {
    }

    public Cafe(Ingrediente IC) {
        this.IC = IC;  
    }

    public void cafeExpresso(){
        IC.useCafe_po(18);
        IC.useAgua(180);
        IC.useSugar(15);
    }
    public void macchiato(){
        IC.useCafe_po(40);
        IC.useAgua(120);
        IC.useSugar(15);
        IC.useLeite(60);  
    }
    public void capuccino(){
        IC.useCafe_po(9);
        IC.useAgua(90);
        IC.useSugar(15);
        IC.useLeite(80);
    }
    public void cafePingado(){
        IC.useCafe_po(16);
        IC.useAgua(160);
        IC.useSugar(15);
        IC.useLeite(20);
    }
    public void cafeMocha(){
        IC.useCafe_po(6);
        IC.useAgua(60);
        IC.useSugar(15);
        IC.useLeite(60);
        IC.useLeite_vap(60);
        IC.useChocolate_po(40);
    }
    public void cafeLatte(){
        IC.useCafe_po(7.7);
        IC.useAgua(77);
        IC.useSugar(15);
        IC.useLeite(103);
    }
    
}
