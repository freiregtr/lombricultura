package com.lombricultura.app.modelos.entities;

import com.lombricultura.app.modelos.entities.enumerators.TypeSensor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "sensors")
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    private TypeSensor typeSensor;

    @Column(nullable = true, length = 200)
    private String description;

    @Column(name = "init_date")
    private LocalDateTime initDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "bed_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "SENSOR_BED_ID")
    )
    private Bed bed;

    @OneToMany(
            mappedBy = "sensor",
            fetch = FetchType.LAZY
    )
    private Set<DataArduino> data;

    @PrePersist
    private void beforePersist(){
        this.initDate = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        this.updateDate = LocalDateTime.now();
    }

    public Sensor() {
    }

    public Sensor(Integer id, String name, TypeSensor typeSensor, String description, LocalDateTime initDate, LocalDateTime updateDate, Bed bed) {
        this.id = id;
        this.name = name;
        this.typeSensor = typeSensor;
        this.description = description;
        this.initDate = initDate;
        this.updateDate = updateDate;
        this.bed = bed;
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

    public TypeSensor getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(TypeSensor typeSensor) {
        this.typeSensor = typeSensor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDateTime initDate) {
        this.initDate = initDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeSensor=" + typeSensor +
                ", description='" + description + '\'' +
                ", initDate=" + initDate +
                ", updateDate=" + updateDate +
                ", bed=" + bed +
                '}';
    }
}
