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
    public void UpdateData(String table, String sets, String idKey, String id);
    public void DeleteData(String table, String idKey, String id);
    public void UpdateData(String table, String sets, String idKey, int id);
    public void DeleteData(String table, String idKey, int id);
    public String GetTable();
    public ArrayList<String> GetColumns();
    public ArrayList<ArrayList<String>> GetReturn();
    public String GetIdKey();
    public ArrayList<String> GetInsertColumns();
    //INSERIR UPDATE DATA E DELETE DATA
}
