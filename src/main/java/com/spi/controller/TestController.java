package com.spi.controller;

import com.spi.dto.User;
import com.spi.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j // 自动生成 log 字段，用于记录接口调用及线程执行信息。
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test01")
    public Object test01(){
        log.info("hello");
        log.info("线程：{}正在运行。。。", Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            log.info("线程：{}正在运行。。。", Thread.currentThread().getName());
        });
        thread.start();
        testService.testMethod();
        testService.testMethod1();
        log.info("线程：{}正在运行。。。", Thread.currentThread().getName());
        
        return "hello";
    }


    public static void main(String[] args) {
//        ArrayList<String> objects = new ArrayList<>();
//        System.out.println(objects.size());

//        List<String> names = new ArrayList<>(
//                Arrays.asList("华泰证券11", "中信", "国泰君安"));
//        //匿名内部类写法
//        names.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
//        //lambda写法
//        names.sort((left, right) -> Integer.compare(left.length(), right.length()));
//        //
//        names.sort(Comparator.comparingInt(String::length));
//        System.out.println(names);
        //// 输入：若干机构名称；输出：长度至少为二的非空名称，去空格、去重后排序。
//        List<String> result = Arrays.asList(" 中信 ", null, "华泰", "中信", "A");
//        List<String> collect = result.stream().filter(Objects::nonNull)
//                .map(String::trim)
//                .filter(s -> s.length() >= 2)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(collect);
        User user1 = new User("1","小明",21);
        User user2 = new User("2","小红",22);
        User user3 = new User("1","小芳",23);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //将对象集合中某个字段作为key，对象本身作为value转为map类型操作
        //默认作为key的字段不会重复，若出现重复则该种写法会报错，如果重复需要另一种写法
//        Map<String, User> collect = list.stream().collect(Collectors.toMap(User::getId, u -> u));
//        System.out.println(collect);
//        //默认作为key字段可能出现重复时写法
//        //first表示key重复时出现的第一个元素，later表示key重复时出现的第二个元素
//        //(first, later) -> first 表示若key出现重复时取出现的第一个元素
//        Map<String, User> collect1 = list.stream().collect(Collectors.toMap(
//                User::getId,
//                u -> u,
//                (first, later) -> first
//        ));
//        System.out.println(collect1);
//        Map<String, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getId));
//        System.out.println(collect);
        // 外层列表包含两个部门；每个部门对应一份员工名单。
        List<List<String>> departments = Arrays.asList(
                Arrays.asList("张三", "李四"),
                Arrays.asList("王五")
        );
        Stream<Stream<String>> streamStream = departments.stream().map(g -> g.stream());
        System.out.println(streamStream);
        List<String> collect = departments.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("第一次提交");


        System.out.println("第四次提交");
    }


}
