import university.Student;
import vehicles.FuelType;
import vehicles.MotorVehicleInner;
import vehicles.MotorVehicleNested;
import visibility.FieldsVisibility;
import visibility.Task;
import visibility.TaskCallable;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {

    public static void main(String[] args) {
// Boxing
        Integer integerObject = Integer.valueOf(100);
        Double doubleObject = Double.valueOf(90.9);

        System.out.println(integerObject);
        System.out.println(doubleObject);

        doubleObject = Double.valueOf("108.901");
        System.out.println(doubleObject);
        // Unboxing
        int i = integerObject.intValue();

        System.out.println(i);

        // Autoboxing
        integerObject = 200;
        System.out.println(integerObject);

        // Auto-unboxing
        i = integerObject;
        System.out.println(i);

        // Nested Classes
        MotorVehicleNested.InternalCombustionEngine internalCombustionEngine =
                new MotorVehicleNested.InternalCombustionEngine(3000, FuelType.DIESEL);

        MotorVehicleNested.InternalCombustionEngine internalCombustionEngine2 =
                new MotorVehicleNested.InternalCombustionEngine(4000, FuelType.GASOLINE);

        MotorVehicleNested motorVehicleNested =
                new MotorVehicleNested("BMW", 12000, internalCombustionEngine);
        System.out.println(motorVehicleNested);

        // Nested Classes
        MotorVehicleInner motorVehicleInner =
                new MotorVehicleInner("Pegeout", 10000, 2000, FuelType.GASOLINE);
        System.out.println(motorVehicleInner);


        try {
            Class<?> c = Class.forName("university.Person");

            // Getting constructors
            Constructor<?>[] constructors = c.getConstructors();
            System.out.println("Constructors: " + Arrays.toString(constructors));

            // Getting methods
            Method[] methods = c.getMethods();
            System.out.println("Methods: " + Arrays.toString(methods));

            // Getting declared methods
            Method[] declaredMethods = c.getDeclaredMethods();
            System.out.println("Declared methods: " + Arrays.toString(declaredMethods));

            // Getting fields
            Field[] declaredFields = c.getDeclaredFields();
            System.out.println("Declared fields: " + Arrays.toString(declaredFields));

            // Metadata of a class
            System.out.println("Class name: " + c.getName());
            System.out.println("Class simple name: " + c.getSimpleName());

            Class<?> studentClass = Class.forName("university.Student");

            // Super class
            System.out.println("Super class name: " + studentClass.getSuperclass());

            // Interfaces
            System.out.println("Interfaces names: " + Arrays.toString(studentClass.getInterfaces()));

            // Modifiers
            System.out.println("Modifiers: " + Modifier.toString(studentClass.getModifiers()));

            // Fields (public fields)
            System.out.println("Fields: " + Arrays.toString(studentClass.getFields()));

            // Declared fields
            System.out.println("Declared fields: " + Arrays.toString(studentClass.getDeclaredFields()));

            // Constructors and declared constructors
            System.out.println("Constructors: " + Arrays.toString(studentClass.getConstructors()));
            System.out.println("Declared constructors: " + Arrays.toString(studentClass.getDeclaredConstructors()));

            // Annotations
            Annotation[] annotations = studentClass.getAnnotations();
            System.out.println("Annotations: " + Arrays.toString(annotations));

            // Declared Annotations
            Annotation[] declaredAnnotations = studentClass.getDeclaredAnnotations();
            System.out.println("Declared Annotations: " + Arrays.toString(declaredAnnotations));

            // Invoking private method
            Method method = studentClass.getDeclaredMethod("privateMessage");
            method.setAccessible(true);
            System.out.println("Private method without parameters: " + method.invoke(new Student()));
            method = studentClass.getDeclaredMethod("privateMessageWithParam", String.class);
            method.setAccessible(true);
            System.out.println("Private method with parameters: " + method.invoke(new Student(), "This the private message passed as argument!"));

            // Access private field of a class
            Field field = studentClass.getDeclaredField("fNumber");
            field.setAccessible(true);
            Student testStudent = new Student("Ivan", 20, "F12345");
            System.out.println("Getting private field: " + field.get(testStudent));
            field.set(testStudent, "F99999");
            System.out.println("Modified private field: " + field.get(testStudent));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        // Fields visibility Volatile and Atomic Integer
        System.out.println("--------------------------- Fields Visibility -----------------------");

        FieldsVisibility fieldsVisibility = new FieldsVisibility();

        new Thread(() -> {
            fieldsVisibility.printNumber();
        }).start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            fieldsVisibility.setFlag(false);
        }).start();

        new Thread(() -> {
            fieldsVisibility.incrementAtomicNumber();
        }).start();

        new Thread(() -> {
            fieldsVisibility.incrementAtomicNumber();
        }).start();

        // Semaphore
        System.out.println("--------------------------- Semaphore -----------------------");
        Semaphore semaphore = new Semaphore(4);
        System.out.println("Permits: " + semaphore.availablePermits());
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Permits: " + semaphore.availablePermits());
        semaphore.release();
        System.out.println("Permits: " + semaphore.availablePermits());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ExecutorService
        System.out.println("--------------------------- ExecutorService -----------------------");
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("CoreCount: " + coreCount);

        ExecutorService executorServiceFixedPool = Executors.newFixedThreadPool(coreCount);

        for (int j = 0; j < coreCount; j++) {
            executorServiceFixedPool.execute(new Task());
        }
        System.out.println("Fixed Pool Thread name: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------- ExecutorService Callable-----------------------");
        for (int j = 0; j < coreCount; j++) {
            Future<Integer> future = executorServiceFixedPool.submit(new TaskCallable());
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fixed Pool Thread name: " + Thread.currentThread().getName());


        ExecutorService executorServiceCachedPool = Executors.newCachedThreadPool();
        for (int j = 0; j < coreCount; j++) {
            executorServiceCachedPool.execute(new Task());
        }
        System.out.println("Cached Pool Thread name: " + Thread.currentThread().getName());

        ScheduledExecutorService executorServiceScheduledPool = Executors.newScheduledThreadPool(coreCount);
        executorServiceScheduledPool.schedule(new Task(), 10, SECONDS);
        executorServiceScheduledPool.scheduleAtFixedRate(new Task(), 5, 10, SECONDS);
        executorServiceScheduledPool.scheduleWithFixedDelay(new Task(), 5, 10, SECONDS);
        System.out.println("Cached Pool Thread name: " + Thread.currentThread().getName());


        System.out.println("--------------------------- Stop a Thread -----------------------");

    }
}
