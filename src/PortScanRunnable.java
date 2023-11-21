import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanRunnable implements Runnable {
    private final String ipAddress;
    private final int port;
    private final int timeout;

    public PortScanRunnable(String ipAddress, int port, int timeout) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, port), timeout);
            String info = "Порт " + port + " открыт";
            System.out.println(info);
            socket.close();
            Main.arrayList.add(ipAddress + ";" + port);
        } catch (Exception e) {

        }
    }
}