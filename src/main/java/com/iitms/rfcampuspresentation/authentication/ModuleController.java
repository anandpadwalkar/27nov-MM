package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;

@Controller
public class ModuleController {

    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private SessionUser sessionUser;
    
    @RequestMapping(value = "/modules", method = RequestMethod.GET)
    public ModelAndView getModulesList(ModelMap model) {
        List<ModuleMasterEntity> moduleList = moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        List<ModuleMasterEntity> allModuleList = moduleService.listAllModule();
        logger.info("Module List : " + moduleList);
        model.addAttribute("moduleList", moduleList);
        model.addAttribute("allModuleList", allModuleList);
        ModelAndView modelAndView = new ModelAndView("module-list", model);
        return modelAndView;
    }

    @RequestMapping(value = "/modules/add", method = RequestMethod.POST)
    public String addModules(@ModelAttribute ModuleMasterEntity moduleMasterEntity, BindingResult result) {
        boolean flag = moduleService.addModule(moduleMasterEntity);
        return "redirect:/modules";
    }

    @RequestMapping(value = "/modules/update", method = RequestMethod.POST)
    public String updateModules(@ModelAttribute ModuleMasterEntity moduleMasterEntity, BindingResult result,
        @RequestParam(required = false, defaultValue = "0") int moduleStatus) {
        logger.info("Entity : " + moduleMasterEntity + " - " + moduleStatus);
        boolean flag = moduleService.updateModule(moduleMasterEntity);
        return "redirect:/modules";
    }

    @RequestMapping(value = "/modules/exist", method = RequestMethod.POST)
    public @ResponseBody boolean isModuleExist(@RequestParam int moduleId, @RequestParam String moduleName) {
        logger.info("moduleName : " + moduleName);
        boolean flag = moduleService.isModuleNameExist(moduleId, moduleName);
        return flag;
    }
}
