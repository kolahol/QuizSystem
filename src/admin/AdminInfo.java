package admin;

public class AdminInfo {
    private String username;
    private String password;
    
    public AdminInfo(){
        this.username = "Qsetter";
        this.password = "123";
    }
    
    public String getAdminUsername(){
        return username;
    }
    
    public String getAdminPassword(){
        return password;
    }
}
