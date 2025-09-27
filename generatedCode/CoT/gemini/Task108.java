package CoT.gemini;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

interface RemoteObjectManipulator extends java.rmi.Remote {
    Object getObject(String name) throws RemoteException;
    void setObject(String name, Object obj) throws RemoteException;
}

class RemoteObjectManipulatorImpl extends UnicastRemoteObject implements RemoteObjectManipulator {
    private Map<String, Object> objects = new HashMap<>();

    public RemoteObjectManipulatorImpl() throws RemoteException {
        super();
    }

    @Override
    public Object getObject(String name) throws RemoteException {
        return objects.get(name);
    }

    @Override
    public void setObject(String name, Object obj) throws RemoteException {
        objects.put(name, obj);
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099); 
            RemoteObjectManipulator obj = new RemoteObjectManipulatorImpl();
            registry.rebind("RemoteObjectManipulator", obj);
            System.out.println("Server ready");

             // Test cases (Client-side code would typically perform these actions)
            RemoteObjectManipulator manipulator = (RemoteObjectManipulator) LocateRegistry.getRegistry("localhost",1099).lookup("RemoteObjectManipulator");


            manipulator.setObject("test1", "Hello, world!");
            System.out.println(manipulator.getObject("test1"));


            manipulator.setObject("test2", 12345);
            System.out.println(manipulator.getObject("test2"));

            manipulator.setObject("test3", new double[] {1.0, 2.0, 3.0});
            System.out.println(manipulator.getObject("test3"));


            manipulator.setObject("test4", null);
            System.out.println(manipulator.getObject("test4"));


            manipulator.setObject("test5", new HashMap<>());
            System.out.println(manipulator.getObject("test5"));





        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}