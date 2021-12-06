package com.lombricultura.app.modelos.entities;

import com.lombricultura.app.modelos.entities.enumerators.Rol;
import com.lombricultura.app.modelos.entities.enumerators.Sex;
import com.lombricultura.app.modelos.entities.enumerators.TypeEmployee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person{

     private BigDecimal salary;

     @Enumerated(EnumType.STRING)
     private TypeEmployee typeEmployee;

     @Enumerated(EnumType.STRING)
     private Sex sex;

     @Enumerated(EnumType.STRING)
     private Rol rol;

     @Column(name = "admission_date", nullable = false)
     private LocalDateTime admissiondate;

     @Column(name = "dismissal_date")
     private LocalDateTime dismissalDate;

     @OneToOne(
             optional = true,
             cascade = CascadeType.ALL
     )
     @JoinColumn(
             name = "person_id",
             foreignKey = @ForeignKey(name = "PERSON_ID_FK")
     )
     private Person person;

     @OneToOne(
             cascade = CascadeType.ALL
     )
     @JoinColumn(
             name = "user_id",
             foreignKey = @ForeignKey(name = "USER_ID_FK")
     )
     private User user;

     @OneToMany(
             mappedBy = "employee",
             fetch = FetchType.LAZY
     )
     private Set<Bed> beds;

     public Employee() {
     }

     public Employee(Integer id, String firtName, String lastName, String rut, String address, Boolean isActive, LocalDateTime admissiondate, LocalDateTime dismissalDate, LocalDateTime updateDate, BigDecimal salary, TypeEmployee typeEmployee, Sex sex, Rol rol, LocalDateTime admissiondate1, LocalDateTime dismissalDate1, Person person, User user, Set<Bed> beds) {
          super(id, firtName, lastName, rut, address, isActive, admissiondate, dismissalDate, updateDate);
          this.salary = salary;
          this.typeEmployee = typeEmployee;
          this.sex = sex;
          this.rol = rol;
          this.admissiondate = admissiondate1;
          this.dismissalDate = dismissalDate1;
          this.person = person;
          this.user = user;
          this.beds = beds;
     }

     public BigDecimal getSalary() {
          return salary;
     }

     public void setSalary(BigDecimal salary) {
          this.salary = salary;
     }

     public TypeEmployee getTypeEmployee() {
          return typeEmployee;
     }

     public void setTypeEmployee(TypeEmployee typeEmployee) {
          this.typeEmployee = typeEmployee;
     }

     public Sex getSex() {
          return sex;
     }

     public void setSex(Sex sex) {
          this.sex = sex;
     }

     public Rol getRol() {
          return rol;
     }

     public void setRol(Rol rol) {
          this.rol = rol;
     }

     public LocalDateTime getAdmissiondate() {
          return admissiondate;
     }

     public void setAdmissiondate(LocalDateTime admissiondate) {
          this.admissiondate = admissiondate;
     }

     public LocalDateTime getDismissalDate() {
          return dismissalDate;
     }

     public void setDismissalDate(LocalDateTime dismissalDate) {
          this.dismissalDate = dismissalDate;
     }

     public Person getPerson() {
          return person;
     }

     public void setPerson(Person person) {
          this.person = person;
     }

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     public Set<Bed> getBeds() {
          return beds;
     }

     public void setBeds(Set<Bed> beds) {
          this.beds = beds;
     }

     @Override
     public String toString() {
          return super.toString() +
                  " \t Employee{" +
                  "salary=" + salary +
                  ", typeEmployee=" + typeEmployee +
                  ", sex=" + sex +
                  ", rol=" + rol +
                  ", admissiondate=" + admissiondate +
                  ", dismissalDate=" + dismissalDate +
                  ", person=" + person +
                  ", user=" + user +
                  ", beds=" + beds +
                  '}';
     }
}
