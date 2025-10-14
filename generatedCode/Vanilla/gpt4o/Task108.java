package Vanilla.openai;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

interface RemoteObject extends Remote {
    String manipulateObject(String data) throws RemoteException;
}

class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObject {
    public RemoteObjectImpl() throws RemoteException {
        super();
    }

    public String manipulateObject(String data) throws RemoteException {
        return "Manipulated: " + data.toUpperCase();
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            RemoteObjectImpl obj = new RemoteObjectImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("RemoteObject", obj);
            System.out.println("Remote Object Bound and Ready.");

            // Test cases
            String[] testCases = {"test", "java", "rmi", "example", "code"};
            for (String testCase : testCases) {
                System.out.println(obj.manipulateObject(testCase));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}