package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Book product1 = new Book(1, "Летос", 150, "Алексей Пехов");
    Smartphone product2 = new Smartphone(2, "iPhoneXS", 1_000, "Apple");
    Smartphone product3 = new Smartphone(3, "Galaxy", 500, "Samsung");
    Product product4 = new Book(4, "Евгений Онегин", 250, "Александр Пушкин");

    @BeforeEach
    public void setup() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
    }

    @Test
    public void shouldSave() {

        Product[] expected = { product1, product2, product3, product4 };
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldremoveById() {

        repository.removeById(3);

        Product[] expected = { product1, product2, product4 };
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

}
