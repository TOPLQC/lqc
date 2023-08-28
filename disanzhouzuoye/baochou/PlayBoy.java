package com.wnxy.disanzhouzuoye.baochou;

import java.util.ArrayList;

public class PlayBoy {
    public static void main(String[] args) {
        System.out.println("出去玩，被人揍了，找管家召集人手报仇");
        Manger manger = new Manger();
        //此时playboy和shitai类就解耦合，我完全不用知道你是谁，只需要知道killer类
        //虽然杀手的真实身份被掩盖，但是只要调用kill方法，最终实现的一定是真实身份的实现逻辑
        ArrayList<Killer> list = manger.zhaoRen();
        for (Killer killer : list) {
            killer.kill();
        }

//        System.out.println("出去玩，被人揍了，找管家召集人手报仇");
//        Manger manger = new Manger();
//        ArrayList list = manger.zhaoRen();
//        for (Object item : list) {
//            //现在这个item就是我们找的丐帮和师太。困难，怎么调用？
//            //我们的item当前身份是object，object类中是不存在liangjian的，所以点不出
//            if (item instanceof ShiTai){//判断当前item类型是否是ShiTai
//                ShiTai shiTai = (ShiTai) item;
//                shiTai.liangjian();
//            }
//            if (item instanceof  GaiBang){
//                GaiBang gaiBang = (GaiBang) item;
//                gaiBang.hand18();
//            }
//        }
    }
}
