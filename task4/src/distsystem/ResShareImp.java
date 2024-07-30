package distsystem;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ResShareImp extends UnicastRemoteObject implements ResShare {
    private static final long serialVersionUID = 1L;
    private final Map<String, ResShare> peerNodes = new HashMap<>();
    private int sharedResource = 0;  // Shared resource

    protected ResShareImp() throws RemoteException {
        super();
    }

    @Override
    public String getMessage() throws RemoteException {
        return "Hello from " + this.toString();
    }

    @Override
    public String sendMessageToNode(String nodeName, String message) throws RemoteException {
        ResShare node = peerNodes.get(nodeName);
        if (node != null) {
            return node.getMessage() + " \nReceived message: " + message;
        } else {
            return "Node not found.";
        }
    }

    @Override
    public int getSharedResource() throws RemoteException {
        return sharedResource;
    }

    @Override
    public void updateSharedResource(int value) throws RemoteException {
        sharedResource = value;
    }

    @Override
    public void registerPeer(String nodeName, ResShare peer) throws RemoteException {
        peerNodes.put(nodeName, peer);
    }

    @Override
    public ResShare getPeer(String nodeName) throws RemoteException {
        return peerNodes.get(nodeName);
    }
}
