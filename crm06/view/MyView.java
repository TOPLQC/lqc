package com.wnxy.crm06.view;

import com.wnxy.crm06.ApplicationContext;
import com.wnxy.crm06.dao.CustomerDao;
import com.wnxy.crm06.dao.EmpDao;
import com.wnxy.crm06.dao.RecordDao;
import com.wnxy.crm06.dao.impl.CustomerImpl;
import com.wnxy.crm06.dao.impl.EmpDaoImpl;
import com.wnxy.crm06.dao.impl.RecordDaoImpl;
import com.wnxy.crm06.entity.Customer;
import com.wnxy.crm06.entity.Employee;
import com.wnxy.crm06.entity.Record;
import com.wnxy.crm06.exception.DataRepeatException;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyView {
    EmpDao empDao = new EmpDaoImpl();
    CustomerDao customerDao = new CustomerImpl();
    RecordDao recordDao = new RecordDaoImpl();

    Scanner scanner = new Scanner(System.in);
    Map<String, List<String>> menuMap;
    Map<String, String> menuMethodMap;

    public MyView() {
        initMenuMap(); //初始化
        initMenuMethodMap();

    }

    private void initMenuMethodMap() {
        menuMethodMap = new HashMap<>();
        menuMethodMap.put("显示全部客户", "showAllCustomers");
        menuMethodMap.put("添加客户", "addCustomer");
        menuMethodMap.put("删除客户", "removeCustomer");
        menuMethodMap.put("修改客户联系方式", "updateCustomerMobile");
        menuMethodMap.put("根据电话查询客户", "showCustomersByMobile");
        menuMethodMap.put("添加员工", "addEmployee");
        menuMethodMap.put("删除员工", "removeEmployeeById");
        menuMethodMap.put("添加访谈记录", "addRecord");
        menuMethodMap.put("查询个人访谈记录", "showMyRecord");

    }

    private void addRecord() {
        Record recordInfo = getRecordInfo();
        recordDao.addRecord(recordInfo);
    }

    private Record getRecordInfo() {
        Record record = new Record();
        System.out.println("请输入客户id");
        record.setCustomerId(scanner.nextInt());
        System.out.println("请输入类型");
        record.setRtype(scanner.next());
        System.out.println("请输交易意向");
        record.setRemark(scanner.next());
        return record;
    }

    private void showMyRecord() {
        List<Record> myRecord = recordDao.getMyRecord();
        myRecord.forEach(System.out::println);
    }

    private Employee getEmployeeInfo() {
        Employee employee = new Employee();
        System.out.println("请输入员工的账户");
        employee.setAccount(scanner.next());
        System.out.println("请输入员工的密码");
        employee.setPassword(scanner.next());
        System.out.println("请输入员工的姓名");
        employee.setEname(scanner.next());
        return employee;
    }

    private void addEmployee() {
        Employee employee = getEmployeeInfo();
        empDao.addEmp(employee);
        showAllEmployee();
    }

    private void removeEmployeeById() {
        System.out.println("请输入要删除的id");
        empDao.deleteEmp(scanner.nextInt());
        showAllEmployee();
    }

    private void showAllEmployee() {
        List<Employee> employees = empDao.selectAllEmp();
        employees.forEach(System.out::println);
    }

    private void showAllCustomers() {
        List<Customer> customers = customerDao.selectAll();
        customers.forEach(System.out::println);
    }

    ;

    private void removeCustomer() {
        System.out.println("请正确的输入需要删除的客户id");
        customerDao.deleteById(scanner.nextInt());
        System.out.println("删除成功！！！！！！！！！！");
        showAllCustomers();
    }

    private void addCustomer() {
        Customer customer = getCustomerInfo();
        customerDao.insert(customer);
        System.out.println("客户添加成功");
        showAllCustomers();
    }

    private Customer getCustomerInfo() {
        Customer customer = new Customer();
        System.out.println("请输入新客户姓名");
        customer.setCname(scanner.next());
        System.out.println("请输入新客户的联系方式");
        customer.setMobile(scanner.next());
        System.out.println("请输入新客户年龄");
        customer.setAge(scanner.nextInt());
        System.out.println("请输入新客户性别（1.男；0.女）");
        customer.setGender(scanner.next().equals("1"));
        System.out.println("请输入新客户学历");
        customer.setEducation(scanner.next());

        return customer;
    }

    private void updateCustomerMobile() {
        System.out.println("请输入要修改的id");
        int id = scanner.nextInt();
        System.out.println("请输入新的号码");
        String mobile = scanner.next();
        customerDao.updateMobile(id, mobile);
        System.out.println("修改成功！！！！！！！");
        showAllCustomers();
    }

    private void showCustomersByMobile() {
        System.out.println("请输入用户的手机号");
        String mobile = scanner.next();
        Customer customer = customerDao.selectByMobile(mobile);
        System.out.println(customer);
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
        int index = scanner.nextInt() - 1;
        String menuName = menus[index];//用户选择的一级菜单名称
        showChildMenu(menuName); //显示二级菜单

    }

    private void showChildMenu(String menuName) {
        List<String> childMenu = menuMap.get(menuName);
        for (int i = 0; i < childMenu.size(); i++) {
            System.out.printf("\t%s.%s\n", i + 1, childMenu.get(i));
        }
        int index = scanner.nextInt() - 1;
        String childMenuName = childMenu.get(index);//二级菜单名
        try {
            callMethod(childMenuName); // 调用方法
        } catch (DataRepeatException e) {
            System.out.println("出现了业务异常，原因是：" + e.getMessage());
        }
    }

    @SneakyThrows
    private void callMethod(String childMenuName) {
        //使用反射动态调用方法
        //1、通过目标方法所在类的字节码，既当前类的字节码
        //2、用过字节码+方法名+参数类型字节--->目标方法对象Method
        String methodName = menuMethodMap.get(childMenuName);

        //3、通过Method（我们所要调用的方法都是实例方法，调用时需要MyView的对象）
        //this是执行当前方法的callMethod的对象，当前对象，也是MyView类型的对象
        Method method = MyView.class.getDeclaredMethod(methodName);
        try {
            method.invoke(this);//如果目标方法中有参数，那我们还必须在this后面填写实际参数
        } catch (InvocationTargetException ex) {
            Throwable throwable = ex.getTargetException();
            if (throwable instanceof DataRepeatException) {
                throw (DataRepeatException) ex.getTargetException();
            }
        }
        //如果出现其他类型的异常，与业务无关，我们不处理
    }

    public void start() {
        if (!login()) {
            System.out.println("账户名或者密码错误!");
            return;
        }
        System.out.println("--------欢迎使用CRM管理系统----------");
        while (true) {
            showMenu();
            System.out.println("需要继续吗（y/n）");
            String option = scanner.next();
            if (!option.equalsIgnoreCase("y")) {
                System.out.println("欢迎下次继续使用");
                break;
            }
        }
    }

    public Boolean login() {
        System.out.println("请输入账户：");
        String account = "ww"; //scanner.next();
        System.out.println("请输入密码：");
        String password = "123456"; //scanner.next();

        Employee employee = empDao.selectByAccount(account);
        if (employee != null && employee.getPassword().equalsIgnoreCase(password)) {
            ApplicationContext.CURRENT_EMP = employee;
            return true;
        }
        return false;
    }
}
