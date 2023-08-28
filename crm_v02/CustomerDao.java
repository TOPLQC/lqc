package com.wnxy.crm_v02;

public class CustomerDao {
    private Customer[] customers;

    {
        //这就是实例代码块 ，我们就在此初始化客户信息
        //int[] numbers = new int[]{3, 4, 5};
        //String name, boolean sex, String phone, String province
        customers = new Customer[]{
                new Customer("王婧", false, "1301234567", "广东"),
                new Customer("张三", true, "1311234567", "广东"),
                new Customer("李四", true, "1381234567", "山西"),
                new Customer("任我行", true, "1381234569", "陕西"),
                new Customer("王母娘娘", false, "1391234568", "福建"),
                new Customer("玉皇大帝", true, "1311234566", "福建"),
                new Customer("孙悟空", true, "13033339999", "海南")
        };

    }

    public boolean deleteCustomerByIndex(int index) {
        if (index < 0 || index >= customers.length) {
            return false;
        }
        int newArrayIndex = 0;
        Customer[] tempArray = new Customer[customers.length - 1];
        for (int i = 0; i < customers.length; i++) {
            if (i != index) {
                tempArray[newArrayIndex] = customers[i];
                newArrayIndex++;
            }
        }
        customers = tempArray;
        return true;
    }


    public void addCustomer(Customer customer) {
        Customer[] tempArray = new Customer[customers.length + 1];
        System.arraycopy(customers, 0, tempArray, 0, customers.length);
        tempArray[tempArray.length - 1] = customer;
        customers = tempArray;
    }


    public Customer selectCustomerByPhone(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    public Customer[] getCustomerByFirstName(String firstName) {
        Customer[] tempArray = new Customer[customers.length];
        int count = 0;
        for (Customer customer : customers) {
            if (customer.getName().startsWith(firstName)) {
                tempArray[count] = customer;
                count++;
            }
        }

        Customer[] resultArray = new Customer[count];
        for (int i = 0; i < count; i++) {
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }

    public Customer[] getCustomers() {
        return customers;
    }
}
