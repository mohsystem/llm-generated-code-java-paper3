package ourMethodv2.gpt4o;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;

interface RemoteInterface extends Remote {
    String getData(int index) throws RemoteException;
    void addData(String data) throws RemoteException;
    List<String> getAllData() throws RemoteException;
}

class RemoteImplementation extends UnicastRemoteObject implements RemoteInterface {
    private List<String> dataList;

    protected RemoteImplementation() throws RemoteException {
        super();
        this.dataList = new ArrayList<>();
    }

    public String getData(int index) throws RemoteException {
        if (index >= 0 && index < dataList.size()) {
            return dataList.get(index);
        }
        return "Index out of bounds";
    }

    public void addData(String data) throws RemoteException {
        dataList.add(data);
    }

    public List<String> getAllData() throws RemoteException {
        return new ArrayList<>(dataList);
    }
}

public class Task108 {
    public static void main(String[] args) {
        try {
            RemoteImplementation obj = new RemoteImplementation();
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RemoteObject", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}