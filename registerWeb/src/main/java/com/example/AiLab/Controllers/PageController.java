package com.example.AiLab.Controllers;

import com.example.AiLab.Service.LabService;
import com.example.AiLab.domain.Lab;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jing on 2017/7/29.
 */
@Controller
public class PageController {
    private LabService labService;
    public PageController(LabService labService){
        this.labService = labService;
    }
    /**
     * 添加
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView create(@ModelAttribute("model") Lab model) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    /*
    tijiaoao
     */
    @RequestMapping(value="/index" ,method = {RequestMethod.POST})
    public ModelAndView addNews(@Validated @ModelAttribute("model") Lab model, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("index");
        if (result.hasErrors()){
            modelAndView =new ModelAndView("404")

            ;
            return modelAndView;
        }
        labService.saveLab(model.getName(),model.getSex(),model.getGrade(),model.getNumber(),model.getMajor(),model.getTel(),model.getQq(),model.getGrope());
        modelAndView = new ModelAndView("welcome");
        return modelAndView;
    }

}
