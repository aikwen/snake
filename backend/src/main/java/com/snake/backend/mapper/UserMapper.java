package com.snake.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snake.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
