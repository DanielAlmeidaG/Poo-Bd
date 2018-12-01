package Data.db_connection;
 
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class db_controller {
    final String _pathBD;

    public db_controller() {
        //this._pathBD = "jdbc:sqlite:C:\\Users\\Daniel.LAPTOP-0APVLH0B\\Documents\\NetBeansProjects\\POOProject\\src\\Data";
        File f = new File(".");
        this._pathBD = "jdbc:sqlite:" + f.getAbsolutePath() + "\\src\\Data";
    }
    
    public Connection Connect(){
        Connection conn = null;
        try {
            //Cria conexão com o banco de dados no caminho passado por parametro
            conn = DriverManager.getConnection(this._pathBD + "\\poo_db.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }    
    
    public void InsertData(String table, String columns, String values){
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql = sql.append(table);
        sql = sql.append("(");
        sql = sql.append(columns);
        sql = sql.append(") VALUES(");
        sql = sql.append(values);
        sql = sql.append(")");
        
        try(Connection conn = Connect();
        PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.executeUpdate();   
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<ArrayList<String>> GetData(String table, ArrayList<String> columns){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(table);
        
        ArrayList<String> cliente = new ArrayList<>();
        ArrayList<ArrayList<String>> total = new ArrayList<>();
        
        try(Connection conn = Connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql.toString())){
            
            while (rs.next()) {
                for(String col : columns){
                    cliente.add(rs.getString(col));
                }
                total.add((ArrayList<String>) cliente.clone());
                cliente.clear();
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public ArrayList<ArrayList<String>> GetData(String table, String key, String pass, ArrayList<String> columns){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(table);
        sql.append(" WHERE ");
        sql.append(key);
        sql.append(" = ");
        sql.append(pass);
        
        
        ArrayList<String> cliente = new ArrayList<>();
        ArrayList<ArrayList<String>> total = new ArrayList<>();
        
        try(Connection conn = Connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql.toString())){
            
            while (rs.next()) {
                for(String col : columns){
                    cliente.add(rs.getString(col));
                }
                total.add((ArrayList<String>) cliente.clone());
                cliente.clear();
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public ArrayList<ArrayList<String>> GetData(String table, String key, int pass, ArrayList<String> columns){
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(table);
        sql.append(" WHERE ");
        sql.append(key);
        sql.append(" = ");
        sql.append(pass);
        
        
        ArrayList<String> cliente = new ArrayList<>();
        ArrayList<ArrayList<String>> total = new ArrayList<>();
        
        try(Connection conn = Connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql.toString())){
            
            while (rs.next()) {
                for(String col : columns){
                    cliente.add(rs.getString(col));
                }
                total.add((ArrayList<String>) cliente.clone());
                cliente.clear();
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public void UpdateData(String table, String sets, int id){
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(table);
        sql.append(" SET ");
        sql.append(sets);
        sql.append(" WHERE id = ");
        sql.append(id);
 
        try (Connection conn = Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
