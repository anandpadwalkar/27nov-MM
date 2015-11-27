package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampuscommon.PaginationResponse;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleTypeMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;
import com.iitms.rfcampusdomain.authentication.service.RoleCreationService;

@Controller
public class RoleCreationController {

    private static final Logger logger = LoggerFactory.getLogger(RoleCreationController.class);

    @Autowired
    private RoleCreationService roleCreationService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private SessionUser sessionUser;
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ModelAndView getRolesList(ModelMap model) {
        logger.info("Get Roles");
        List<ModuleMasterEntity> moduleList = moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        model.addAttribute("moduleList", moduleList);
        ModelAndView modelAndView = new ModelAndView("role-list", model);
        return modelAndView;
    }

    @RequestMapping(value = "/roles/records", method = RequestMethod.GET)
    public @ResponseBody PaginationResponse getPaginationResponse(
        @RequestParam(required = false, defaultValue = "0") int sEcho,
        @RequestParam(required = false, defaultValue = "0") int iDisplayStart,
        @RequestParam(required = false, defaultValue = "0") int iDisplayLength,
        @RequestParam(required = false, defaultValue = "0") int iSortCol_0,
        @RequestParam(required = false, defaultValue = "asc") String sSortDir_0,
        @RequestParam(required = false, defaultValue = "null") String sSearch,
        @RequestParam(required = false, defaultValue = "0") int roleTypeId, HttpServletRequest request) {
        logger.info("Query String : " + " - " + request.getQueryString());
        logger.info("Roles Pagination : " + roleTypeId + " - " + sEcho + " - " + iDisplayStart + " - " + iDisplayLength
            + " - " + iSortCol_0 + " - " + sSearch);
        PaginationResponse response = roleCreationService.getPaginationResponse(sEcho, iDisplayStart, iDisplayLength,
            iSortCol_0, sSortDir_0, sSearch, roleTypeId);

        return response;
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    public String addRoleMaster(@ModelAttribute RoleMasterEntity entity) {
        logger.info("Add Role : " + entity);
        roleCreationService.addRole(entity);
        return "redirect:/roles";
    }
    
    @RequestMapping(value = "/roles/update", method = RequestMethod.POST)
    public String updateRoleMaster(@ModelAttribute RoleMasterEntity entity) {
        logger.info("Update Role : " + entity);
        roleCreationService.updateRole(entity);
        return "redirect:/roles";
    }
    
    @RequestMapping(value = "/roles/role-type", method = RequestMethod.GET)
    public @ResponseBody List<RoleTypeMasterEntity> getRoleTypes() {
        logger.info("Get Role Types : " + roleCreationService);
        List<RoleTypeMasterEntity> list = roleCreationService.getRoleTypes();
        logger.info("Size : " + list.size());
        return list;
    }
    
    @RequestMapping(value = "/roles/roles-by-type", method = RequestMethod.POST)
    public @ResponseBody List<RoleMasterEntity> getRolesByType(@RequestParam int roleTypeId) {
        logger.info("Get Roles By Type : " + roleTypeId);
        List<RoleMasterEntity> list = roleCreationService.getAllRoles(roleTypeId);
        return list;
    }
}
