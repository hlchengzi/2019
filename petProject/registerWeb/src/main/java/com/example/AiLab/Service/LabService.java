package com.example.AiLab.Service;

import com.example.AiLab.domain.Lab;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jing on 2017/7/7.
 */
@Service
public interface LabService {


    Lab saveLab(String name
             ,String sex
             ,String grade
             ,String number
             ,String major
             ,String tel
             ,String qq
             ,String grope);
}
