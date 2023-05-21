/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cscb525;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Task 1 Week 2
 * @author Kostadinova
 */
public class OnlineShop {

    private String name;
    private Queue<Order> queueOfOrders;

    public OnlineShop() {
        name = "No Name";
        queueOfOrders = new PriorityQueue();
    }

    public OnlineShop(String name) {
        this.name = name;
        this.queueOfOrders = new PriorityQueue();
    }

    public OnlineShop(String name, Queue<Order> queueOfOrders) {
        this.name = name;
        this.queueOfOrders = queueOfOrders;
    }

    public String getName() {
        return name;
    }

    void addOrder(Order order) {
        queueOfOrders.offer(order);
    }

    public void displayOrders() {
        if (queueOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            System.out.println(queueOfOrders);
        }
    }

    public Order removeOrder() {
       return queueOfOrders.poll();
    }

    public void removeAllOrders() {
        if (queueOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            Order polled;
            while ((polled = queueOfOrders.poll()) != null) {
                System.out.println(polled);
            }
        }
    }

    @Override
    public String toString() {
        return "OnlineShop{" + "name=" + name + ", queueOfOrders=" + queueOfOrders + '}';
    }

}
