package model;

import java.util.Objects;

public class Car {
    private String licenseNumber;
    private String colour;



    public Car(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getLicenseNumber(), car.getLicenseNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLicenseNumber());
    }
}
