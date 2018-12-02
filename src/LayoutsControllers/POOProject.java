package LayoutsControllers;
import Models.PCPModel; 
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
        
        //função que starta o pcp baseado em um id de pedido e sua quantidade requerida
        //checa se tem projeto daquela quantidade
        model.SetFreeProjects(5, 10);
        model.SetFreeProjects(5, 100);
        model.SetFreeProjects(5, 100);
        model.SetFreeProjects(5, 100);
        model.SetFreeProjects(5, 100);
        model.SetFreeProjects(5, 100);
        model.SetFreeProjects(5, 10);
        model.SetFreeProjects(5, 10);
        model.SetFreeProjects(5, 10);
        model.SetFreeProjects(5, 10);
        model.SetFreeProjects(5, 10);
    }
    
}
