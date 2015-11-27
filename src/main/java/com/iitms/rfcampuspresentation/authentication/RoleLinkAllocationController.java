package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuAllocationEntity;
import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;
import com.iitms.rfcampusdomain.authentication.service.RoleLinksAllotmentService;

@Controller
public class RoleLinkAllocationController {
    private static final Logger logger = LoggerFactory.getLogger(RoleLinkAllocationController.class);

    @Autowired
    private RoleLinksAllotmentService roleLinksAllotmentService;

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = "/allocate-role")
    public String getAllocatedRole(Model model) {
        model.addAttribute("allocatedRoleList", roleLinksAllotmentService.getAllocatedRole());
        model.addAttribute("notAllocatedRoleList", roleLinksAllotmentService.getNotAllocatedRole());
        List<ModuleMasterEntity> moduleList = moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        model.addAttribute("moduleList", moduleList);
        model.addAttribute("roleMenuAlloc", new RoleMenuAllocationEntity());
        logger.info("Module Size:" + moduleList.size());
        return "roleLinkAllocation";
    }

    @RequestMapping(value = "/not-allocate-role")
    public String getNotAllocatedRole(@ModelAttribute("roleMenuAlloc") RoleMenuAllocationEntity roleMenuAllocation,
        @RequestParam("roleId") int roleId, @RequestParam("moduleIds") String moduleIds) {
        logger.info("roleId:" + roleId + " " + "ModulesIds:" + moduleIds);
        roleLinksAllotmentService.removeAllocatedMenusByRole(roleId);
        String moduleMenuList[] = moduleIds.split(",");
        for (String s : moduleMenuList) {
            int menu_id = Integer.parseInt(s.substring(0, s.indexOf(":")));
            int module_id = Integer.parseInt(s.substring(s.indexOf(":") + 1));
            roleMenuAllocation.setId(Integer.parseInt(s.substring(0, s.indexOf(":")) + roleId + module_id));
            roleMenuAllocation.setRoleId(roleId);
            roleMenuAllocation.setModuleId(module_id);
            roleMenuAllocation.setMenuId(menu_id);
            boolean b = roleLinksAllotmentService.setModuleAndRoleWiseMenu(roleMenuAllocation);
            logger.info("insert result:" + b);
            logger.info("" + Integer.parseInt(s.substring(0, s.indexOf(":")) + roleId + module_id));
            logger.info("roleId=>" + roleMenuAllocation.getRoleId() + "menuId=>" + roleMenuAllocation.getMenuId()
                + "  moduleId=>" + roleMenuAllocation.getRoleId());
        }
        return "redirect:/allocate-role";
    }

    @RequestMapping(value = "/showModulePerMenu")
    public @ResponseBody List<RoleMenuResponse> getModuleAndMenu() {
        return roleLinksAllotmentService.getModulePerMenu();
    }

    @RequestMapping(value = "/showModulePerMenu1")
    public String getModuleAndMenu(Model model) {
        // model.addAttribute("moduleWiseMenu",roleLinksAllotmentService.getModulePerMenu());
        // model.addAttribute("moduleList",moduleService.listAuthorisedModule());
        return "roleLinkAllocation";
    }

    @RequestMapping(value = "/loadMenuAsPerRole")
    public @ResponseBody List<RoleMenuAllocationEntity> getMenuById(@RequestParam("roleId") int id, Model model) {
        List<RoleMenuAllocationEntity> menuNumberList = roleLinksAllotmentService.getMenuAsPerRole(id);
        model.addAttribute("MenuAsPerRole", roleLinksAllotmentService.getMenuAsPerRole(id));
        logger.info("roleid:" + id);
        // logger.info("Menu List :"+menuNumberList);
        return menuNumberList;
    }

    @RequestMapping(value = "/menuAndSubMenu")
    public @ResponseBody List<RoleMenuAllocationEntity> getMenusSu(@RequestParam("roleId") int id, Model model) {
        List<RoleMenuAllocationEntity> menuNumberList = roleLinksAllotmentService.getMenuAsPerRole(id);
        model.addAttribute("MenuAsPerRole", roleLinksAllotmentService.getMenuAsPerRole(id));
        logger.info("roleid:" + id);
        // logger.info("Menu List :"+menuNumberList);
        return menuNumberList;
    }

}
