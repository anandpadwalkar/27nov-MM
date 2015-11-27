package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iitms.rfcampusdata.authentication.entity.RoleMenuResponse;
import com.iitms.rfcampusdomain.authentication.service.MenuService;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/menus")   
    public @ResponseBody List<RoleMenuResponse> getMenus() {
        return menuService.getMenuList(1);
    }

    /*
     * @RequestMapping(value = "/modules", method = RequestMethod.GET) public ModelAndView getModulesList(ModelMap
     * model){ logger.info("Module List :"); List<ModuleMasterEntity> moduleList = moduleService.listAuthorisedModule();
     * model.addAttribute("moduleList", moduleList); ModelAndView modelAndView = new ModelAndView("module-list", model);
     * return modelAndView; }
     */

    /*
     * @RequestMapping(value = "/modules/list", method = RequestMethod.GET) public String getModulesList(){ return
     * "module-list"; }
     */
    @RequestMapping(value = "/testing", method = RequestMethod.POST)
    public String testing(@RequestParam(required = false, defaultValue = "0") int check) {
        logger.info("Param : " + check);
        return "test";
    }

    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public String testing1() {

        return "test";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Already Logged In : " + (auth instanceof AnonymousAuthenticationToken));
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            logger.info("Already Logged In");
            return "redirect:/admin";
        }
        return "login1";
    }

    @RequestMapping(value = "/invalid-session", method = RequestMethod.GET)
    public String invalid() {
        return "invalid-session";
    }
    
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error404() {
        return "404";
    }
}
