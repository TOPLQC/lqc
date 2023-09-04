package com.wnxy.crm06.view;

import java.util.*;

public class MyView {
    Map<String, List<String>> menuMap;

    public MyView() {
        initMenuMap(); //初始化
    }

    private void initMenuMap() {
        menuMap = new HashMap<>();
        List<String> menus = new ArrayList<>();
        Collections.addAll(menus, "添加客户", "删除客户", "修改客户联系方式", "显示全部客户", "根据电话查询客户");
        menuMap.put("客户管理", menus);

        menus.clear();
        Collections.addAll(menus, "添加员工", "删除员工", "显示全部员工");
        menuMap.put("员工管理", menus);

        menus.clear();
        Collections.addAll(menus, "添加访谈记录", "查询个人访谈记录");
        menuMap.put("访谈记录管理", menus);
    }
}
