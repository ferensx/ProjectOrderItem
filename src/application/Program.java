package application;


import entities.Client;
import entities.Order;
import entities.Orderitem;
import entities.Product;
import entities.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String args []) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

     System.out.println("Enter Client data: ");
     System.out.print("Name: ");
     String name =sc.nextLine();

     System.out.print("Email: ");
     String email =sc.next();

     System.out.println("Birth date (DD/MM/YYYY)");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name,email,birthDate);

        System.out.println("Enter order Data: ");
        System.out.print("Status: ");
        OrderStatus status =OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status,client);

        System.out.print("How many items to this order ? ");
        int n =sc.nextInt();
        for (int i =0; i <n ; i++){
            System.out.println("Enter #" +i+1+" item data: ");
            System.out.print("Product Name: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice =sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity =sc.nextInt();

            Product product = new Product(productName,productPrice);

            Orderitem it =new Orderitem(quantity,productPrice,product);

            order.addItem(it);

        }



        System.out.println(order);
        sc.close();
    }

}

