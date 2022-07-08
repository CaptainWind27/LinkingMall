package com.youko.customerfrontstage.dto.comment;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Iowa Class Battleship
 * @classname: CommentDto
 * @Description: some desc
 * @date: 2022/7/7 17:18
 */
@Data
public class CommentDto implements Serializable {
    private static final long serialVersionUID = -2519769485140707140L;
    int commentID;
    String CustomerName;
    String picPath;
    String comment;
}
