package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.Comment;
import com.youko.customerfrontstage.dto.comment.CommentDto;
import com.youko.customerfrontstage.mapper.CommentMapper;
import com.youko.customerfrontstage.mapper.CustomerMapper;
import com.youko.customerfrontstage.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CommentService
 * @Description: some desc
 * @date: 2022/7/7 17:15
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    PictureMapper pictureMapper;

    @Autowired
    CustomerMapper customerMapper;

    public List<CommentDto> getSpuComment(int spuID){
        List<Comment> comments = commentMapper.findSpuComment(spuID);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            commentDto.setComment(comment.getSpuComment());
            commentDto.setCommentID(comment.getId());
            commentDto.setPicPath(customerMapper.getCustomerByName(comment.getCustomerName()).getAvatar());
            commentDto.setCustomerName(comment.getCustomerName());
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }
}
