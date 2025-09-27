package Vanilla.codestral;
import java.rmi.Remote;
import java.rmi.RemoteException;

interface Remote1 extends java.rmi.Remote {
    void remoteMethod() throws RemoteException;
}

class ServerObject implements Remote1 {
    public void remoteMethod() throws RemoteException {
        // Implementation here
    }
}

public class Task108 {
    // Server and Client classes here
}