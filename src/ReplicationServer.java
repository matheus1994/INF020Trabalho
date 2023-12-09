
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ReplicationServer extends UnicastRemoteObject implements ReplicationInterface {

    protected ReplicationServer() throws RemoteException {
        super();
    }

    @Override
    public void sendDataToReplicas(String data) throws RemoteException {
        System.out.println("Dados recebidos: " + data);
        //pendente 
    }

    public static void main(String[] args) {
        try {
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startServer() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        ReplicationServer server = new ReplicationServer();
        registry.rebind("ReplicationServer", server);
        System.out.println("Servidor RMI pronto para receber dados...");
    }
}