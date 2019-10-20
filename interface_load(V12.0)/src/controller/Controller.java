/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.CafeteiraCS;
import view.Home;
import view.splash;

/**
 *
 * @author Guilherme
 */
public class Controller implements ActionListener{
    private Home home = new Home();
    private CafeteiraCS cafeteira = new CafeteiraCS();
    private int cStatus = 0, cConexao = 0, cIngredientes = 0, cChantily = 0, escolha = 0;

    public Controller(Home home, splash sp) {
        this.home = home;
        SplashScreen(sp);
        InicializaComponentes();
    }
    
    public void SplashScreen(splash sp)
    {
        int i;
        sp.setVisible(true);
        try
        {
            for (i = 0;i <= 100; i++ ){
                Thread.sleep(20);
                if(i==100){
                        sp.dispose();
                        home.setVisible(true);
                }
               }
        }
        catch(Exception e){}
    }
    
    public void InicializaComponentes()
    {
        home.getMenuP().setVisible(true);
        home.getIngredP().setVisible(false);
        home.getConfP().setVisible(false);
        home.getSobreP().setVisible(false);
        
        home.getjSpinner1().setVisible(false);
        home.getjSpinner2().setVisible(false);
        home.getjSpinner3().setVisible(false);
        home.getjSpinner4().setVisible(false);
        home.getjSpinner5().setVisible(false);
        home.getjSpinner6().setVisible(false);
        home.getConfirm().setVisible(false);
        
        home.getTextoExpresso().setVisible(false);
        home.getTextoMocha().setVisible(false);
        home.getTextoMacchiato().setVisible(false);
        home.getTextoCapuccino().setVisible(false);
        home.getTextoPingado().setVisible(false);
        home.getTextoLatte().setVisible(false);
        
        desenhaCopo();
        home.getP1().setMinimum(0); 
        home.getP1().setMaximum(500);   
        home.getP2().setMinimum(0); 
        home.getP2().setMaximum(300);  
        home.getP3().setMinimum(0); 
        home.getP3().setMaximum(1000);  
        home.getP4().setMinimum(0); 
        home.getP4().setMaximum(700);   
        home.getP5().setMinimum(0); 
        home.getP5().setMaximum(200);   
        home.getP6().setMinimum(0); 
        home.getP6().setMaximum(300);
    }
    
    public void desenhaCopo()
    {
        if(cConexao == 1 || cStatus == 1)
        {
            home.getQtdCopo().setText("...");
        }
        else home.getQtdCopo().setText("" + cafeteira.getCopoQt());
    }
    
    public void barraProgresso()
    {
        if(cStatus == 1 || cConexao == 1)
        {
            JOptionPane.showMessageDialog(null, "Não é Possível Pegar os Dados da Cafeteira, Pois Não Existe Conexão!!!");
            home.getP1().setValue(0);  
            home.getP2().setValue(0);  
            home.getP3().setValue(0);  
            home.getP4().setValue(0);  
            home.getP5().setValue(0);  
            home.getP6().setValue(0);
        }
        else
        {
            int progresso1 = (int) cafeteira.IC.cafe_po;
            int progresso2 = (int) cafeteira.IC.sugar;
            int progresso3 = (int) cafeteira.IC.agua;
            int progresso4 = (int) cafeteira.IC.leite;
            int progresso5 = (int) cafeteira.IC.chocolate_po;
            int progresso6 = (int) cafeteira.IC.leite_vap;   

            home.getP1().setValue(progresso1);  
            home.getP2().setValue(progresso2);  
            home.getP3().setValue(progresso3);  
            home.getP4().setValue(progresso4);  
            home.getP5().setValue(progresso5);  
            home.getP6().setValue(progresso6);
        }
    }
 
    public void zeraProgresso()
    {
        home.getP1().setValue(0);  
        home.getP2().setValue(0);  
        home.getP3().setValue(0);  
        home.getP4().setValue(0);  
        home.getP5().setValue(0);  
        home.getP6().setValue(0);    
    }
    
    public void fazerCafezinho(int num)
    {
        
        if(cStatus == 1)
        {
            JOptionPane.showMessageDialog(null,"A Cafeteira Está Desligada, Favor Liga-la!!!");
        }
        else if(cConexao == 1)
        {
            JOptionPane.showMessageDialog(null,"Não Existe Conexão Com a Cafeteira, Favor Estabelecer Conexão!!!");
        }
        else if(cafeteira.getCopoQt() == 0)
        {
            JOptionPane.showMessageDialog(null,"Não Tem Copo para Fazer o Café, Favor Reabastecer!!!");
        }
        if(cafeteira.getCopoQt() != 0 && cStatus == 0 && cConexao == 0)
        {
            if(cafeteira.getIC().verificaCafe(num) == 1)
            {
                cafeteira.fazerCafe(num);   
            }     
        }
        else{}

        cafeteira.getIC().salvarIngredientes();        
        cafeteira.salvarCopos();
        desenhaCopo();
    }
    
    public void statusBotao()
    {
        if(cConexao == 1 || cStatus == 1)
        {
            home.getDepositaCopo().setEnabled(false);
            home.getConfirm().setEnabled(false);
            home.getChecarIngredientes().setEnabled(false);
        }
        else
        {
            home.getDepositaCopo().setEnabled(true);
            home.getConfirm().setEnabled(true);
            home.getChecarIngredientes().setEnabled(true);
        }
    }

    public void control()
    {
        home.getCafe().addActionListener(this);
        home.getIngred().addActionListener(this);
        home.getConfig().addActionListener(this);
        home.getSobre().addActionListener(this);
        home.getEsp_().addActionListener(this);
        home.getCap().addActionListener(this);
        home.getMoch().addActionListener(this);
        home.getPing().addActionListener(this);
        home.getMach().addActionListener(this);
        home.getLat().addActionListener(this);
        home.getDepositaCopo().addActionListener(this);
        home.getCafeRep().addActionListener(this);
        home.getAcucarRep().addActionListener(this);
        home.getAguaRep().addActionListener(this);
        home.getLeiteRep().addActionListener(this);
        home.getChocoRep().addActionListener(this);
        home.getVapRep().addActionListener(this);
        home.getConfirm().addActionListener(this);
        home.getStatusOnOff().addActionListener(this);
        home.getConexaoOnOff().addActionListener(this);
        home.getChecarIngredientes().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home.getCafe())
        {
            home.getMenuP().setVisible(true);
            home.getIngredP().setVisible(false);
            home.getConfP().setVisible(false);
            home.getSobreP().setVisible(false);
            statusBotao();
            desenhaCopo();
        }
        else if(e.getSource() == home.getIngred())
        {
            home.getMenuP().setVisible(false);
            home.getIngredP().setVisible(true);
            home.getConfP().setVisible(false);
            home.getSobreP().setVisible(false);
            statusBotao();
            barraProgresso();
        }
        else if(e.getSource() == home.getConfig())
        {
            home.getMenuP().setVisible(false);
            home.getIngredP().setVisible(false);
            home.getConfP().setVisible(true);
            home.getSobreP().setVisible(false);
        }
        else if(e.getSource() == home.getSobre())
        {
            home.getMenuP().setVisible(false);
            home.getIngredP().setVisible(false);
            home.getConfP().setVisible(false);
            home.getSobreP().setVisible(true);
        }
        else if(e.getSource() == home.getEsp_())
        {
            fazerCafezinho(1);
        }
        else if(e.getSource() == home.getCap())
        {
            fazerCafezinho(2);
        }
        else if(e.getSource() == home.getLat())
        {
            fazerCafezinho(3);
        }
        else if(e.getSource() == home.getMach())
        {
            fazerCafezinho(4);
        }
        else if(e.getSource() == home.getPing())
        {
            fazerCafezinho(5);
        }
        else if(e.getSource() == home.getMoch())
        {
            fazerCafezinho(6);
        }
        else if(e.getSource() == home.getDepositaCopo())
        {
            int copo = (int) home.getQtCopo().getValue();
            cafeteira.depositaCopoQt(copo);
            cafeteira.salvarCopos();
            desenhaCopo();
        }
        else if(e.getSource() == home.getCafeRep())
        {
            home.getjSpinner1().setVisible(true);
            home.getjSpinner2().setVisible(false);
            home.getjSpinner3().setVisible(false);
            home.getjSpinner4().setVisible(false);
            home.getjSpinner5().setVisible(false);
            home.getjSpinner6().setVisible(false);
            home.getConfirm().setVisible(true);
            escolha = 1;
        }
        else if(e.getSource() == home.getAcucarRep())
        {
            home.getjSpinner1().setVisible(false);
            home.getjSpinner2().setVisible(true);
            home.getjSpinner3().setVisible(false);
            home.getjSpinner4().setVisible(false);
            home.getjSpinner5().setVisible(false);
            home.getjSpinner6().setVisible(false);
            home.getConfirm().setVisible(true);
            escolha = 2;
        }
        else if(e.getSource() == home.getAguaRep())
        {
            home.getjSpinner1().setVisible(false);
            home.getjSpinner2().setVisible(false);
            home.getjSpinner3().setVisible(true);
            home.getjSpinner4().setVisible(false);
            home.getjSpinner5().setVisible(false);
            home.getjSpinner6().setVisible(false);
            home.getConfirm().setVisible(true);
            escolha = 3;
        }
        else if(e.getSource() == home.getLeiteRep())
        {
            home.getjSpinner1().setVisible(false);
            home.getjSpinner2().setVisible(false);
            home.getjSpinner3().setVisible(false);
            home.getjSpinner4().setVisible(true);
            home.getjSpinner5().setVisible(false);
            home.getjSpinner6().setVisible(false);
            home.getConfirm().setVisible(true);
            escolha = 4;
        }
        else if(e.getSource() == home.getChocoRep())
        {
            home.getjSpinner1().setVisible(false);
            home.getjSpinner2().setVisible(false);
            home.getjSpinner3().setVisible(false);
            home.getjSpinner4().setVisible(false);
            home.getjSpinner5().setVisible(true);
            home.getjSpinner6().setVisible(false);
            home.getConfirm().setVisible(true);
            escolha = 5;
        }
        else if(e.getSource() == home.getVapRep())
        {
            home.getjSpinner1().setVisible(false);
            home.getjSpinner2().setVisible(false);
            home.getjSpinner3().setVisible(false);
            home.getjSpinner4().setVisible(false);
            home.getjSpinner5().setVisible(false);
            home.getjSpinner6().setVisible(true);
            home.getConfirm().setVisible(true);
            escolha = 6;
        }
        else if(e.getSource() == home.getConfirm())
        {
            double a = (double) home.getjSpinner1().getValue();
            double b = (double) home.getjSpinner2().getValue();
            double c = (double) home.getjSpinner3().getValue();
            double d = (double) home.getjSpinner4().getValue();
            double ee = (double) home.getjSpinner5().getValue();
            double f = (double) home.getjSpinner6().getValue();
            
            cafeteira.getIC().realizaDeposito(a, b, c, d, ee, f, escolha);
            cafeteira.getIC().salvarIngredientes();
            barraProgresso();
        }
        else if(e.getSource() == home.getChecarIngredientes())
        {
            cafeteira.getIC().ingredienteCheck();
        }
        else if(e.getSource() == home.getStatusOnOff())
        {
            if(cStatus == 0)
            {
                home.getStatusOnOff().setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_load/coffex-23.png")));
                home.getConexaoOnOff().setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_load/coffex-23.png")));
                cStatus++;
                cConexao++;
                zeraProgresso();
            }
            else
            {
                home.getStatusOnOff().setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_load/coffex-22.png")));
                cStatus = 0;
                cConexao = 1;
            }
        }
        else if(e.getSource() == home.getConexaoOnOff())
        {
            if(cConexao == 0)
            {
                home.getConexaoOnOff().setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_load/coffex-23.png")));
                cConexao++;
                zeraProgresso();
            }
            else
            {
                home.getConexaoOnOff().setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_load/coffex-22.png")));
                cConexao = 0;
            }
        }
        
        
        
    }
    
}
