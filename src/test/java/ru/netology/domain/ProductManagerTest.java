package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book product1 = new Book(1, "Летос", 150, "Алексей Пехов");
    Smartphone product2 = new Smartphone(2, "iPhoneXS", 1_000, "Apple");
    Smartphone product3 = new Smartphone(3, "Galaxy", 500, "Samsung");
    Book product4 = new Book(4, "Евгений Онегин", 250, "Александр Пушкин");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test
    public void shouldAddProduct() {

        Product[] expected = { product1, product2, product3, product4 };
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {

        Product[] expected = { product3 };
        Product[] actual = manager.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthor() {

        Product[] expected = { product1 };
        Product[] actual = manager.searchBy("Алексей Пехов");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByManufacturer() {

        Product[] expected = { product2 };
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBook() {

        Product[] expected = { product4 };
        Product[] actual = manager.searchBy("Онегин");

        Assertions.assertArrayEquals(expected, actual);

    }

}
