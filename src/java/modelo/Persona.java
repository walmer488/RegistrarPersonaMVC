package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Persona {
  
    Connection cnn;
    Statement state;
    ResultSet result;
    
    String dui;
    String apellidos;
    String nombres;
    
    public Persona()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recurso_humano?zeroDateTimeBehavior=convertToNull", "root", "");               
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
                
    }
    
  public Persona(String dui, String apellidos, String nombres){
        this.dui = dui;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }
  
    public boolean insertarDatos(){
        try{
            String miQuery = "insert into tb_persona values('" + dui + "','" + apellidos + "','" + nombres + "');";
            int estado = 0;
            state = cnn.createStatement();
            estado = state.executeUpdate(miQuery);
            if(estado == 1){
                return true;
            }        
        }catch (SQLException ex){
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
            
    public ArrayList<Persona> ConsultarRegistro(){
        ArrayList<Persona> person = new ArrayList();
        try {
            String miQuery = "select * from tb_persona;";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombre_persona")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
    
     public boolean BuscarId(String dui)
    {
       
       try {
            String miQuery = "select * from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            state.executeQuery(miQuery);
            
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }
    
    public Persona list(String dui)
    {
        Persona p = new Persona();
       try {
            String miQuery = "select * from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                p.setDui(result.getString("dui_persona"));
                p.setApellidos(result.getString("apellidos_persona"));
                p.setNombres(result.getString("nombre_persona"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }
    
    public boolean Editar(Persona per)
    {
       try {
            String miQuery = "update tb_persona set apellidos_persona='" + per.getApellidos() + "',nombre_persona='" + per.getNombres() + "' where dui_persona='"+per.getDui()+"'";
            state = cnn.createStatement();
            state.executeUpdate(miQuery);
           
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
     public boolean Eliminar(String dui)
    {
       try {
            String miQuery = "delete from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            state.executeUpdate(miQuery);
           
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
      
    public String getDui() {
        return dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    /*
Pool metodospool = new Pool();    

public void Actualizar(String nombres, String apellidos, String email, String celular, 
                      String direccion, String ciudad, String idcontacto){

int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");

if(confirmar == JOptionPane.YES_OPTION){

    Connection conexion = null;
    
    try {
    
        conexion = metodospool.dataSource.getConnection();
        
        String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
                    + "WHERE id_contacto=?";
        
        PreparedStatement prest = conexion.prepareStatement(Ssql);
        
        prest.setString(1, nombres);
        prest.setString(2, apellidos);
        prest.setString(3, email);
        prest.setString(4, celular);
        prest.setString(5, direccion);
        prest.setString(6, ciudad);
        prest.setString(7, idcontacto);
        
        if(prest.executeUpdate() > 0){
        
            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                          JOptionPane.INFORMATION_MESSAGE);
            
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.", "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
        
        }
        
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.\n"
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
    
    }finally{
    
        if(conexion!=null){
        
            try {
                
                conexion.close();
            
            } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión."
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
           
    }
    

}

}*/

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
