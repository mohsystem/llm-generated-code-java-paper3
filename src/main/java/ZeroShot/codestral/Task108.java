package ZeroShot.codestral;
import java.rmi.*;
import java.rmi.server.*;

public interface Task108 extends Remote {
    public String manipulateObject(String command) throws RemoteException;
}