
package Modelo;

public class Usuario {
    private int Id;
    private String Nombre;
    private String Email;
    private String Clave;
    private String Rol; 

    public Usuario() {
    }
    
    public Usuario(int Id, String Nombre, String Email, String Clave, String Rol) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Email = Email;
        this.Clave = Clave;
        this.Rol = Rol;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    
    
    
}
