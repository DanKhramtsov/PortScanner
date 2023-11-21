public class NetworkScanner {

    public static void networkScan(String ipAddress) {

        int timeout = 150;

        for (int i = 1; i <= 65535; i++) {
            Thread thread = new Thread(new PortScanRunnable(ipAddress, i, timeout));
            thread.start();
        }
        System.out.printf("Сканирование порта \s завершено\n", ipAddress);

    }
}

