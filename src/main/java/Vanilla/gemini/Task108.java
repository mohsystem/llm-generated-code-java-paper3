package Vanilla.gemini;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

interface RemoteObjectInterface extends java.rmi.Remote {
    String getName() throws RemoteException;
    void setName(String name) throws RemoteException;
    int getValue() throws RemoteException;
    void setValue(int value) throws RemoteException;
}

class RemoteObject implements RemoteObjectInterface {
    private String name;
    private int value;

    public RemoteObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public int getValue() throws RemoteException {
        return value;
    }

    @Override
    public void setValue(int value) throws RemoteException {
        this.value = value;
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);

            RemoteObject obj = new RemoteObject("Object1", 10);
            RemoteObjectInterface stub = (RemoteObjectInterface) UnicastRemoteObject.exportObject(obj, 0);
            registry.rebind("MyRemoteObj", stub);

            System.out.println("Server ready...");


            // Test cases (Client-side code would typically perform these actions)
            RemoteObjectInterface remoteObj = (RemoteObjectInterface) registry.lookup("MyRemoteObj");


            System.out.println("Initial Name: " + remoteObj.getName());
            System.out.println("Initial Value: " + remoteObj.getValue());

            remoteObj.setName("NewName");
            remoteObj.setValue(20);


            System.out.println("Updated Name: " + remoteObj.getName());
            System.out.println("Updated Value: " + remoteObj.getValue());


            remoteObj.setName("Object2");
            remoteObj.setValue(30);
            System.out.println("Updated Name: " + remoteObj.getName());
            System.out.println("Updated Value: " + remoteObj.getValue());

            remoteObj.setName("Object3");
            remoteObj.setValue(40);
            System.out.println("Updated Name: " + remoteObj.getName());
            System.out.println("Updated Value: " + remoteObj.getValue());

            remoteObj.setName("Object4");
            remoteObj.setValue(50);
            System.out.println("Updated Name: " + remoteObj.getName());
            System.out.println("Updated Value: " + remoteObj.getValue());



        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}