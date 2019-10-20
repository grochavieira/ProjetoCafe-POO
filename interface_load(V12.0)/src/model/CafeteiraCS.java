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
public class CafeteiraCS extends Cafe{
    private int copoQt;

    public CafeteiraCS() {
        super();
        Copos();
    }
    
    public void Copos(){
        String pegaCopoArquivo="";
        try{
                FileReader copoArquivo = new FileReader("Copos.txt");
                BufferedReader br = new BufferedReader(copoArquivo);
                String str; 
                while((str = br.readLine()) != null)
                {
                    pegaCopoArquivo = str;
                }
                this.copoQt = Integer.parseInt(pegaCopoArquivo);
        }
        catch(IOException e)
        {
            System.out.println("- Arquivo não encontrado!");
        }
 
    }

    public int getCopoQt() {
        return copoQt;   
    }
    
    public void depositaCopoQt(int copoQt){
        int aux = this.copoQt;
        aux += copoQt;
        if(aux > 30)
        {
            this.copoQt = 30;
            JOptionPane.showMessageDialog(null,"Limite de Copos Atingido!!!");
            JOptionPane.showMessageDialog(null, "Sobrou: " + (aux - 30));
        }
        else
        {
            this.copoQt += copoQt;
            JOptionPane.showMessageDialog(null,"Depósito Realizado Com Sucesso!!!");
        }
        
    }
    public void useCopoQt(){
        this.copoQt -= 1;
    }
    public void salvarCopos() {
        try{
            FileWriter copoArquivo = new FileWriter("Copos.txt");
            PrintWriter escritaArquivo = new PrintWriter(copoArquivo);

            escritaArquivo.printf("%d\n", getCopoQt());

            copoArquivo.close();
        }
        catch(IOException e)
        {
            System.out.println("- Arquivo não encontrado!");
        }
 
    }
    
    public void fazerCafe(int x){
        switch(x){
            case 1:
                cafeExpresso();
                useCopoQt();
                break;
            case 2:
                capuccino();
                useCopoQt();
                break;
            case 3:
                cafeLatte();
                useCopoQt();
                break;
            case 4:
                macchiato();
                useCopoQt();
                break;
            case 5:
                cafePingado();
                useCopoQt();
                break;
            case 6:
                cafeMocha();
                useCopoQt();
                break;
        }
    }
}
