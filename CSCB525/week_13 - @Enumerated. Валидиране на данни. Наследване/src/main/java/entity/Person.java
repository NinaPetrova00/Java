package entity;

import javax.persistence.*;

@MappedSuperclass
//@Entity
//@Table(name = "person")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED) // първичния ключ на едната таблица е външен ключ на другата
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

    // Първи начин: нямам таблица Person в схемата на базата чрез @MappedSuperclass
    // Втори начин: да си направя таблица Person в схемата на базата чрез
    //1) @Entity
    //2) @Table(name = "person")
    //3) @Inheritance(strategy = InheritanceType.JOINED) или от другите два варианта


    // това поле ще е първичния ключ на всичките наследници на Person
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
