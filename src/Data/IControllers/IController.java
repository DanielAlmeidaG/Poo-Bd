/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.IControllers;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public interface IController {
    public void InsertData(String table, String columns, String values);
    public void GetData(String table, ArrayList<String> columns);
    public void GetData(String table, String key, String pass, ArrayList<String> columns);
    public void GetData(String table, String key, int pass, ArrayList<String> columns);
    public String GetTable();
    public ArrayList<String> GetColumns();
    public ArrayList<ArrayList<String>> GetReturn();
    //INSERIR UPDATE DATA E DELETE DATA
}
