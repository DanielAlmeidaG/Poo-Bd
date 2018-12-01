/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Controllers;

import Data.IControllers.IController;
import Data.db_connection.db_controller;
import Package.Helper;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Controller implements IController{
    protected db_controller controller;    
    protected ArrayList<String> columns;
    protected String table;
    protected Helper hlp;
    protected ArrayList<ArrayList<String>> ret;

    @Override
    public void InsertData(String table, String columns, String values) {
        controller.InsertData(table, columns, values);
    }

    @Override
    public void GetData(String table, ArrayList<String> columns) {
        this.ret = controller.GetData(table, columns);
    }

    @Override
    public void GetData(String table, String key, String pass, ArrayList<String> columns) {
        this.ret = controller.GetData(table, key, pass, columns);
    }

    @Override
    public void GetData(String table, String key, int pass, ArrayList<String> columns) {
        this.ret = controller.GetData(table, key, pass, columns);
    }

    @Override
    public String GetTable() {
        return this.table;
    }

    @Override
    public ArrayList<String> GetColumns() {
        return this.columns;
    }

    @Override
    public ArrayList<ArrayList<String>> GetReturn() {
        return this.ret;
    }
    
    
}
