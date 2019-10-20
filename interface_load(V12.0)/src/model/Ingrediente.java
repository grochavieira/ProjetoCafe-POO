/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author unifgvieira
 */
public class Ingrediente{
    public double cafe_po;
    public double sugar;
    public double agua;
    public double leite;
    public double chocolate_po;
    public double leite_vap;

    public Ingrediente(double cafe_po, double sugar, double agua, double leite, double chocolate_po, double leite_vap) {
        this.cafe_po = cafe_po;
        this.sugar = sugar;
        this.agua = agua;
        this.leite = leite;
        this.chocolate_po = chocolate_po;
        this.leite_vap = leite_vap;
    }

    
    public Ingrediente() {
        ArrayList <String> pegaIngredienteArquivo = new ArrayList<>();
        try{
                FileReader cafeArquivo = new FileReader("Cafe.txt");
                BufferedReader br = new BufferedReader(cafeArquivo);
                String str; 
                while((str = br.readLine()) != null)
                {
                    str = str.replace(",", ".");
                    pegaIngredienteArquivo.add(str);
                }
                this.cafe_po = Double.parseDouble(pegaIngredienteArquivo.get(0));
                this.sugar = Double.parseDouble(pegaIngredienteArquivo.get(1));
                this.agua = Double.parseDouble(pegaIngredienteArquivo.get(2));
                this.leite = Double.parseDouble(pegaIngredienteArquivo.get(3));
                this.chocolate_po = Double.parseDouble(pegaIngredienteArquivo.get(4));
                this.leite_vap = Double.parseDouble(pegaIngredienteArquivo.get(5));
        }
        catch(IOException e)
        {
            System.out.println("- Arquivo não encontrado!");
        }
 
    }
    
    public void salvarIngredientes() {
        ArrayList <String> pegaIngredienteArquivo = new ArrayList<>();
        try{
                FileWriter cafeArquivo = new FileWriter("Cafe.txt");
                PrintWriter escritaArquivo = new PrintWriter(cafeArquivo);
                
                escritaArquivo.printf("%.2f\n", cafe_po);
                escritaArquivo.printf("%.2f\n", sugar);
                escritaArquivo.printf("%.2f\n", agua);
                escritaArquivo.printf("%.2f\n", leite);
                escritaArquivo.printf("%.2f\n", chocolate_po);
                escritaArquivo.printf("%.2f\n", leite_vap);
    
                cafeArquivo.close();
        }
        catch(IOException e)
        {
            System.out.println("- Arquivo não encontrado!");
        }
 
    }

    public String toString() {
        return "Ingrediente{" + "cafe_po=" + cafe_po + ", sugar=" + sugar + ", agua=" + agua + ", leite=" + leite + ", chocolate_po=" + chocolate_po + ", leite_vap=" + leite_vap + '}';
    } 

    public double getCafe_po() {
        return cafe_po;
    }

    public void useCafe_po(double cafe_po) {
        this.cafe_po -= cafe_po;
    }
    
    public void depositaCafe_po(double cafe_po) {
        this.cafe_po += cafe_po;
    }

    public double getSugar() {
        return sugar;
    }

    public void useSugar(double sugar) {
        this.sugar -= sugar;
    }
    
    public void depositaSugar(double sugar) {
        this.sugar += sugar;
    }

    public double getAgua() {
        return agua;
    }

    public void useAgua(double agua) {
        this.agua -= agua;
    }
    
    public void depositaAgua(double agua) {
        this.agua += agua;
    }

    public double getLeite() {
        return leite;
    }

    public void useLeite(double leite) {
        this.leite -= leite;
    }
    
    public void depositaLeite(double leite) {
        this.leite += leite;
    }

    public double getChocolate_po() {
        return chocolate_po;
    }

    public void useChocolate_po(double chocolate_po) {
        this.chocolate_po -= chocolate_po;
    }
    
    public void depositaChocolate_po(double chocolate_po) {
        this.chocolate_po += chocolate_po;
    }

    public double getLeite_vap() {
        return leite_vap;
    }

    public void useLeite_vap(double leite_vap) {
        this.leite_vap -= leite_vap;
    }
    
    public void depositaLeite_vap(double leite_vap) {
        this.leite_vap += leite_vap;
    }
       
    
    public void ingredienteCheck(){
        String mensagem = "";
        mensagem += "\n------------------------------------------------";
        mensagem += "\n                SMARTPRESSO         ";        
        mensagem += "\n------------------------------------------------";
        mensagem += "\n-- LISTAGEM DOS INGREDIENTES --";
        mensagem += "\n------------------------------------------------";
        mensagem += "\n- Café em Pó: " + getCafe_po();
        mensagem += "\n- Açucar: " + getSugar();
        mensagem += "\n- Água: " + getAgua();
        mensagem += "\n- Leite: " + getLeite();
        mensagem += "\n- Chocolate em Pó: " + getCafe_po();
        mensagem += "\n- Leite Vaporizado: " + getLeite_vap();
        mensagem += "\n------------------------------------------------\n";
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void realizaDeposito(double dCafe, double dAcucar, double dAgua, double dLeite, double dChoc, double dLeiteVap, int escolha){
        double aux = 0;
        switch(escolha){
            case 1:
                aux = dCafe + cafe_po;
                if(aux > 500.00){
                    cafe_po = 500;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 500.00));
                }
                else{
                    cafe_po = dCafe + cafe_po;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
                
            case 2:
                aux = dAcucar + sugar;
                if(aux > 300.00){
                    sugar = 300.00;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 300.00));
                }
                else{
                    sugar = dAcucar + sugar;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
                
                
            case 3:
                aux = dAgua + agua;
                if(aux > 1000.00){
                    agua = 1000;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 1000.00));
                }
                else{
                    agua = dAgua + agua;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
                
                
            case 4:
                aux = dLeite + leite;
                if(aux > 700.00){
                    leite = 700;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 700.00));
                }
                else{
                    leite = dLeite + leite;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
            
            case 5:
                aux = dChoc + chocolate_po;
                if(aux > 200.00){
                    chocolate_po = 200.00;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 200.00));
                }
                else{
                    chocolate_po = dChoc + chocolate_po;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
                
            case 6:
                aux = dLeiteVap + leite_vap;
                if(aux > 300.00){
                    leite_vap = 300.00;
                    JOptionPane.showMessageDialog(null,"Limite do Ingrediente Atingido!!!");
                    JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 300.00));
                }
                else{
                    leite_vap = dLeiteVap + leite_vap;
                    JOptionPane.showMessageDialog(null, "Deposito Realizado com Sucesso!!!");
                }
                break;
      
        }
    }
    
public int verificaCafe(int escolha){
        int x = 0;
        double limCafe;
        double limAgua;
        double limSugar;
        double limLeite;
        double limLeiteVap;
        double limChocolate;
        String mensagem = "";
        switch(escolha){
            case 1:
                    limCafe = cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    if(limCafe < 18.00 || limAgua < 180.00 || limSugar < 15.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Expresso!!!");
                        
                        if(limCafe < 18.00)
                        {
                            mensagem += "\n- Cafe em Pó: " + (18.00 - limCafe) + " g";
                        }
                        if(limAgua < 180.00)
                        {
                            mensagem += "\n- Água: " + (180.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;
                    }
                    JOptionPane.showMessageDialog(null, "Café Expresso Pronto!!!"); 
                    return 1;
                
            case 2:
                    limCafe = cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    limLeite= leite;
                    if(limCafe < 9.00 || limAgua < 90.00 || limSugar < 15.00 || limLeite < 80.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Cappucino!!!");
                        
                        if(limCafe < 9.00)
                        {
                            mensagem += "\n- Cafe em Pó: " + (9.00 - limCafe) + " g";
                        }
                        if(limAgua < 90.00)
                        {
                            mensagem += "\n- Água: " + (90.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        if(limLeite < 80.00)
                        {
                            mensagem += "\n- Leite: " + (80.00 - limLeite) + " ml";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;   
                    }
                    JOptionPane.showMessageDialog(null, "Cappucino Pronto!!!"); 
                    return 1;
                    
            case 3:
                    limCafe = cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    limLeite = leite;
                    if(limCafe < 7.70 || limAgua < 77.00 || limSugar < 15.00 || limLeite < 103.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Latte!!!");
                        
                        if(limCafe < 7.70)
                        {
                            mensagem += "\n- Cafe em Pó: " + (7.70 - limCafe) + " g";
                        }
                        if(limAgua < 77.00)
                        {
                            mensagem += "\n- Água: " + (77.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        if(limLeite < 103.00)
                        {
                            mensagem += "\n- Leite: " + (103.00 - limLeite) + " ml";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;  
                    }
                    JOptionPane.showMessageDialog(null, "Latte Pronto!!!"); 
                    return 1;
                    
            case 4:
                    limCafe = cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    limLeite = leite;
                    if(limCafe < 40.00 || limAgua < 120.00 || limSugar < 15.00 || limLeite < 60.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Macchiato!!!");
                        
                        if(limCafe < 40.00)
                        {
                            mensagem += "\n- Cafe em Pó: " + (40.0 - limCafe) + " g";
                        }
                        if(limAgua < 120.00)
                        {
                            mensagem += "\n- Água: " + (120.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        if(limLeite < 60.00)
                        {
                            mensagem += "\n- Leite: " + (60.00 - limLeite) + " ml";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;
                    }
                    JOptionPane.showMessageDialog(null, "Macchiato Pronto!!!"); 
                    return 1;
                    
            case 5:
                    limCafe= cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    limLeiteVap = leite_vap;
                    if(limCafe < 16.00 || limAgua < 160.00 || limSugar < 15.00 || limLeiteVap < 20.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Pingado!!!");
                        
                        if(limCafe < 16.00)
                        {
                            mensagem += "\n- Cafe em Pó: " + (16.00 - limCafe) + " g";
                        }
                        if(limAgua < 160.00)
                        {
                            mensagem += "\n- Água: " + (160.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        if(limLeiteVap < 20.00)
                        {
                            mensagem += "\n- Leite à Vapor: " + (20.00 - limLeiteVap) + " ml";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;
                    }
                    JOptionPane.showMessageDialog(null, "Pingado Pronto!!!"); 
                    return 1;
                    
            case 6:
                    limCafe = cafe_po;
                    limAgua = agua;
                    limSugar = sugar;
                    limChocolate = chocolate_po;
                    limLeite = leite;
                    limLeiteVap = leite_vap;
                
                    if(limCafe < 6.00 || limAgua < 60.00 || limSugar < 15.00 || limChocolate < 40.00 || limLeite < 60.00 || limLeiteVap < 60.00){
                        JOptionPane.showMessageDialog(null, "Não é possivel fazer o Mocha!!!");
                        
                        if(limCafe < 6.00)
                        {
                            mensagem += "\n- Cafe em Pó: " + (6.00 - limCafe) + " g";
                        }
                        if(limAgua < 60.00)
                        {
                            mensagem += "\n- Água: " + (60.00 - limAgua) + " ml";
                        }
                        if(limSugar < 15.00)
                        {
                            mensagem += "\n- Açucar: " + (15.00 - limSugar) + " g";
                        }
                        if(limLeite < 60.00)
                        {
                            mensagem += "\n- Leite: " + (60.00 - limLeite) + " ml";
                        }
                        if(limChocolate < 40.00)
                        {
                            mensagem += "\n- Chocolate em Pó: " + (40.00 - limChocolate) + " g";
                        }
                        if(limLeiteVap < 60.00)
                        {
                            mensagem += "\n- Leite à Vapor: " + (20.00 - limLeiteVap) + " ml";
                        }
                        JOptionPane.showMessageDialog(null, "Pois Está Faltando: " + mensagem);
                        return 0;
                    }
                    JOptionPane.showMessageDialog(null, "Mocha Pronto!!!"); 
                    return 1;
        }
        return 0;
    }
    
}
