package com.wnxy.disanzhouzuoye.zhousanzuoye.dao.impl;

import com.wnxy.disanzhouzuoye.zhousanzuoye.dao.CompanyDao;
import com.wnxy.disanzhouzuoye.zhousanzuoye.entity.Company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class CompanyFileDaoImpl implements CompanyDao {
    private final String path = "C:\\ziyuan\\resource\\crm_v05\\customers.txt";
    List<Company> companys = showAllCompany();


    private void saveCustomers2File() {
        //同步文件
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Company company : companys) {
                writer.write(company.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> showAllCompany() {
        System.out.println("开始读文件");
        List<Company> companyList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //需要将lien转换为Customer对象
                Company company = new Company(line);
                companyList.add(company);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }

    @Override
    public Optional<Company> selectCompanyById(String id) {
        Optional<Company> optional = companys.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst();
        if (optional.isPresent()) {
            return Optional.of(optional.get());
        }
        return null;
    }

    @Override
    public boolean addCompany(Company company) {
        boolean flag = true;
        Iterator<Company> iterator = companys.iterator();
        while (iterator.hasNext()) {
            Company temp = iterator.next();
            if (temp.getId() == company.getId()) {
                return flag = false;
            }
        }
        saveCustomers2File();
        companys.add(company);
        return flag;


    }

    @Override
    public List<Company> selectCompanyByYearRange(Integer year1, Integer year2) {
        if (year1 == 0) {
            year1 = Integer.MAX_VALUE;
        }
        Integer finalYear = year1;
        return companys.stream()
                .filter(company -> company.getYear() >= finalYear && company.getYear() < year2)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCompanyById(String id) {
        companys.removeIf(company -> company.getId().equals(id));//使用removeIf
        saveCustomers2File();
    }

    @Override
    public List<Company> yearOfEstablishmentSortedQuery() {
        return companys.stream()
                .sorted(Comparator.comparing(Company::getYear))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Company>> reportA() {
        return companys.stream()
                .collect(Collectors.groupingBy(Company::getBoss, Collectors.toList()));
    }

    @Override
    public Map<Integer, List<Company>> reportB() {
        return companys.stream()
                .collect(Collectors.groupingBy(Company::getYear, Collectors.toList()));
    }

    @Override
    public Map<Integer, Long> reportC() {
        return companys.stream()
                .collect(Collectors.groupingBy(Company::getYear, Collectors.counting()));
    }

    @Override
    public Optional<Integer> selectEarliestCreatedCompany() {
        return companys.stream()
                .map(Company::getYear)
                .min(Integer::compareTo);
    }
}
