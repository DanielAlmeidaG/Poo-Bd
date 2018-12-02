package Data.Controllers;

import Data.db_connection.db_controller;
import Package.Helper;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ProjectController extends Controller {    
    public ProjectController(){
        this.columns = new ArrayList<>();
        this.columns.add("id_project");
        this.columns.add("key_designation");
        this.columns.add("quantity_chairs"); 
        this.ret = null;
        this.controller = new db_controller();
        this.hlp = new Helper();
        this.table = "Projects";
        this.idKey = "id_project";
        this.columnsInsert = new ArrayList<>();
        this.columnsInsert.add("key_designation");
        this.columnsInsert.add("quantity_chairs");
    }
}
