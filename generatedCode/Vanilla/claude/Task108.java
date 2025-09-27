package Vanilla.claude;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface RemoteInterface extends Remote {
    String getMessage() throws RemoteException;
    void setMessage(String message) throws RemoteException;
}

class RemoteObject extends UnicastRemoteObject implements RemoteInterface {
    private String message;
    
    public RemoteObject() throws RemoteException {
        message = "Default Message";
    }
    
    public String getMessage() throws RemoteException {
        return message;
    }
    
    public void setMessage(String message) throws RemoteException {
        this.message = message;
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            RemoteObject obj = new RemoteObject();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteObject", obj);
            System.out.println("Server ready");
            
            // Test cases
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteObject");
            
            // Test 1: Get default message
            System.out.println("Test 1: " + stub.getMessage());
            
            // Test 2: Set new message
            stub.setMessage("Hello World");
            System.out.println("Test 2: " + stub.getMessage());
            
            // Test 3: Set empty message
            stub.setMessage("");
            System.out.println("Test 3: " + stub.getMessage());
            
            // Test 4: Set special characters
            stub.setMessage("!@#$%^&*()");
            System.out.println("Test 4: " + stub.getMessage());
            
            // Test 5: Set long message
            stub.setMessage("This is a very long message to test the remote object functionality");
            System.out.println("Test 5: " + stub.getMessage());
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
