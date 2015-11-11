package com.tianyi.yw.dao;

import com.tianyi.yw.model.ProjectCompany;

/**
 * 项目维护公司关系接口
 * @author liqiang
 *
 */
@MyBatisRepository
public interface ProjectCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCompany record);

    int insertSelective(ProjectCompany record);

    ProjectCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectCompany record);

    int updateByPrimaryKey(ProjectCompany record);
}