package com.hummingbird.account.mapper;

import com.hummingbird.account.entity.TradeRecord;

public interface TradeRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TradeRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TradeRecord record);

    /**
     * 根据主键查询记录
     */
    TradeRecord selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TradeRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TradeRecord record);
}