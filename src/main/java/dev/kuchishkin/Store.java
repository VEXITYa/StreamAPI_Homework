package dev.kuchishkin;


import dev.kuchishkin.model.Customer;
import dev.kuchishkin.model.Order;
import dev.kuchishkin.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Store {
    public static void main(String[] args) {
        // Список продуктов
        List<Product> allProducts = Arrays.asList(
                new Product(1L, "Яблоко", "Fruits", new BigDecimal("100.0")),
                new Product(2L, "Банан", "Fruits", new BigDecimal("120.0")),
                new Product(3L, "Молоко", "Dairy", new BigDecimal("80.0")),
                new Product(4L, "Хлеб", "Bread", new BigDecimal("50.0")),
                new Product(5L, "Сыр", "Dairy", new BigDecimal("250.0")),
                new Product(6L, "Картофель", "Vegetables", new BigDecimal("40.0")),
                new Product(7L, "Морковь", "Vegetables", new BigDecimal("30.0")),
                new Product(8L, "Мясо", "Meat", new BigDecimal("400.0")),
                new Product(9L, "Рыба", "Meat", new BigDecimal("500.0")),
                new Product(10L, "Яйца", "Dairy", new BigDecimal("70.0")),
                new Product(11L, "Гарри Поттер", "Books", new BigDecimal("800.0")),
                new Product(12L, "Война и Мир", "Books", new BigDecimal("900.0")),
                new Product(13L, "Конструктор Лего", "Toys", new BigDecimal("1500.0")),
                new Product(14L, "Мягкая игрушка", "Toys", new BigDecimal("500.0")),
                new Product(15L, "Детская книжка", "Children's products", new BigDecimal("300.0")),
                new Product(16L, "Паззл", "Children's products", new BigDecimal("400.0"))
                                                 );

        // Список покупателей
        List<Customer> customers = new ArrayList<>();


        Set<Order> customer1Orders = new HashSet<>();
        customer1Orders.add(new Order(1L, LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 17), "Доставлен",
                                      Set.of(allProducts.get(0), allProducts.get(1))));
        customer1Orders.add(new Order(2L, LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 12), "Доставлен",
                                      Set.of(allProducts.get(2), allProducts.get(3))));
        customer1Orders.add(new Order(3L, LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 16), "Ожидание",
                                      Set.of(allProducts.get(4), allProducts.get(5))));
        customer1Orders.add(new Order(4L, LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 17), "Отменён",
                                      Set.of(allProducts.get(6), allProducts.get(7))));
        customer1Orders.add(new Order(5L, LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 22), "Доставлен",
                                      Set.of(allProducts.get(10), allProducts.get(11))));

        customers.add(new Customer(1L, "Иванов Иван", 1L, customer1Orders));


        Set<Order> customer2Orders = new HashSet<>();
        customer2Orders.add(new Order(6L, LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 7), "В обработке",
                                      Set.of(allProducts.get(1), allProducts.get(2))));
        customer2Orders.add(new Order(7L, LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 3), "Доставлен",
                                      Set.of(allProducts.get(3), allProducts.get(4))));
        customer2Orders.add(new Order(8L, LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 12), "Ожидание",
                                      Set.of(allProducts.get(5), allProducts.get(6))));
        customer2Orders.add(new Order(9L, LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 22), "Отменён",
                                      Set.of(allProducts.get(12), allProducts.get(13))));
        customer2Orders.add(new Order(10L, LocalDate.of(2021, 2, 28), LocalDate.of(2021, 3, 2), "Доставлен",
                                      Set.of(allProducts.get(9), allProducts.get(0))));

        customers.add(new Customer(2L, "Петров Пётр", 2L, customer2Orders));


        Set<Order> customer3Orders = new HashSet<>();
        customer3Orders.add(new Order(11L, LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 3), "В обработке",
                                      Set.of(allProducts.get(0), allProducts.get(3))));
        customer3Orders.add(new Order(12L, LocalDate.of(2021, 2, 14), LocalDate.of(2021, 2, 16), "Доставлен",
                                      Set.of(allProducts.get(1), allProducts.get(4))));
        customer3Orders.add(new Order(13L, LocalDate.of(2021, 2, 25), LocalDate.of(2021, 2, 27), "Ожидание",
                                      Set.of(allProducts.get(2), allProducts.get(5))));
        customer3Orders.add(new Order(14L, LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 7), "Отменён",
                                      Set.of(allProducts.get(14), allProducts.get(15))));
        customer3Orders.add(new Order(15L, LocalDate.of(2021, 3, 25), LocalDate.of(2021, 3, 27), "Доставлен",
                                      Set.of(allProducts.get(8), allProducts.get(9))));

        customers.add(new Customer(3L, "Сидоров Сидор", 1L, customer3Orders));


        Set<Order> customer4Orders = new HashSet<>();
        customer4Orders.add(new Order(16L, LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 12), "В обработке",
                                      Set.of(allProducts.get(4), allProducts.get(7))));
        customer4Orders.add(new Order(17L, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 3), "Доставлен",
                                      Set.of(allProducts.get(5), allProducts.get(8))));
        customer4Orders.add(new Order(18L, LocalDate.of(2021, 3, 12), LocalDate.of(2021, 3, 14), "Ожидание",
                                      Set.of(allProducts.get(6), allProducts.get(9))));
        customer4Orders.add(new Order(19L, LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 7), "Отменён",
                                      Set.of(allProducts.get(0), allProducts.get(1))));
        customer4Orders.add(new Order(20L, LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 22), "Доставлен",
                                      Set.of(allProducts.get(10), allProducts.get(11))));

        customers.add(new Customer(4L, "Михайлов Михаил", 2L, customer4Orders));


        Set<Order> customer5Orders = new HashSet<>();
        customer5Orders.add(new Order(21L, LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 17), "В обработке",
                                      Set.of(allProducts.get(1), allProducts.get(5))));
        customer5Orders.add(new Order(22L, LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 22), "Доставлен",
                                      Set.of(allProducts.get(3), allProducts.get(7))));
        customer5Orders.add(new Order(23L, LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 16), "Ожидание",
                                      Set.of(allProducts.get(0), allProducts.get(8))));
        customer5Orders.add(new Order(24L, LocalDate.of(2021, 2, 28), LocalDate.of(2021, 3, 2), "Отменён",
                                      Set.of(allProducts.get(14), allProducts.get(15))));
        customer5Orders.add(new Order(25L, LocalDate.of(2021, 3, 30), LocalDate.of(2021, 4, 1), "Доставлен",
                                      Set.of(allProducts.get(4), allProducts.get(9))));

        customers.add(new Customer(5L, "Андреев Андрей", 3L, customer5Orders));


        // Выводим информацию о покупателях и их заказах
        for (Customer customer : customers) {
            System.out.println("Покупатель: " + customer.getName() + ", уровень: " + customer.getLevel());
            System.out.println("Заказы:");
            for (Order order : customer.getOrders()) {
                System.out.println("  Заказ ID: " + order.getId() + ", статус: " + order.getStatus() + ", дата: " + order.getOrderDate());
                System.out.println("    Продукты:");
                for (Product product : order.getProducts()) {
                    System.out.println("      " + product.getName() + " [" + product.getCategory() + "] - " + product.getPrice());
                }
            }
            System.out.println();
        }


        /*
        1. Получите список продуктов из категории "Books" с ценой более 100.
         */
        System.out.println();
        System.out.println("Задание 1:");
        List<Product> task1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .filter(product -> product.getCategory().equals("Books")
                                   && product.getPrice().compareTo(new BigDecimal(100)) > 0)
                .toList();
        task1.forEach(System.out::println);
        System.out.println();


        /*
        2. Получите список заказов с продуктами из категории "Children's products"
         */
        System.out.println("Задание 2:");
        List<Order> task2 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Children's products"))
                       )
                .toList();
        task2.forEach(System.out::println);
        System.out.println();


        /*
        3. Получите список продуктов из категории "Toys" и примените скидку 10% и получите сумму всех
        продуктов.
         */
        System.out.println("Задание 3:");
        BigDecimal task3 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Toys"))
                .distinct()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(.9d)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(task3);
        System.out.println();


        /*
        4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.
         */
        System.out.println("Задание 4:");
        List<Product> task4 = customers.stream()
                .filter(customer -> customer.getLevel() == 2)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))
                                 && order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))
                       )
                .flatMap(order -> order.getProducts().stream())
                .toList();
        task4.forEach(System.out::println);
        System.out.println();


        /*
        5. Получите топ 2 самые дешевые продукты из категории "Books".
         */
        System.out.println("Задание 5:");
        List<Product> task5 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .filter(product -> product.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice, BigDecimal::compareTo))
                .limit(2)
                .toList();
        task5.forEach(System.out::println);
        System.out.println();


        /*
        6. Получите 3 самых последних сделанных заказа.
         */
        System.out.println("Задание 6");
        List<Order> task6 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .sorted(Comparator.comparing(Order::getOrderDate, LocalDate::compareTo).reversed())
                .limit(3)
                .toList();
        task6.forEach(System.out::println);
        System.out.println();


        /*
        7. Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните
        список их продуктов
         */
        System.out.println("Задание 7:");
        List<Product> task7 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(order -> System.out.println(order.getId()))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
        task7.forEach(System.out::println);
        System.out.println();


        /*
        8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
         */
        System.out.println("Задание 8:");
        BigDecimal task8 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getMonthValue() == 3 && order.getOrderDate().getYear() == 2021)
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(task8);
        System.out.println();


        /*
        9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.
         */
        System.out.println("Задание 9:");
        var task9 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .mapToDouble(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue())
                .average();
        if (task9.isPresent()) {
            System.out.println(task9.getAsDouble());
        } else {
            System.out.println("Нет заказов за 14 марта 2021");
        }
        System.out.println();


        /*
        10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех
        продуктов категории "Книги".
         */
        System.out.println("Задание 10:");
        DoubleSummaryStatistics task10 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .summaryStatistics();
        System.out.println("Среднее: " + task10.getAverage());
        System.out.println("Сумма: " + task10.getSum());
        System.out.println("Количество: " + task10.getCount());
        System.out.println("Минимум: " + task10.getMin());
        System.out.println("Максимум: " + task10.getMax());
        System.out.println();


        /*
        11. Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе
         */
        System.out.println("Задание 11:");
        Map<Long, Integer> task11 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(Order::getId, (order -> order.getProducts().size())));
        System.out.println(task11.entrySet());
        System.out.println();


        /*
        12. Создайте Map<Customer, List<Order>> → key - покупатель, value - список его заказов
         */
        System.out.println("Задание 12:");
        Map<Customer, List<Order>> task12 = customers.stream()
                .collect(Collectors.toMap(customer -> customer,
                                          customer -> customer.getOrders().stream().toList()));
        task12.forEach((customer, orders) -> {
            System.out.println(customer);
            orders.forEach(System.out::println);
            System.out.println();
        });


        /*
        13. Создайте Map<Order, Double> → key - заказ, value - общая сумма продуктов заказа.
         */
        System.out.println("Задание 13:");
        Map<Order, Double> task13 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .collect(Collectors.toMap(
                        order -> order,
                        order -> order.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()
                                         ));
        task13.forEach((order, products) -> {
            System.out.println(order);
            System.out.println(products);
            System.out.println();
        });


        /*
        14. Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории
         */
        System.out.println("Задание 14:");
        Map<String, List<String>> task14 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));
        task14.forEach((group, products) -> {
            System.out.println(group);
            System.out.println(products);
            System.out.println();
        });


        /*
        15. Получите Map<String, Product> → самый дорогой продукт по каждой категории.
         */
        System.out.println("Задание 15:");
        Map<String, Product> task15 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Product::getPrice, BigDecimal::compareTo))),
                                products -> products.isEmpty() ? null : products.last()
                                                    )));
        task15.forEach((group, product) -> {
            System.out.println(group);
            System.out.println(product);
            System.out.println();
        });
    }
}
