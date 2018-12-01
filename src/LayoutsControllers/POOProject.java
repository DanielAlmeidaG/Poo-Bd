/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsControllers;
import Data.Controllers.ClientController;
import Data.Controllers.ProjectController;
import Data.db_connection.db_controller;
import Layouts.ComprarProduto;
import Layouts.MenuUI;
import Models.PCPModel;
import Package.Helper;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class POOProject {
    
    
    public static void main(String[] args) {
        //primeiro fazer checagem se tem projeto de x cadeiras
        //se não tiver tem que implementar criação
        //se tiver me printa um okay e diz que aquela porra ta ocupada
        PCPModel model = new PCPModel();
        
        model.GetFreeProjects();
    }
    
}
