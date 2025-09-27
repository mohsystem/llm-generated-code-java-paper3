package ZeroShot.gemini;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

interface RemoteObjectInterface extends java.rmi.Remote {
    public String getObjectValue(String key) throws RemoteException;
    public void setObjectValue(String key, String value) throws RemoteException;
}

class RemoteObject implements RemoteObjectInterface {
    private Map<String, String> objectStore = new HashMap<>();

    public String getObjectValue(String key) throws RemoteException {
        return objectStore.get(key);
    }

    public void setObjectValue(String key, String value) throws RemoteException {
        objectStore.put(key, value);
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            RemoteObject obj = new RemoteObject();
            RemoteObjectInterface stub = (RemoteObjectInterface) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099); 
            registry.rebind("RemoteObject", stub);
            System.err.println("Server ready");

           //Test cases (Client-side code would typically perform these)
            // RemoteObjectInterface remoteObj = (RemoteObjectInterface) registry.lookup("RemoteObject");
            // remoteObj.setObjectValue("key1", "value1");
            // System.out.println(remoteObj.getObjectValue("key1"));

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}