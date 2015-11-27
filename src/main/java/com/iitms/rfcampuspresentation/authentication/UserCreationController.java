package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdata.authentication.entity.UserMasterEntity;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;
import com.iitms.rfcampusdomain.authentication.service.RoleCreationService;
import com.iitms.rfcampusdomain.authentication.service.UserCreationService;

@Controller
public class UserCreationController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserCreationService userCreationService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private RoleCreationService roleCreationService;

    @RequestMapping(value = "/user-creation", method = RequestMethod.GET)
    public ModelAndView getUser() {
        ModelAndView modelAndView = new ModelAndView("user-creation");
        List<ModuleMasterEntity> moduleList =
            moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        List<RoleMasterEntity> roleList = roleCreationService.getAllRoles();
        modelAndView.addObject("moduleList", moduleList);
        modelAndView.addObject("roleList", roleList);

        return modelAndView;
    }

    @RequestMapping(value = "/user-creation/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserMasterEntity entity, BindingResult result,
        @RequestParam(name = "userImage") MultipartFile userImage, HttpServletRequest request) {
        logger.info("AddUser User : " + entity);
        userCreationService.addUser(entity);
        return "redirect:/user-creation";
    }

    @RequestMapping(value = "/user-creation/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserMasterEntity entity, BindingResult result,
        @RequestParam(name = "userImage") MultipartFile userImage, HttpServletRequest request) {
        logger.info("Update User : " + entity);
        userCreationService.updateUser(entity);
        return "redirect:/user-creation";
    }
    
    @RequestMapping(value = "/user-creation/search", method = RequestMethod.POST)
    public @ResponseBody List<UserMasterEntity> searchUserByCriteria(@RequestParam(name = "searchBy") int searchBy,
        @RequestParam(name = "searchText") String searchText) {
        logger.info("SearchUserByCriteria - searchBy : "+searchBy+", searchText : " + searchText);
        List<UserMasterEntity> list = userCreationService.searchUserByCriteria(searchBy, searchText);
        return list;
    }
    
    @RequestMapping(value = "/user-creation/{user-id}", method = RequestMethod.POST)
    public @ResponseBody UserMasterEntity getUserInformation(@PathVariable("user-id") int userId){
        logger.info("GetUserInformation - userId : "+userId);
        return userCreationService.getUserInformation(userId);
        
    }
}
