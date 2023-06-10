import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket client = new Socket("localhost", 5000);
            System.out.println("Client is connected");

            //read data from server
//            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            while (true) {
//                String data = br.readLine();
//                System.out.println("Data from server: "+data);
//            }

            //send data from client to server
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true){
                System.out.println("Enter data");
                String data = sc.nextLine();
                pw.println(data);
                pw.flush();
                String message = br.readLine();
                System.out.println("Message from server: "+message);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
