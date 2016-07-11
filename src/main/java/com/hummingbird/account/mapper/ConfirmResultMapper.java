package com.hummingbird.account.mapper;

import com.hummingbird.account.entity.ConfirmResult;

public interface ConfirmResultMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ConfirmResult record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ConfirmResult record);

    /**
     * 根据主键查询记录
     */
    ConfirmResult selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ConfirmResult record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ConfirmResult record);
}