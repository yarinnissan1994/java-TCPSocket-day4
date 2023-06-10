import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Waiting for Client");
            Socket server = ss.accept();
            System.out.println("Server is connected");

            //send data from server to client
//            Scanner sc = new Scanner(System.in);
//            PrintWriter pw = new PrintWriter(server.getOutputStream());
//            while (true){
//                System.out.println("Enter data");
//                String data = sc.nextLine();
//                pw.println(data);
//                pw.flush();
//            }

            //read data from client
            BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter pw = new PrintWriter(server.getOutputStream());
            while (true) {
                String data = br.readLine();
                System.out.println("Data from client: "+data);
                pw.println("Your message has been received.");
                pw.flush();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
