package com.wnxy.new_crm_06.view;

import java.util.*;

public class MyView2 {
    Scanner scanner = new Scanner(System.in);
    Map<String, List<String>> menuMap;

    public MyView2() {
        initMenuMap();
    }

    private void initMenuMap() {
        menuMap = new HashMap<>();
        List<String> menus = new ArrayList<>();
        Collections.addAll(menus, "添加客户", "删除客户", "修改客户联系方式", "显示全部客户", "根据电话查询客户");
        menuMap.put("客户管理", menus);

        menus = new ArrayList<>();
        Collections.addAll(menus, "添加员工", "删除员工", "显示全部员工");
        menuMap.put("员工管理", menus);

        menus = new ArrayList<>();
        Collections.addAll(menus, "添加访谈记录", "查询个人访谈记录");
        menuMap.put("访谈记录管理", menus);
    }

    public void showMenu() {
        System.out.println("请选择你要使用的功能");
        String[] menus = new String[menuMap.size()];
        menuMap.keySet().toArray(menus);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s.%s\n", i + 1, menus[i]);
        }
        int index = scanner.nextInt();
        String menuName = menus[index];
        showChildMenu(menuName);
    }

    private void showChildMenu(String menuName) {
        List<String> childMenu = menuMap.get(menuName);
        for (int i = 0; i < childMenu.size(); i++) {
            System.out.printf("\t%s.%s\n", i + 1, childMenu.get(i));
        }

    }

    public void start() {
        System.out.println("--------欢迎使用CRM管理系统----------");
        while (true) {
            showMenu();
            System.out.println("需要继续吗（y/n）");
            String option = scanner.next();
            if (!option.equalsIgnoreCase("y")) {
                System.out.println("欢迎下次继续使用");
            }
        }
    }
}
