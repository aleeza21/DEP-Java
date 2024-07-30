package distsystem;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Lookup services
            ResShare node1 = (ResShare) Naming.lookup("Node1Service");
            ResShare node2 = (ResShare) Naming.lookup("Node2Service");

            // Register peers dynamically
            node1.registerPeer("Node2", node2);
            node2.registerPeer("Node1", node1);

            // Update shared resource from Node1
            node1.updateSharedResource(10);
            System.out.println("Node1 updated shared resource to: " + node1.getSharedResource());

            // Node2 should be able to see the updated shared resource
            System.out.println("Node2 reads shared resource value: " + node2.getSharedResource());

            // Node1 sends a message to Node2
            String response = node1.sendMessageToNode("Node2", "Hello from Node1");
            System.out.println("Response from Node2: \n" + response);

        } catch (Exception e) {
            System.out.println("ResShareClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
