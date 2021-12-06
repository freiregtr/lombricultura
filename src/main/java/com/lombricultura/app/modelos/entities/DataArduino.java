package com.lombricultura.app.modelos.entities;

import com.lombricultura.app.modelos.entities.enumerators.TypeSensor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_arduino")
public class DataArduino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_sensor")
    private TypeSensor typeSensor;

    @Column(nullable = false, length = 500)
    private String data;

    @Column(name = "init_date", nullable = false)
    private LocalDateTime initDate;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "data_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "DATA_SENSOR_ID")
    )
    private Sensor sensor;

    @PrePersist
    private void beforeInit(){
        this.initDate = LocalDateTime.now();
    }

    public DataArduino() {
    }

    public DataArduino(Integer id, TypeSensor typeSensor, String data, LocalDateTime initDate) {
        this.id = id;
        this.typeSensor = typeSensor;
        this.data = data;
        this.initDate = initDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeSensor getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(TypeSensor typeSensor) {
        this.typeSensor = typeSensor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDateTime initDate) {
        this.initDate = initDate;
    }

    @Override
    public String toString() {
        return "DataArduino{" +
                "id=" + id +
                ", typeSensor=" + typeSensor +
                ", data='" + data + '\'' +
                ", initDate=" + initDate +
                '}';
    }
}
