https://www.youtube.com/watch?v=VW88wN3thqo

-> трябва да имам валидиране на данните

# **1**

in build.gradle add:
dependencies {
testImplementation 'org.junit.jupiter:junit-jupiter-api:5.3.1'
testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.3.1'
implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.12.1'
implementation group: 'org.hibernate', name: 'hibernate-core', version: '5.4.10.Final'
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.18'
}

## **2**
main->resources->hibernate.properties
main->resources->log4j2.xml

## **3**

Adding new Entity/Class from code to db
-> @Entity
-> @Table
-> Add Annotations:
https://www.w3schools.blog/jpa-generatedvalue-annotation
https://www.w3schools.blog/jpa-id-annotation

## **4**

check if everything in sessionFactoryUtil is completed

## **5**

Специални методи, които изпълняват заявки
-> dao(data access object)
В dao за всеки от entities се слага и dao, което е с основните заявки, които
са свързани с този обект

## **6**

type.Identity
логично е да изберем еднакви стратегии за id-тата, не е добре да са различни 

**7** Връзки
-> идентифицираща: таблицата НЕ може да съществува самостоятелно
-> НЕидентифицираща: две таблици могат да съществува самостоятелно

## one-to-one relationship
**video lecture week10->18min**
**1**
@OneToOne -> прави външния ключ
@JoinColumn(name = "employee_id", nullable = false, unique = true) -> избираме свойствата на колоната външен ключ
Пример: employee<-->identity card
**2**
няма нужда да се правя външни ключове и от двете страни
@OneToOne(mappedBy = "employee") -> казвам, че връзката се управлява/създадена от страната на identity card
-> полето в identity card, което се грижи за този процес се казва employee

## one-to-many relationship
**video lecture week10->54min**
-> имаме bidirectional relationship /двупосочна връзка/
-> трябва да следим от коя страна е OneToMany и от коя е ManyToOne
Пример: company<--> employees
**1** entity Company
@OneToMany (mappedBy = "company") // компанията е една, а служителите са много, company -> обекта, който се мапва
private List<Employee> employees;
**2** entity Employee
@ManyToOne //служителите са много, а компанията е една
private Company company;

## many-to-many relationship-> identifying
**video lecture week10->1:04h**
Идентифицираща е връзката, когато първичния ключ е стойност, която идва като външен ключ
Пример: events<--> employees
@ManyToMany