package Vanilla.claude;

import java.util.ArrayList;

class User1 {
    private String name;
    private String email;
    private String password;
    
    public User1(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }
}

class Task46 {
    private static ArrayList<User1> database = new ArrayList<>();
    
    public static boolean registerUser1(String name, String email, String password) {
        if(name == null || email == null || password == null) {
            return false;
        }
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        if(!email.contains("@")) {
            return false;
        }
        if(password.length() < 6) {
            return false;
        }
        
        User1 newUser1 = new User1(name, email, password);
        database.add(newUser1);
        return true;
    }
    
    public static void main(String[] args) {
        // Test case 1: Valid registration
        System.out.println("Test 1: " + registerUser1("John Doe", "john@email.com", "password123"));
        
        // Test case 2: Invalid email
        System.out.println("Test 2: " + registerUser1("Jane Doe", "invalid-email", "password123"));
        
        // Test case 3: Short password
        System.out.println("Test 3: " + registerUser1("Bob Smith", "bob@email.com", "pass"));
        
        // Test case 4: Empty fields
        System.out.println("Test 4: " + registerUser1("", "", ""));
        
        // Test case 5: Null values
        System.out.println("Test 5: " + registerUser1(null, null, null));
        
        System.out.println("\\nRegistered User1s:");
        for(User1 user : database) {
            System.out.println(user);
        }
    }
}
