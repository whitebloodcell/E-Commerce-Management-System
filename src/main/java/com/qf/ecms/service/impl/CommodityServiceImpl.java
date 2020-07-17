package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.CommodityDto;
import com.qf.ecms.domain.entity.Commodity;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.ColorSizeMapper;
import com.qf.ecms.mapper.CommodityDetailMapper;
import com.qf.ecms.mapper.CommodityMapper;
import com.qf.ecms.mapper.CommodityPictureMapper;
import com.qf.ecms.service.CommodityService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;
    @Resource
    CommodityDetailMapper commodityDetailMapper;
    @Resource
    ColorSizeMapper colorSizeMapper;
    @Resource
    CommodityPictureMapper commodityPictureMapper;



/*
* 4个表的商品信息添加
*
*
* */
    @Override
    @Transactional
    public int add(CommodityDto commodityDto)  {

        int add = 0;

        //从Dto从获取其中一个对象,添加进这个表
        if (commodityDto.getCommodity() != null) {
            add = commodityMapper.insertAllCommodity(commodityDto.getCommodity());
                if (add == 0) {
                    throw new DaoException(ErrorStatus.DAO_ERROR);
                }
        }else{
            throw new DaoException("请输入commodity库的商品信息",30000);
        }
        //有一个报错,就会回滚

        Integer cid = commodityDto.getCommodity().getCid();
        //先创建commodity的数据,才有Cid,下面的数据添加需要cid




        //同32
        if (commodityDto.getCommodityDetail() != null) {
            commodityDto.getCommodityDetail().setCid(cid);
            add = commodityDetailMapper.insertAllCommodity(commodityDto.getCommodityDetail());
            if (add == 0) {
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else{
            throw new DaoException("请输入commodityDetail库的商品信息",30000);
        }
        //同32
        if (commodityDto.getCommodityPicture() != null) {
            commodityDto.getCommodityPicture().setCid(cid);
            add = commodityPictureMapper.insertAllCommodity(commodityDto.getCommodityPicture());
            if (add == 0) {
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else{
            throw new DaoException("请输入commodityPicture库的商品信息",30000);
        }
        //同32
        if (commodityDto.getColorSize() != null) {
            commodityDto.getColorSize().setCid(cid);
            add = colorSizeMapper.insertAllCommodity(commodityDto.getColorSize());
            if (add == 0) {
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else{
            throw new DaoException("请输入colorSize库的商品信息",30000);
        }
        //所有成功就返回最后的 1
        return add;
    }

    /*
    * 商品信息的修改
    *
    * */
    @Override
    @Transactional
    public int update(CommodityDto commodityDto) {
        int row = 0;


        //修改信息的主表  不能没有数据,需要Cid来做修改数据的条件 必须传入cid
        if (commodityDto.getCommodity() != null) {
            row = commodityMapper.updateCommodity(commodityDto.getCommodity());
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else {
            throw new DaoException("请输入您要修改的商品信息号!",40000);
        }

        //获取Cid  要用Cid在其他的表  的sql下作为条件修改数据
        Integer cid = commodityDto.getCommodity().getCid();

        //这个对象为空,就不用修改,进不去
        if (commodityDto.getColorSize() != null){
            commodityDto.getColorSize().setCid(cid);
            row = colorSizeMapper.updateColorSize(commodityDto.getColorSize());
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }
        //这个对象为空,就不用修改,进不去
        if (commodityDto.getCommodityDetail() != null ){
            commodityDto.getCommodityDetail().setCid(cid);
            row = commodityDetailMapper.updateCommodityDetail(commodityDto.getCommodityDetail());
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }
        //这个对象为空,就不用修改,进不去
        if (commodityDto.getCommodityPicture() != null){
            commodityDto.getCommodityPicture().setCid(cid);
            row = commodityPictureMapper.updateCommodityPicture(commodityDto.getCommodityPicture());
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }

        return row;
    }

    /*
    * 删除,就是修改商品状态
    * */
    @Override
    public int delete(int enable, int cid) {
        int row = 0;
        /*
        * cid是主键,不为0
        * enable 0是下架,1是启用,2是删除
        * */
        if (cid != 0 && enable>=0 && enable<=2){
            row = commodityMapper.deleteCommodity(enable, cid);
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else {
            throw new DaoException("请输入你要修改的状态码!",40000);
        }
        return row;
    }
    /*
    * 当enable=0时,商品是下架的
    *
    * 下架商品的查询
    * */
    @Override
    public List<Commodity> selectDown(int enable) {
        List<Commodity> commodities ;
        if (enable == 0){
            commodities = commodityMapper.selectDownCommodity(enable);
            if (commodities == null){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else {
            throw new DaoException("下架商品的状态码是0",40000);
        }
        return commodities;
    }

    @Override
    public int deleteBatch(List<Integer> list) {
        int row =0;
        if (list != null) {
            row = commodityMapper.deleteBatchCommodity(list);
            if (row == 0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }else {
            throw new DaoException("请输入你要删除的多个商品号!",40000);
        }
        return row;
    }


}
