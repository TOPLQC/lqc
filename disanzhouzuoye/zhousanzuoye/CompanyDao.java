package com.wnxy.disanzhouzuoye.zhousanzuoye;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//1、提取接口
public interface CompanyDao {
    List<Company> showAllCompany();

    Optional<Company> selectCompanyById(Integer id);

    boolean addCompany(Company company);

    List<Company> selectCompanyByYearRange(Integer year1, Integer year2);

    void deleteCompanyById(Integer id);

    List<Company> yearOfEstablishmentSortedQuery();

    Map<String, List<Company>> reportA();

    Map<Integer, List<Company>> reportB();

    Map<Integer, Long> reportC();

    Optional<Integer> selectEarliestCreatedCompany();

}
