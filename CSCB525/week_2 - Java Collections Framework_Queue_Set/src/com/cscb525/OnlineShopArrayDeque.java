/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cscb525;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task 1 Week 4
 *
 * @author Kostadinova
 */

// Task 2 Week 2
public class OnlineShopArrayDeque {

    private String name;
    private Deque<Order> arrayDequeOfOrders;

    public OnlineShopArrayDeque() {
        this.name = "No Name";
        arrayDequeOfOrders = new ArrayDeque();
    }

    public OnlineShopArrayDeque(String name) {
        this.name = name;
        arrayDequeOfOrders = new ArrayDeque();
    }

    public OnlineShopArrayDeque(String name, Deque<Order> arrayDequeOfOrders) {
        this.name = name;
        this.arrayDequeOfOrders = arrayDequeOfOrders;
    }

    public String getName() {
        return name;
    }

    public void displayOrders() {
        if (arrayDequeOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            System.out.println(arrayDequeOfOrders);
        }
    }

    public void removeOrder() {

        System.out.println(arrayDequeOfOrders.remove());
    }

    public void removeAllOrders() {
        if (arrayDequeOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            for (Order order : arrayDequeOfOrders) {
                System.out.println(arrayDequeOfOrders.remove());
            }
        }
    }

    @Override
    public String toString() {
        return "OnlineShop{" + "name=" + name + ", queueOfOrders=" + arrayDequeOfOrders + '}';
    }

    void addOrder(Order order) {
        arrayDequeOfOrders.offer(order);
    }
}
