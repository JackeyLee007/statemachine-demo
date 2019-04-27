package com.roc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roc.entity.Address;
import com.roc.entity.UserDTO;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;


public class RocTest {
    private static class PrintTask implements Runnable{
        int id;


        public PrintTask(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println("Hello " + this.id);
        }
    }


    @Test
    public void delayedQueueTest() throws InterruptedException {
        ScheduledExecutorService se = new ScheduledThreadPoolExecutor(4);

    }

    @Test
    public void q2Test() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        for (int i = 0; i < 5; i ++){
            final int temp = i + 1;
            pool.schedule(new PrintTask(i), temp * 5, TimeUnit.SECONDS);
        }
        System.out.println("end main时间:" + simpleDateFormat.format(new Date()));

        pool.awaitTermination(5, TimeUnit.SECONDS);

        // 等待本线程结束。否则不等上述Task结束线程池就会结束
//        Thread.currentThread().join();
        pool.shutdown();


    }

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        for (int i = 0; i < 5; i ++){
            final int temp = i + 1;
            pool.schedule(new PrintTask(i), temp * 5, TimeUnit.SECONDS);
        }
        pool.shutdown();
//        pool.awaitTermination(3, TimeUnit.SECONDS);
        if(pool.isTerminated()){
        System.out.println("end main时间:" + simpleDateFormat.format(new Date()));}

    }


    @Test
    public void pageTest() throws JsonProcessingException {
        List<UserDTO> users = new ArrayList<UserDTO>(23);
        for(int i=0;i<5; i++) {
            UserDTO user = new UserDTO();
            user.setId(i);
            user.setName("a");
            users.add(user);
        }
        Page<UserDTO> userPage = new Page<UserDTO>();

        userPage.setRecords(users);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPage);
        System.out.println(json);
    }

    @Test
    public void jacksonTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDTO> users = new ArrayList<UserDTO>(23);
        for(int i=0;i<5; i++) {
            UserDTO user = new UserDTO();
            user.setId(i);
            user.setName("a" + i);

            Address address = new Address();
            address.setId(i);
            address.setCity("b" + i);

            user.setAddress(address);

            users.add(user);
        }
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        System.out.println(json);
        List<UserDTO> u2 = mapper.readValue(json, List.class);
        System.out.println(u2.toString());
    }

    @Test
    public void resJsonTest() throws IOException {
        File resFile =  ResourceUtils.getFile("classpath:some.json");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> titles = mapper.readValue(resFile, Map.class);

        System.out.println(titles);
    }

    @Test
    public void spliTest(){
        String str = "qu|ting";
        String[] result = str.split("\\|");
        System.out.println(result);
    }
}
