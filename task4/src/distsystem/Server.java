package distsystem;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry
            LocateRegistry.createRegistry(3333);

            // Create and bind nodes
            ResShareImp node1 = new ResShareImp();
            ResShareImp node2 = new ResShareImp();

            Naming.rebind("Node1Service", node1);
            Naming.rebind("Node2Service", node2);

            // Register peer nodes
            node1.registerPeer("Node2", node2);
            node2.registerPeer("Node1", node1);

            System.out.println("Server is ready with decentralized node interaction.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
