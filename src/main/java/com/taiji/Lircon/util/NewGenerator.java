package com.taiji.Lircon.util;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;


public class NewGenerator {

    public void NewGen(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/space-time?serverTimezone=GMT%2B8", "root", "root");
    }
}
