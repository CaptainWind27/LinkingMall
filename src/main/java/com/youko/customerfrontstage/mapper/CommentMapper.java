package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    List<Comment> findSpuComment(int spuID);
    List<Comment> findCustomerComment(int customerID);
    int insertComment(Comment comment);
}
