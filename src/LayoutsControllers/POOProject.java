/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsControllers;
import Controllers.db_connection.ClientController.ClientController;
import Controllers.db_connection.db_controller;
import Layouts.ComprarProduto;
import Layouts.MenuUI;
import Package.Helper;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class POOProject {
    
    
    public static void main(String[] args) {
        //ComprarProduto PageMenu = new ComprarProduto();
        //PageMenu.setVisible(true);
        //ClientController client = new ClientController();
        
        db_controller controller = new db_controller();
        
        
        ArrayList<String> list = new ArrayList<>();
        list.add("nome");
        list.add("telefone");
        list.add("endereco");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("asdfghjk");
        list2.add("zxcvbnm,");
        list2.add("qwertyui");
        Helper helper = new Helper();
        
        String x;
        x = helper.SerializeSetsToString(list, list2);
        
        controller.UpdateData("Clientes", x, 21);
        
    }
    
}
