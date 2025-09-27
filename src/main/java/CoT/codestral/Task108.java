package CoT.codestral;
import java.rmi.*;
import java.rmi.server.*;

interface MyRemoteObject extends Remote {
    public String manipulateObject(String input) throws RemoteException;
}

public class Task108 extends UnicastRemoteObject implements MyRemoteObject {
    public Task108() throws RemoteException {
        super();
    }

    public String manipulateObject(String input) throws RemoteException {
        // Implement your logic here
        return "Manipulated: " + input;
    }

//    public static void main(String args[]) {
//        try {
//            MyRemoteObjectImpl obj = new MyRemoteObjectImpl();
//            Naming.rebind("MyRemoteObject", obj);
//            System.out.println("Server is ready.");
//        } catch (Exception e) {
//            System.out.println("Server exception: " + e.toString());
//            e.printStackTrace();
//        }
//    }
}