/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Data.Controllers.ProjectController;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PCPModel {
    ProjectController PC;
    
    public PCPModel(){
        PC = new ProjectController();
    }
    public void GetFreeProjects(){
        PC.GetData(PC.GetTable(), "key_designation", 0, PC.GetColumns());
        
        ArrayList<ArrayList<String>> result = PC.GetReturn();
        if(!result.isEmpty()){
            for(ArrayList<String> col : PC.GetReturn()){
                
            }
        }
        
    }
}
