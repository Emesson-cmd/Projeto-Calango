/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calango.controllers;



import com.mycompany.calango.entidade.Veiculo;
import com.mycompany.calango.models.VeiculoModel;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author DELL
 */
public class ControllerVeiculo {
   
    public void addVeiculo(Veiculo v){
        try {
            new VeiculoModel().salvar(v);
            JOptionPane.showMessageDialog(null, "Veículo Gravado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar: "+e.getMessage());
        }
    }
    
    public List<Veiculo> getVeiculos(){
        return new VeiculoModel().listaVeiculos();
    }
}
