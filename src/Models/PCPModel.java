package Models;
import Data.Controllers.ProjectController;
import Data.IControllers.IController;
import Package.Helper;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PCPModel {
    IController PC;
    
    public PCPModel(){
        PC = new ProjectController();
    }
    public void SetFreeProjects(int idOrder, int qntOrder){
        Helper hlp = new Helper();
        ArrayList<Object> values = new ArrayList<>();
        String order;
        ArrayList<String> insertsArr = PC.GetInsertColumns();
        String insertsStr = insertsArr.toString().replace("[", "").replace("]", "");
;
        int tempIntOrder = qntOrder;
        if(qntOrder == 0){
            return;
        } 
        
        PC.GetData(PC.GetTable(), PC.GetColumns());
        
        if(PC.GetReturn().isEmpty()){
            values.clear();
            values.add(qntOrder);
            values.add(qntOrder);
            String valuesStr = values.toString().replace("[", "").replace("]", "");
            PC.InsertData(PC.GetTable(), insertsStr, valuesStr);
            SetFreeProjects(idOrder, qntOrder);
            return;
        }
        
        order = PC.GetReturn().get(0).get(0);
        
        for(ArrayList<String> col : PC.GetReturn()){
            values.clear();
            if(Integer.parseInt(col.get(2)) - Integer.parseInt(col.get(1)) > qntOrder){
                //pega as unidades e altera no bd
                values.add(String.valueOf(qntOrder + Integer.parseInt(col.get(1))));
                values.add(col.get(2));
                
                PC.UpdateData(PC.GetTable(), hlp.SerializeSetsToString(true, insertsArr, values), PC.GetIdKey(), col.get(0));
                return;
            }
            else if(Integer.parseInt(col.get(2)) - Integer.parseInt(col.get(1)) == qntOrder){
                values.add(String.valueOf(qntOrder + Integer.parseInt(col.get(1))));
                values.add(col.get(2));
                
                PC.DeleteData(PC.GetTable(), PC.GetIdKey(), order);//ADICIONAR GET E SET DE ID
                return;
            }
            else{                
                tempIntOrder = qntOrder - Integer.parseInt(col.get(1));
                
                values.add(String.valueOf(qntOrder + Integer.parseInt(col.get(1))));
                values.add(col.get(2));
                
                PC.DeleteData(PC.GetTable(), PC.GetIdKey(), order);//ADICIONAR GET E SET DE ID
            }
        }   
        SetFreeProjects(idOrder, tempIntOrder);
    }
}
