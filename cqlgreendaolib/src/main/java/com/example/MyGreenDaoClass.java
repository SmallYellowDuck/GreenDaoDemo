package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyGreenDaoClass {
    public static void main(String[] args) throws Exception {
        //1、   参数： 1表示数据库版本号  "com.cql.greendao"表示自动生成代码的路径
        Schema schema = new Schema(1,"com.cql.greendao");
        //2、   创建了schema后，就可以用这个schema对象操作数据库了
        //这里我们写了个方法
        mydatabase(schema);
        //3、    使用 DAOGenerator 类的 generateAll() 方法自动生成代码
        //我们将代码自动生成到我们之前建立的android的java-gen目录下，这个路径不是固定的，可以自由设置
        new DaoGenerator().generateAll(schema,"E:/demo/GreenDaoDemo/app/src/main/java-gen");
    }
    private static void mydatabase(Schema schema){
        //1、  创建一个实体类，一个实体类就是数据库的一张表 这里表名为mydata，数据库的名字会在android工程中指定
        Entity mydata = schema.addEntity("MyData");

        //2、  设置实体类的属性，每个属性就是表中的一个字段
        mydata.addIdProperty();   //首先设置一个Id
        mydata.addStringProperty("name");  //设置一个name字段
        mydata.addStringProperty("age");   //设置一个age字段
        mydata.addStringProperty("cool").notNull();//设置一个cool字段，并且不能为空
    }
}
