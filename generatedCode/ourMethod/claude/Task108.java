package ourMethod.claude;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Remote interface
interface RemoteService extends Remote {
    String accessObject(String id, String operation) throws RemoteException;
}

// Server implementation
class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
    private static final long serialVersionUID = 1L;
    
    protected RemoteServiceImpl() throws RemoteException {
        super();
    }

    public String accessObject(String id, String operation) throws RemoteException {
        // Validate input parameters
        if (id == null || operation == null) {
            throw new RemoteException("Invalid parameters");
        }
        
        // Add authentication and authorization checks here
        
        // Validate operation type
        if (!operation.matches("^[a-zA-Z0-9]+$")) {
            throw new RemoteException("Invalid operation");
        }
        
        // Process request with proper error handling
        try {
            return "Processed: " + id + " with " + operation;
        } catch (Exception e) {
            throw new RemoteException("Error processing request");
        }
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            // Create and export remote service on default port
            RemoteService service = new RemoteServiceImpl();
            
            // Create registry on default port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind remote object to registry
            registry.rebind("RemoteService", service);
            
            System.out.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
        }
        
        // Test cases
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            RemoteService service = (RemoteService) registry.lookup("RemoteService");
            
            // Test 1: Valid request
            System.out.println(service.accessObject("obj1", "read")); 
            
            // Test 2: Null id
            try {
                service.accessObject(null, "read");
            } catch(Exception e) {
                System.out.println("Test 2 passed: " + e.getMessage());
            }
            
            // Test 3: Invalid operation
            try {
                service.accessObject("obj1", "read;drop table"); 
            } catch(Exception e) {
                System.out.println("Test 3 passed: " + e.getMessage());
            }
            
            // Test 4: Valid complex request
            System.out.println(service.accessObject("obj123", "readwrite"));
            
            // Test 5: Empty strings
            try {
                service.accessObject("", "");
            } catch(Exception e) {
                System.out.println("Test 5 passed: " + e.getMessage());
            }
            
        } catch(Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
}
