package database;

public class DatabaseInfo {
    String connection;
    String username;
    String password;
    
    public DatabaseInfo(){
        connection = "jdbc:derby://localhost:1527/C:/Users/Mashuk/.netbeans-derby/QUIZ";
        username = "quiz";
        password = "123";
    }
    
    public String getConnection(){
        return connection;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
