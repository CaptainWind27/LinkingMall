package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.PicturePath;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PictureMapper {
    List<PicturePath> getPic(int supID);
    PicturePath getMainPagePic(int supID);
}
