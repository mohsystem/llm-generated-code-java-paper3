package ZeroShot.llama31;
class RemoteClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteInterface remoteObj = (RemoteInterface) registry.lookup("RemoteInterface");
            System.out.println(remoteObj.sayHello("Client"));
            System.out.println(remoteObj.add(5, 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}