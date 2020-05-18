package com.jkxy.car.demo.service;

import com.jkxy.car.demo.pojo.Car;
import com.jkxy.car.demo.pojo.PageHelpParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CarService {
    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String fuzzy);

    List<Car> findCar(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    void buyCar(Car car);

    public Map findPageHelp(PageHelpParam pageHelpParam);
}
