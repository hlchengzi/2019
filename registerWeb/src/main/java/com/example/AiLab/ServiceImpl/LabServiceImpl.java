package com.example.AiLab.ServiceImpl;

import com.example.AiLab.Service.LabService;
import com.example.AiLab.domain.Lab;
import com.example.AiLab.repository.LabRepository;

import org.springframework.data.domain.PageRequest;;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by jing on 2017/7/7.
 */

@Service
public class LabServiceImpl implements LabService {
    private LabRepository labRepository;

    public LabServiceImpl(LabRepository labRepository) {
        this.labRepository = labRepository;
    }


    @Override
    public Lab saveLab(String name
            ,String sex
            ,String grade
            ,String number
            ,String major
            ,String tel
            ,String qq
            ,String grope) {
        Lab lab = new Lab( name, sex, grade, number, major, tel, qq, grope);
        labRepository.save(lab);
        return null;
    }
}
