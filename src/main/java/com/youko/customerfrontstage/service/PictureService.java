package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.PicturePath;
import com.youko.customerfrontstage.mapper.PictureMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {
    @Autowired
    PictureMapper pictureMapper;
    public List<PicturePath> getPicture(int spuID){
        return pictureMapper.getPic(spuID);
    }

    public  PicturePath getMainPagePic(int spuID){
        return  pictureMapper.getMainPagePic(spuID);
    }
}
