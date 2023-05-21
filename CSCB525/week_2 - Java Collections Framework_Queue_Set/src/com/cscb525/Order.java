package com.cscb525;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Comparator;

/**
 * Task 1 and Task 2 Week 2
 *
 * @author Kostadinova
 */
public class Order implements Comparable<Order> {

    private String name;
    private Priority priority;

    public Order() {
        this.name = "No Name";
        this.priority = Priority.MEDIUM;
    }

    public Order(String name) {
        this.name = name;
        this.priority = Priority.MEDIUM;
    }

    public Order(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Order{" + "name=" + name + ", priority=" + priority + '}';
    }

    @Override
    public int compareTo(Order order) {
        return Integer.compare(this.priority.getCode(), order.priority.getCode());
    }

    public static Comparator<Order> ComparatorByOrderName = new Comparator<Order>() {
        @Override
        public int compare(Order order, Order order1) {
            return order.name.compareTo(order1.name);
        }
    };

    public static Comparator<Order> ComparatorByOrderPriority = new Comparator<Order>() {
        @Override
        public int compare(Order order, Order order1) {
            return order.priority.compareTo(order1.priority);
        }
    };
}
