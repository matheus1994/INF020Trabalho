import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReplicationInterface extends Remote {
    void sendDataToReplicas(String data) throws RemoteException;
    
}