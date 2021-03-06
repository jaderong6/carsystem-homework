package com.jkxy.car.demo.controller;


import com.jkxy.car.demo.pojo.Car;
import com.jkxy.car.demo.pojo.PageHelpParam;
import com.jkxy.car.demo.service.CarService;
import com.jkxy.car.demo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }


    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

    /**
     * 通过id买车
     *
     * @param car
     * @return
     */
    @PostMapping("buyCar")
    public JSONResult buyCar(Car car) {
        carService.buyCar(car);
        return JSONResult.ok();
    }

    @PostMapping("findCar")
    public JSONResult Car(String carName) {
        List<Car> cars = carService.findCar(carName);
        return JSONResult.ok(cars);
    }


    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */

    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }


    /**
     * 作业2 车名模糊查询
     */
    @GetMapping("findByCarName")
    public Map findGoodsPageHelper(PageHelpParam pageHelpParam) {

        Map<String, Object> map = carService.findPageHelp(pageHelpParam);

        return map;
    }
}
