package com.lombricultura.app.modelos.entities;

import org.springframework.expression.spel.ast.NullLiteral;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 25)
    private String name;

    @Column(nullable = true, length = 50)
    private String address;

    @Column(name = "postal_code", nullable = true, length = 20)
    private String postalCode;

    @Column(name = "cant_employees", nullable = true, length = 3)
    private Integer cantEmployees;

    @Column(name = "cant_beds", nullable = true, length = 3)
    private Integer cantBeds;

    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "city_id",
            foreignKey = @ForeignKey(name = "CITY_EMPLOYEE_FK")
    )
    private City city;


    @OneToMany(
            mappedBy = "company",
            fetch = FetchType.LAZY
    )
    private Set<Bed> beds;

    public Company() {
    }

    public Company(Integer id, String name, String address, String postalCode, Integer cantEmployees, Integer cantBeds, City city, Set<Bed> beds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.cantEmployees = cantEmployees;
        this.cantBeds = cantBeds;
        this.city = city;
        this.beds = beds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getCantEmployees() {
        return cantEmployees;
    }

    public void setCantEmployees(Integer cantEmployees) {
        this.cantEmployees = cantEmployees;
    }

    public Integer getCantBeds() {
        return cantBeds;
    }

    public void setCantBeds(Integer cantBeds) {
        this.cantBeds = cantBeds;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
                " \t Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", cantEmployees=" + cantEmployees +
                ", cantBeds=" + cantBeds +
                ", city=" + city +
                ", beds=" + beds +
                '}';
    }
}
