package com.jkxy.car.demo.dao;

import com.jkxy.car.demo.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CarDao {
    @Select("select * from carmessage")
    List<Car> findAll();

    @Select("select * from carmessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carmessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carmessage where id = #{id}")
    void deleteById(int id);

    @Update("update carmessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries},carNum=#{carNum},purchaseNum=#{purchaseNum} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carmessage(carName,carType,price,carSeries.carNum,purchaseNum) values(#{carName},#{carType},#{price},#{carSeries},#{carNum},#{purchaseNum})")
    void insertCar(Car car);

    //买车 更新数量
    @Update("update carmessage set carNum=#{carNum}-#{purchaseNum},purchaseNum=#{purchaseNum} where id = #{id}")
    void buyCar(Car car);

    //模糊查询 含分页
    @Select("select * from carmessage where carName like \"%\"#{fuzzy}\"%\" ")
    List<Car> findAllByCarName( HashMap mapParam);

    //模糊查询
    @Select("select * from carmessage where carName like \"%\"#{carName}\"%\" ")
    List<Car> findCar(String carName);
}
