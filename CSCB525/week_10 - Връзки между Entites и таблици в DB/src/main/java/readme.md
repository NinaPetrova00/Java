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