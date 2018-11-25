package Controllers.db_connection.ClientController;

import Controllers.db_connection.db_controller;
import Package.Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientController {
    db_controller controller;
    ArrayList<String> columns;
    String tabela;
    Helper hlp;

    public ClientController() {
        columns.add("nome");
        columns.add("telefone");
        columns.add("email");
        columns.add("endereco");
        columns.add("total_compras"); 
        
        tabela = "Clientes";
        
        controller = new db_controller();
        columns = new ArrayList<>();
        hlp = new Helper();
    }    
    
    public void InsereNovo(String nome, String tel, String email, String end){
        ArrayList<String> values = new ArrayList<>();
        values.add(nome);
        values.add(tel);
        values.add(email);
        values.add(end);
        values.add("0");
        controller.InsertData(tabela, hlp.SerializeColToString(columns), hlp.SerializeValToString(values));
    }
    
    public void GetAllCliente(){
        String sqlCommand = "SELECT "
                          + "pk_id, nome, telefone, email, endereco, total_compras "
                          + "FROM "
                          + "Clientes";
        
        
         
        try(Connection conn = controller.Connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sqlCommand)){
            
            while (rs.next()) {
                System.out.println(rs.getInt("pk_id") +  "/" + 
                                   rs.getString("nome") + "/" +
                                   rs.getString("telefone"));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void GetCliente(String buscaDesejada){
        String sqlCommand = "SELECT "
                          + "pk_id, nome, telefone, email, endereco, total_compras "
                          + "FROM "
                          + "Clientes "
                          + "WHERE "
                          + "nome = ?";
        try(Connection conn = controller.Connect();
            PreparedStatement pstmt  = conn.prepareStatement(sqlCommand)){

            pstmt.setString(1, buscaDesejada);
            
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("pk_id") +  "/" + 
                                   rs.getString("nome") + "/" +
                                   rs.getString("telefone"));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String GetCliente(int IdDesejado){
        String sqlCommand = "SELECT "
                          + "pk_id, nome, telefone, email, endereco, total_compras "
                          + "FROM "
                          + "Clientes "
                          + "WHERE "
                          + "pk_id = ?";
        String ret = "---";
        try(Connection conn = controller.Connect();
            PreparedStatement pstmt  = conn.prepareStatement(sqlCommand)){

            pstmt.setInt(1, IdDesejado);
            
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                ret = "Clientes: " + rs.getInt("pk_id") +  "\n" + rs.getString("nome") + "\n" + rs.getString("telefone") 
                      + rs.getString("email") + "\n" + rs.getString("endereco") + "\n" +Integer.toString(rs.getInt("total_compras"));
            }
        
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public void UpdateClienteCompras(int totalCompras, int idCliente){
        String sqlCommand = "UPDATE Clientes SET total_compras = ? "
                + "WHERE pk_id = ?";
 
        try (Connection conn = controller.Connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
 
            // set the corresponding param
            //pstmt.setString(1, "Clientes");
            pstmt.setInt(1, totalCompras);
            pstmt.setInt(2, idCliente);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
