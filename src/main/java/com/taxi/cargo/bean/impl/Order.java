package com.taxi.cargo.bean.impl;

import com.taxi.cargo.bean.Entity;

import java.util.Objects;

public class Order extends Entity {

    private long id;
    private String tripType;
    private String carType;
    private int loaderQuantity;
    private double hourQuantity;
    private double kmQuantity;
    private String mobilePhone;
    private String email = "-";
    private String loadingPoint = "-";
    private String unloadingPoint = "-";
    private String logistcianInfo;
    private String driverInfo;
    private boolean isCompleted = false;
    private String date;

    public Order() {
        long currentId = getId();
        setId(++currentId);
    }

    public Order(long id, String tripType, String carType, int loaderQuantity, double hourQuantity,
                 double kmQuantity, String mobilePhone, String email, String loadingPoint,
                 String unloadingPoint, String logistcianInfo, String driverInfo, String date,
                 boolean isCompleted) {
        this.id = id;
        this.tripType = tripType;
        this.carType = carType;
        this.loaderQuantity = loaderQuantity;
        this.hourQuantity = hourQuantity;
        this.kmQuantity = kmQuantity;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.logistcianInfo = logistcianInfo;
        this.driverInfo = driverInfo;
        this.isCompleted = isCompleted;
        this.date = date;
    }

    public Order(String tripType, String carType, int loaderQuantity, double hourQuantity,
                 double kmQuantity, String mobilePhone) {
        long currentId = getOrderId();
        setOrderId(++currentId);

        this.tripType = tripType;
        this.carType = carType;
        this.loaderQuantity = loaderQuantity;
        this.hourQuantity = hourQuantity;
        this.kmQuantity = kmQuantity;
        this.mobilePhone = mobilePhone;
    }

    public long getOrderId() {
        return id;
    }

    public void setOrderId(long id) { this.id = id; }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) { this.tripType = tripType; }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getLoaderQuantity() {
        return loaderQuantity;
    }

    public void setLoaderQuantity(int loaderQuantity) {
        this.loaderQuantity = loaderQuantity;
    }

    public double getHourQuantity() {
        return hourQuantity;
    }

    public void setHourQuantity(double hourQuantity) {
        this.hourQuantity = hourQuantity;
    }

    public double getKmQuantity() {
        return kmQuantity;
    }

    public void setKmQuantity(double kmQuantity) {
        this.kmQuantity = kmQuantity;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getLogistcianInfo() {
        return logistcianInfo;
    }

    public void setLogistcianInfo(String logistcianInfo) {
        this.logistcianInfo = logistcianInfo;
    }

    public String getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(String driverInfo) {
        this.driverInfo = driverInfo;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && getLoaderQuantity() == order.getLoaderQuantity() && Double.compare(order.getHourQuantity(), getHourQuantity()) == 0 && Double.compare(order.getKmQuantity(), getKmQuantity()) == 0 && isCompleted() == order.isCompleted() && getTripType().equals(order.getTripType()) && getCarType().equals(order.getCarType()) && getMobilePhone().equals(order.getMobilePhone()) && Objects.equals(getEmail(), order.getEmail()) && Objects.equals(getLoadingPoint(), order.getLoadingPoint()) && Objects.equals(getUnloadingPoint(), order.getUnloadingPoint()) && Objects.equals(getLogistcianInfo(), order.getLogistcianInfo()) && Objects.equals(getDriverInfo(), order.getDriverInfo()) && getDate().equals(order.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getTripType(), getCarType(), getLoaderQuantity(), getHourQuantity(), getKmQuantity(), getMobilePhone(), getEmail(), getLoadingPoint(), getUnloadingPoint(), getLogistcianInfo(), getDriverInfo(), isCompleted(), getDate());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tripType='" + tripType + '\'' +
                ", carType='" + carType + '\'' +
                ", loaderQuantity=" + loaderQuantity +
                ", hourQuantity=" + hourQuantity +
                ", kmQuantity=" + kmQuantity +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", loadingPoint='" + loadingPoint + '\'' +
                ", unloadingPoint='" + unloadingPoint + '\'' +
                ", logistcianInfo='" + logistcianInfo + '\'' +
                ", driverInfo='" + driverInfo + '\'' +
                ", isCompleted=" + isCompleted +
                ", date='" + date + '\'' +
                '}';
    }
}
