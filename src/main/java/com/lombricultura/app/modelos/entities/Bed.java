package com.lombricultura.app.modelos.entities;

import com.lombricultura.app.modelos.entities.Company;
import com.lombricultura.app.modelos.entities.Employee;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @Column(name = "cant_sensors", nullable = true, length = 3)
    private Integer cantSensors;

    @Column(nullable = true, length = 50)
    private String description;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "ID_BED_EMPLOYEE_FK")
    )
    private Employee employee;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "ID_BED_COMPANY_FK")
    )
    private Company company;

    @OneToMany(
            mappedBy = "bed",
            fetch = FetchType.LAZY
    )
    private Set<Sensor> sensors;


    public Bed() {
    }

    public Bed(Integer id, String name, Integer cantSensors, String description, Employee employee, Company company, Set<Sensor> sensors) {
        this.id = id;
        this.name = name;
        this.cantSensors = cantSensors;
        this.description = description;
        this.employee = employee;
        this.company = company;
        this.sensors = sensors;
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

    public Integer getCantSensors() {
        return cantSensors;
    }

    public void setCantSensors(Integer cantSensors) {
        this.cantSensors = cantSensors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cantSensors=" + cantSensors +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                ", company=" + company +
                ", sensors=" + sensors +
                '}';
    }
}
