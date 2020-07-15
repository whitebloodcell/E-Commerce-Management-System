package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.backstage.dto.UserDto;
import com.qf.ecms.domain.entity.backstage.dto.UserItemDto;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.UserDtoMapper;
import com.qf.ecms.mapper.UserItemDtoMapper;
import com.qf.ecms.mapper.UserItemMapper;
import com.qf.ecms.service.UserDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDtoServiceImpl implements UserDtoService {
    @Resource
    UserDtoMapper userDtoMapper;
    UserItemDtoMapper userItemDtoMapper;

    @Override
    public List<User> list(int page, int size) {
        int limit = (page - 1) * size;
        List<User> users = new ArrayList<>();
        users = userDtoMapper.list(limit,size);
        return users;
    }

    @Override
    public List<User> selectByNameOrTime(String userItemNickname, String createTime,int page,int size) {
        int limit = (page - 1) * size;
        List<User> users = new ArrayList<>();
        users = userDtoMapper.selectByNameOrTime(userItemNickname,createTime,limit,size);
        return users;
    }

    @Override
    public int delete(int userId) {
        int count = 0;
        count = userDtoMapper.delete(userId);
        return count;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        int count = 0;
        count = userDtoMapper.deleteBatch(ids);
        return count;
    }

    @Override
    public int active(int userId) {
        int count = 0;
        count = userDtoMapper.active(userId);
        return count;
    }

    @Override
    @Transactional
    public int insert(UserDto userDto) {
        int count = 0;
        count = userDtoMapper.insert(userDto);
        UserItemDto userItemDto = new UserItemDto();
        userItemDto = userDto.getUserItemDto();
        userItemDto.setUserId(userDto.getUserId());
        int count2 = 0;
        count2 = userItemDtoMapper.insert(userItemDto);
        return count2;
    }

    @Override
    public int updateByPrimaryKey(UserDto userDto) {
        int count = 0 ;
        count = userDtoMapper.updateByPrimaryKeySelective(userDto);
        return count;
    }
}
