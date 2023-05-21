package com.cscb525;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Task 1 Week 2 PriorityQueue
        {
            System.out.println("----------------------------------- Task 1 PriorityQueue Orders: -----------------------------------");
            Order order1 = new Order("Order 1", Priority.MEDIUM);
            Order order2 = new Order("Order 2", Priority.MEDIUM);
            Order order3 = new Order("Order 3", Priority.HIGH);
            Order order4 = new Order("Order 4", Priority.LOW);

            OnlineShop topShop = new OnlineShop("Top Shop");

            topShop.displayOrders();

            topShop.addOrder(order4);
            topShop.addOrder(order3);
            topShop.addOrder(order1);
            topShop.addOrder(order2);
            topShop.addOrder(order3);
            topShop.addOrder(order2);

            topShop.displayOrders();
            topShop.removeAllOrders();
            System.out.println(topShop.removeOrder());
            topShop.displayOrders();

            Queue<Order> orders = new PriorityQueue<>(
                    Order.ComparatorByOrderPriority.thenComparing(Order.ComparatorByOrderName));
            orders.add(order4);
            orders.add(order3);
            orders.add(order1);
            orders.add(order2);
            orders.add(order3);
            orders.add(order2);
            OnlineShop topShop2 = new OnlineShop("Top Shop 2", orders);
            topShop2.displayOrders();
            topShop2.removeAllOrders();

        }
        //Task 2 Week 2 ArrayDeque
        {
            System.out.println("----------------------------------- Task 2 ArrayDeque Orders: -----------------------------------");
            Order order1 = new Order("Order 1", Priority.MEDIUM);
            Order order2 = new Order("Order 2", Priority.MEDIUM);
            Order order3 = new Order("Order 3", Priority.HIGH);
            Order order4 = new Order("Order 4", Priority.LOW);

            OnlineShopArrayDeque emag = new OnlineShopArrayDeque("eMAG");
            emag.displayOrders();

            emag.addOrder(order4);
            emag.addOrder(order3);
            emag.addOrder(order1);
            emag.addOrder(order2);
            emag.addOrder(order3);
            emag.addOrder(order2);
            emag.displayOrders();
            emag.removeAllOrders();
            emag.displayOrders();
        }

        // Task 3 Week 2 with HashSet and TreeSet
        {
            System.out.println("----------------------------------- Task 3 HashSet Courses: -----------------------------------");
            Course java = new Course("Java", 3);
            Course java1 = new Course("Java", 6);
            Course oop = new Course("OOP", 1);
            Course cPlusPlus = new Course("C++", 2);
            Course python = new Course("Python", 6);
            Course js = new Course("JS", 2);

            Program computerScience = new Program("Computer Science");
            computerScience.addCourseToHashSet(python);
            computerScience.addCourseToHashSet(java);
            computerScience.addCourseToHashSet(java1);
            computerScience.addCourseToHashSet(oop);
            computerScience.addCourseToHashSet(cPlusPlus);
            computerScience.addCourseToHashSet(python);
            computerScience.addCourseToHashSet(oop);
            computerScience.displayCoursesInHashSet();
            python.setNumberOfCredits(3);
            computerScience.addCourseToHashSet(python);
            computerScience.displayCoursesInHashSet();

            System.out.println("----------------------------------- Task 3 TreeSet Courses: -----------------------------------");
            computerScience.addCourseToTreeSet(python);
            computerScience.addCourseToTreeSet(java);
            computerScience.addCourseToTreeSet(java1);
            computerScience.addCourseToTreeSet(oop);
            computerScience.addCourseToTreeSet(cPlusPlus);
            computerScience.addCourseToTreeSet(python);
            computerScience.addCourseToTreeSet(oop);
            computerScience.displayCoursesInTreeSet();
            python.setNumberOfCredits(9);
            computerScience.addCourseToTreeSet(js);
            computerScience.displayCoursesInTreeSet();
        }
        // Task 4 Week 2 EnumSet
        {
            System.out.println("----------------------------------- Task 4 EnumSet Fruits: -----------------------------------");

            EnumSet<Fruit> enumSet1, enumSet2, enumSet3, enumSet4;
            enumSet1 = EnumSet.of(Fruit.APPLE, Fruit.CHERRY);
            enumSet2 = EnumSet.complementOf(enumSet1);
            enumSet3 = EnumSet.allOf(Fruit.class);
            enumSet4 = EnumSet.range(Fruit.APPLE, Fruit.PEAR);
            System.out.println("Set 1: " + enumSet1);
            System.out.println("Set 2: " + enumSet2);
            System.out.println("Set 3: " + enumSet3);
            System.out.println("Set 4: " + enumSet4);
        }
    }
}
