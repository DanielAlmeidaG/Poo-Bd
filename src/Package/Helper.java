package Package;

import java.util.ArrayList;

public class Helper {
    
    ///
    ///Recebe um array de strings e insere viruglas entre as ocorrencias
    ///
    public String SerializeColToString(ArrayList<String> list){        
        if(!list.isEmpty()){
            return String.join(", ", list); 
        }
        return null;    
    }
    
    public String SerializeValToString(ArrayList<String> list){
        StringBuilder values = new StringBuilder();
        if(!list.isEmpty()){
            values = values.append("'");
            values = values.append(String.join("', '", list));
            values = values.append("'");
            
            return values.toString();
        }
        return null;        
    }
    
    public String SerializeSetsToString(ArrayList<String> columns, ArrayList<String> values){
        ArrayList<String> temp = new ArrayList<>();
        if(!columns.isEmpty() && !columns.isEmpty()){            
            for(int x=0; x<columns.size(); x++){
                temp.add(columns.get(x).concat(" = ").concat("'").concat(values.get(x).concat("'")));
                
            }            
            return SerializeColToString(temp);
        }
        return null;
    }
}
