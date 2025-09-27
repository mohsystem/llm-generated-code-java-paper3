package ZeroShot.claude;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

interface RemoteObjectInterface extends Remote {
    String performOperation(String sessionToken, String operation, String data) throws RemoteException;
}

class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObjectInterface {
    private Map<String, String> sessions = new HashMap<>();
    private Map<String, String> objects = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    
    protected RemoteObjectImpl() throws RemoteException {
        super();
    }
    
    private boolean validateSession(String token) {
        return sessions.containsKey(token);
    }
    
    private String hashPassword(String password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String performOperation(String sessionToken, String operation, String data) throws RemoteException {
        if (!validateSession(sessionToken)) {
            return "Invalid session";
        }
        
        switch(operation.toLowerCase()) {
            case "create":
                String objectId = Base64.getEncoder().encodeToString(secureRandom.generateSeed(16));
                objects.put(objectId, data);
                return "Object created with ID: " + objectId;
            case "read":
                return objects.getOrDefault(data, "Object not found");
            case "update":
                if (objects.containsKey(data.split(",")[0])) {
                    objects.put(data.split(",")[0], data.split(",")[1]);
                    return "Object updated";
                }
                return "Object not found";
            case "delete":
                if (objects.remove(data) != null) {
                    return "Object deleted";
                }
                return "Object not found";
            default:
                return "Invalid operation";
        }
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            RemoteObjectImpl obj = new RemoteObjectImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RemoteObject", obj);
            System.out.println("Server is running...");
            
            // Test cases
            RemoteObjectInterface stub = (RemoteObjectInterface) registry.lookup("RemoteObject");
            String sessionToken = "test-session-token";
            
            // Test case 1: Create object
            System.out.println(stub.performOperation(sessionToken, "create", "test data 1"));
            
            // Test case 2: Create another object
            String response = stub.performOperation(sessionToken, "create", "test data 2");
            String objectId = response.split(": ")[1];
            
            // Test case 3: Read object
            System.out.println(stub.performOperation(sessionToken, "read", objectId));
            
            // Test case 4: Update object
            System.out.println(stub.performOperation(sessionToken, "update", objectId + ",updated data"));
            
            // Test case 5: Delete object
            System.out.println(stub.performOperation(sessionToken, "delete", objectId));
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
