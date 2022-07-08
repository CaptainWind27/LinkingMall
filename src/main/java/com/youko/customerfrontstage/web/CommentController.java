package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Comment;
import com.youko.customerfrontstage.dto.comment.CommentDto;
import com.youko.customerfrontstage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Iowa Class Battleship
 * @classname: CommentController
 * @Description: some desc
 * @date: 2022/7/7 17:34
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("user/commoditySku/comment")
    public List<CommentDto> getCommodityComment(@Param("spuID")int spuID){
        return commentService.getSpuComment(spuID);
    }
}
