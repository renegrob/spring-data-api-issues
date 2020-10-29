package org.acme.resteasy.entities;

import javax.persistence.*;

@Entity
@Table(name = "CLASSIC_CARS")
public class ClassicCarEntity {

    @Id
    @Column(name = "CLASSIC_CAR_ID", length = 26)
    private String id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private CarBrandEnity carBrand;

    @Column(name = "NAME", nullable = false, length = 256)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarBrandEnity getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrandEnity carBrand) {
        this.carBrand = carBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
