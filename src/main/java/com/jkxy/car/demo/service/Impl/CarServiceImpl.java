package com.jkxy.car.demo.service.Impl;

import com.jkxy.car.demo.dao.CarDao;
import com.jkxy.car.demo.pojo.Car;
import com.jkxy.car.demo.pojo.PageHelpParam;
import com.jkxy.car.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sun.misc.Version.println;


@Service("carService")


public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public void buyCar(Car car) {
        if (car.getPurchaseNum() <= car.getCarNum()) {
            carDao.buyCar(car);
        } else {
            System.out.println("购买数量超出库存");
        }
    }
    @Override
    public List<Car> findCar(String carName) {
        List<Car> rechargeRecordEntities = carDao.findCar(carName);
        System.out.println("------当前所有信息-------");
        for (Car rechargeRecordEntity : rechargeRecordEntities) {
            System.out.println("id：" + rechargeRecordEntity.getId() +
                    "\tNAME：" + rechargeRecordEntity.getCarName() +
                    "\tTYPE：" + rechargeRecordEntity.getCarType() +
                    "\tPRICE：" + rechargeRecordEntity.getPrice());
        }
        return carDao.findCar(carName);
    }

    @Override
    public Map findPageHelp(PageHelpParam pageHelpParam) {
      int currentPageParam = pageHelpParam.getCurrentPageParam();
       int pageSizeParam   =  pageHelpParam.getPageSizeParam();
       /* int currenPage = 1;
        int pageSize = 10;
        if(StringUtils.isEmpty(currentPageParam)){
            currenPage = 1;
        }else{
            currenPage = currentPageParam;
        }
        if(StringUtils.isEmpty(pageSizeParam)){
            pageSize = 10;
        }else{
            pageSize = pageSizeParam;

        }*/
        //分页条件查询参数
        PageHelper.startPage(currentPageParam,pageSizeParam);//页数和每页大小

    //*    获得要分页的集合*//*

        String fuzzy = pageHelpParam.getFuzzy();
        //String nextFuzzy = pageHelpParam.getNextFuzzy();
        //Map<String,Object>  mapParam = new HashMap<>();
       /* if(null != fuzzy && fuzzy  != ""){
            mapParam.put("fuzzy",fuzzy);
        }*/

        List<Car> goodsList = carDao.findCar(fuzzy);

        //startPage会返回page，PageInfo中使用page
        PageInfo<Car> pageInfo = new PageInfo<Car>(goodsList);

        List<Car> goods = new ArrayList<>();
        if(!CollectionUtils.isEmpty(goodsList)){
            for(Car good:pageInfo.getList()){
                goods.add(good);
            }
        }

        Map<String,Object>  map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
     /*   map.put("currentPage",pageInfo.getPageNum());
        map.put("pageSize", pageInfo.getPageSize());*/

        map.put("currentPage",pageHelpParam.getCurrentPageParam());
        map.put("pageSize", pageHelpParam.getPageSizeParam());

        Map<String ,Object> maps = new HashMap<>();
       maps.put("pageInfo",map);
        maps.put("goods",goods);
        return maps;
    }

}
