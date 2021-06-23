package entities;

import entities.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

     private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus Status;

    private Client client;
    private List<Orderitem> items = new ArrayList<Orderitem>();

    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        Status = status;
        this.client = client;

    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return Status;
    }

    public void setStatus(OrderStatus status) {
        Status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void addItem(Orderitem item){
        items.add(item);

    }
    public void removeItem(Orderitem item){
        items.remove(item);
    }
    public Double total() {
        double sum = 0.0;
        for (Orderitem it : items) {
            sum += it.subTotal();

        }
        return sum;
    }
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order Status: ");
        sb.append(Status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");
        for (Orderitem item: items){
        sb.append(item + "\n");
    }
    sb.append("Total price: $");
    sb.append(String.format("%.2f" ,  total()));
    return sb.toString();
    }

    }



