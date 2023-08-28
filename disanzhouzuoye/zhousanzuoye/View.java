package com.wnxy.disanzhouzuoye.zhousanzuoye;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.*;

public class View {
    Scanner scanner = new Scanner(System.in);
    CompanyDao companyDao = DaoFactory.creatCustomerDao();

    Map<String, String> menuMap = new HashMap<>();

    {
        menuMap.put("查询所有公司", "showAllCompany");
        menuMap.put("根据id查询公司", "selectCompanyById");
        menuMap.put("新增一家公司", "addCompany");
        menuMap.put("根据年份区间查询公司", "selectCompanyByYearRange");
        menuMap.put("删除一家公司", "deleteCompanyById");
        menuMap.put("按创立年份排序查询", "yearOfEstablishmentSortedQuery");
        menuMap.put("按公司老板对公司分组查询(报表A) ReportA", "reportA");
        menuMap.put("查询各年份创立的公司列表(报表B)", "reportB");
        menuMap.put("查询各年份创立的公司各有多少家(报表C)", "reportC");
        menuMap.put("最早的公司是在哪一年创建的？", "selectEarliestCreatedCompany");
    }

    public void run() {
        System.out.println("欢迎使用本系统！");
        while (true) {
            showMenu();
            System.out.println("是否要继续？y/n");
            String flag = scanner.next();
            if (!flag.equals("y")) {
                return;
            }
        }
    }

    @SneakyThrows
    public void showMenu() {
        String[] menus = new String[menuMap.size()];
        menuMap.keySet().toArray(menus);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        int index = scanner.nextInt() - 1;
        if (index > menus.length - 1) {
            System.out.println("输入错误");
            return;
        }

        String methodName = menuMap.get(menus[index]);
        System.out.println(methodName);
        Method method = View.class.getDeclaredMethod(methodName);
        method.invoke(this);
    }

    private void showAllCompany() {
        List<Company> customers = companyDao.showAllCompany();
        for (Company customer : customers) {
            System.out.println(customer);
        }
    }

    private void selectCompanyByYearRange() {
        List<Company> companies = companyDao.selectCompanyByYearRange(2000, 2017);
        Iterator<Company> iterator = companies.iterator();
        while (iterator.hasNext()) {
            Company company = iterator.next();
            System.out.println(company);
        }
    }

    private void selectCompanyById() {
        Optional<Company> company = companyDao.selectCompanyById(17);
        System.out.println(company);
    }
}
