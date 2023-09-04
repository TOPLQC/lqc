package com.wnxy.crm06.view;

import java.util.*;

public class MyView {
    Scanner scanner = new Scanner(System.in);
    Map<String, List<String>> menuMap;

    public MyView() {
        initMenuMap(); //初始化
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
        while (true) {
            System.out.println("请选择你要使用的功能");
            String[] menus = new String[menuMap.size()];
            menuMap.keySet().toArray(menus);
            for (int i = 0; i < menus.length; i++) {
                System.out.printf("%s.%s\n", i + 1, menus[i]);
            }
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < menus.length) {
                String menuName = menus[index];//用户选择的一级菜单名称
                showChildMenu(menuName); //显示二级菜单
                System.out.println("返回上级菜单？（y/n）");
                String backOption = scanner.next();
                if (!backOption.equalsIgnoreCase("y")) {
                    break; // 退出菜单循环，返回上级菜单
                }
            } else {
                System.out.println("无效的选择，请重新选择");
            }
        }
    }

    private void showChildMenu(String menuName) {
        List<String> childMenu = menuMap.get(menuName);
        while (true) {
            System.out.println("请选择" + menuName + "的功能：");
            for (int i = 0; i < childMenu.size(); i++) {
                System.out.printf("%s.%s\n", i + 1, childMenu.get(i));
            }
            int childIndex = scanner.nextInt() - 1;
            if (childIndex >= 0 && childIndex < childMenu.size()) {
                String childMenuItem = childMenu.get(childIndex);
                // 在这里执行选中的子菜单项的功能
                System.out.println("执行" + childMenuItem + "的功能");
            } else {
                System.out.println("无效的选择，请重新选择");
            }

            System.out.println("返回上级菜单？（y/n）");
            String backOption = scanner.next();
            if (!backOption.equalsIgnoreCase("y")) {
                break; // 退出子菜单循环，返回上级菜单
            }
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
