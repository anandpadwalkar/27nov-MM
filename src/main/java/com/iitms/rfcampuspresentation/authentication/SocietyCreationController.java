package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampuscommon.FileUploadUtil;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdata.authentication.entity.SocietyCreationModel;
import com.iitms.rfcampusdata.authentication.entity.SocietyMaster;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;
import com.iitms.rfcampusdomain.authentication.service.SocietyCreationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SocietyCreationController {

    private static final Logger logger = LoggerFactory.getLogger(SocietyCreationController.class);

    @Autowired
    private SocietyCreationService societyCreationService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/society")
    public ModelAndView society() {
        ModelAndView model = new ModelAndView();
        List<SocietyMaster> societyList = societyCreationService.getAllSociety();
        List<ModuleMasterEntity> moduleList =
            moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        model.addObject("societyList", societyList);
        model.addObject("moduleList", moduleList);
        List<ModuleMasterEntity> allModuleList = moduleService.listAllModule();

        model.addObject("allModuleList", allModuleList);
        model.setViewName("society");

        return model;
    }

    // default tab
    @RequestMapping(value = "/society/get-society-module-populated")
    public @ResponseBody SocietyCreationModel get_society_module_populate(@RequestParam("socId") int soc_id) {
        logger.info("Get Society Info : " + soc_id);
        SocietyCreationModel society = societyCreationService.getSocietyById(soc_id);
        return society;
    }

    @RequestMapping(value = "/society/add-society-module", method = RequestMethod.POST)
    public String addSociety(@ModelAttribute SocietyCreationModel entity, BindingResult result,
        @RequestParam(name = "societyLogo") MultipartFile societyLogo, HttpServletRequest request, Model model) {
        logger.info("Add Society : " + entity);
        String fileName = fileUploadUtil.uploadFile(request, societyLogo, entity.getOldSocietyLogo(), "society");
        entity.setSocLogo(fileName);
        int new_soc_id = societyCreationService.addSocietys(entity);
        return "redirect:/society";
    }

    @RequestMapping(value = "/society/update-society-module", method = RequestMethod.POST)
    public String updateSociety(@ModelAttribute SocietyCreationModel entity, BindingResult result,
        @RequestParam(name = "societyLogo") MultipartFile societyLogo, HttpServletRequest request, Model model) {
        logger.info("Update Society : " + entity);
        String fileName = fileUploadUtil.uploadFile(request, societyLogo, entity.getOldSocietyLogo(), "society");
        if (fileName != null) {
            entity.setSocLogo(fileName);
        } else {
            entity.setSocLogo(entity.getOldSocietyLogo());
        }
        boolean new_soc_id = societyCreationService.updateSociety(entity);
        return "redirect:/society";
    }

    // ================================== society module End here ==============================================

    // ================================== Menu Creation module start here ==============================================

    // ================================== Menu Creation module end here ==============================================

    // ================================== User Creation module start here ==============================================
    /* master default tab */
    @RequestMapping(value = "/user-creation")
    public ModelAndView UserCreation() {

        ModelAndView model = new ModelAndView();

        // List<ModuleMasterEntity> moduleList =moduleService.listAuthorisedModule();
        // model.addObject("moduleList", moduleList);
        //
        model.setViewName("user_creation");

        return model;
    }

    // ================================== User Creation module end here ==============================================

    // ================================== Roll Allocation module start here
    // ==============================================
    /* master default tab */
    @RequestMapping(value = "/role-allocation")
    public ModelAndView RoleAllocation() {

        ModelAndView model = new ModelAndView();

        // List<ModuleMasterEntity> moduleList =moduleService.listAuthorisedModule();
        // model.addObject("moduleList", moduleList);
        //
        model.setViewName("role_allocation");

        return model;
    }

    // ================================== Roll Allocation module end here ==============================================

    /* master default tab */
    @RequestMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView model = new ModelAndView();

        // List<ModuleMasterEntity> moduleList =moduleService.listAuthorisedModule();
        // model.addObject("moduleList", moduleList);
        //
        model.setViewName("login");

        return model;
    }

}
