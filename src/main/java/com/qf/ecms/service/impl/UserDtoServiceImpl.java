package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.backstage.dto.UserItemDto;
import com.qf.ecms.mapper.UserDtoMapper;
import com.qf.ecms.service.UserDtoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDtoServiceImpl implements UserDtoService {
    @Resource
    UserDtoMapper userDtoMapper;

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
    public int insert(User user) {
        int count = 0;
        count = userDtoMapper.insert(user);
        return count;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        int count = 0 ;
        count = userDtoMapper.updateByPrimaryKeySelective(user);
        return count;
    }
}
