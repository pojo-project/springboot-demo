package com.offcn.demo.JSONController;

import com.offcn.demo.pojo.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//返回JSON对象
@RestController
public class CartController {
    @RequestMapping("/getCar1")
    public Car getCar() {
        Car car = new Car();
        car.setCreateDate(new Date());
        car.setId(1);
        /* car.setIsNull("不是空");*/
        car.setMemo("Asd");
        return car;
    }

    @RequestMapping("/getCar2")
    public List<Car> getCar2() {
        List<Car> carlist = new ArrayList<>();
        Car car = new Car();
        car.setCreateDate(new Date());
        car.setId(1);
        car.setIsNull("不是空");
        car.setMemo("Asd");
        carlist.add(car);
        carlist.add(car);
        return carlist;
    }

    //    参数的传递
//    第一类：请求路径传参
/*
@RequestParam  获取地址的指定参数的值，也叫查询指定参数的值 必须是url?name=value 指定变量接收，也可以不写@RequestParam，只要传递的参数名相同即可

@PathVariable  获取路径参数 获取的url格式url/{参数的名的value},获取@PathVariable（name="{}中的名字"） 变量接收 变量名不用相同 ，传递的时候需要在路径指明，而且


* */
//    http://localhost:8080/getCar3/admin?id=15
    @RequestMapping("/getCar3/{name}")//未指定请求方式就是get
    public String getCar3(@RequestParam(name = "id") Integer id, @PathVariable(name = "name") String name1) {

        String IPPath = "id 是" + id + "name是：" + name1;

        return IPPath;
    }
    @RequestMapping("/getCar5")
    public Car getCarById(@RequestBody Car car){//传递一个JSON格式的对象
//        {"id":4,"name":"兰博基尼","price":99,"createDate":"2020-12-12 9:8:50","memo":"传递","isnull":"不为空"}
        return car;
    }

    @RequestMapping("/getCar6")
    public Car getCar6(Car car){//传递一个对象作为参数

        return car;
    }
 /*   1：String +ResponseBody = 返回值为String
    2：对象+ResponseBody = json对象
*/
}
