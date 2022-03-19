package com.jt.service;

import com.jt.pojo.Rights;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RightsService {


    List<Rights> getRightsList();
}
