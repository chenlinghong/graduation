package com.chenlinghong.graduation.service;

import com.chenlinghong.graduation.common.PageDto;
import com.chenlinghong.graduation.repository.domain.Goods;

import java.util.List;

/**
 * @Description 商品基本信息
 * @Author chenlinghong
 * @Date 2019/4/14 15:35
 * @Version V1.0
 */
public interface GoodsService extends IBaseService<Goods> {

    /**
     * 根据一级目录ID获取商品列表
     *
     * @param catalogOneId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageDto<Goods> listByCatalogOne(int catalogOneId, long pageNo, long pageSize);

    /**
     * 根据二级目录ID获取商品列表
     *
     * @param catalogTwoId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageDto<Goods> listByCatalogTwo(int catalogTwoId, long pageNo, long pageSize);

    /**
     * 根据名称模糊搜索
     *
     * @param name     商品名称
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageDto<Goods> searchByName(String name, long pageNo, long pageSize);

    /**
     * 获取商品列表
     *
     * @param goodsIdList 商品ID列表
     * @return
     */
    List<Goods> listByIdList(List<Long> goodsIdList);
}
