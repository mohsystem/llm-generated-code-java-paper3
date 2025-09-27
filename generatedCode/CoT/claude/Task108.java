package CoT.claude;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Remote interface
interface RemoteOperations extends Remote {
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException; 
    String getServerMessage() throws RemoteException;
}

// Implementation class
class RemoteOperationsImpl extends UnicastRemoteObject implements RemoteOperations {
    protected RemoteOperationsImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
    
    public String getServerMessage() throws RemoteException {
        return "Hello from server!";
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            RemoteOperations obj = new RemoteOperationsImpl();
            
            // Create the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind the remote object
            registry.rebind("RemoteOperations", obj);
            
            System.out.println("Server ready");
            
            // Test cases
            RemoteOperations stub = (RemoteOperations) registry.lookup("RemoteOperations");
            
            // Test case 1: Add
            System.out.println("Test 1: 5 + 3 = " + stub.add(5, 3));
            
            // Test case 2: Subtract  
            System.out.println("Test 2: 10 - 4 = " + stub.subtract(10, 4));
            
            // Test case 3: Add negative numbers
            System.out.println("Test 3: -5 + (-3) = " + stub.add(-5, -3));
            
            // Test case 4: Subtract with negative result
            System.out.println("Test 4: 5 - 10 = " + stub.subtract(5, 10));
            
            // Test case 5: Get server message
            System.out.println("Test 5: " + stub.getServerMessage());
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
