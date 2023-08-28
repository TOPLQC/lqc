package com.wnxy.disanzhouzuoye.zhousanzuoye;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyDaoImpl implements CompanyDao {
    private final static
    List<Company> companies = new ArrayList<>();

    static {
        companies.add(new Company(11, "蜗牛", "邓强", 2011));
        companies.add(new Company(12, "千峰", "欧阳锋", 2005));
        companies.add(new Company(13, "传智", "欧阳锋", 2022));
        companies.add(new Company(14, "雷人科技", "邓强", 2009));
        companies.add(new Company(15, "兄弟连", "欧阳锋", 2000));
        companies.add(new Company(16, "达内", "赵灵儿", 2011));
        companies.add(new Company(17, "达外", "赵灵儿", 2019));
    }


    public List<Company> showAllCompany() {
        return companies;
    }

    public Optional<Company> selectCompanyById(Integer id) {
        Optional<Company> optional = companies.stream()
                .filter(company -> company.getId() == id)
                .findFirst();
        if (optional.isPresent()) {
            return Optional.of(optional.get());
        }
        return null;
    }

    public boolean addCompany(Company company) {
        boolean flag = true;
        Iterator<Company> iterator = companies.iterator();
        while (iterator.hasNext()) {
            Company temp = iterator.next();
            if (temp.getId() == company.getId()) {
                return flag = false;
            }
        }
        companies.add(company);
        return flag;

    }

    public List<Company> selectCompanyByYearRange(Integer year1, Integer year2) {
        if (year1 == 0) {
            year1 = Integer.MAX_VALUE;
        }
        Integer finalYear = year1;
        return companies.stream()
                .filter(company -> company.getYear() >= finalYear && company.getYear() < year2)
                .collect(Collectors.toList());
    }

    public void deleteCompanyById(Integer id) {
        companies.removeIf(company -> company.getId() == id);//使用removeIf
//        boolean flag = false;
//        Iterator<Company> iterator = companies.iterator();
//        while (iterator.hasNext()){
//            Company company = iterator.next();
//            if (company.getId()==id){
//                iterator.remove();
//                return flag=true;
//            }
//        }
//        return flag;
    }

    public List<Company> yearOfEstablishmentSortedQuery() {
        return companies.stream()
                .sorted(Comparator.comparing(Company::getYear))
                .collect(Collectors.toList());
    }

    public Map<String, List<Company>> reportA() {
        return companies.stream()
                .collect(Collectors.groupingBy(Company::getBoss, Collectors.toList()));
    }

    public Map<Integer, List<Company>> reportB() {
        return companies.stream()
                .collect(Collectors.groupingBy(Company::getYear, Collectors.toList()));
    }

    public Map<Integer, Long> reportC() {
        return companies.stream()
                .collect(Collectors.groupingBy(Company::getYear, Collectors.counting()));
    }

    public Optional<Integer> selectEarliestCreatedCompany() {
        return companies.stream()
                .map(Company::getYear)
                .min(Integer::compareTo);
    }
}
