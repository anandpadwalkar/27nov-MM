package com.iitms.rfcampuspresentation.authentication;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampuscommon.FileUploadUtil;
import com.iitms.rfcampusdata.authentication.entity.CollegeCreationModel;
import com.iitms.rfcampusdata.authentication.entity.CollegeMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.ModuleMasterEntity;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdata.authentication.entity.SocietyMaster;
import com.iitms.rfcampusdata.authentication.entity.UniversityMaster;
import com.iitms.rfcampusdomain.authentication.service.CollegeCreationService;
import com.iitms.rfcampusdomain.authentication.service.ModuleService;
import com.iitms.rfcampusdomain.authentication.service.SocietyCreationService;
import com.iitms.rfcampusdomain.authentication.service.UniversityAndBoardService;

@Controller
public class CollegeCreationController {

    private static final Logger logger = LoggerFactory.getLogger(CollegeCreationController.class);

    @Autowired
    private CollegeCreationService collegeCreationService;

    @Autowired
    private SocietyCreationService societyCreationService;

    @Autowired
    private UniversityAndBoardService universityAndBoardService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Autowired
    private SessionUser sessionUser;

    @RequestMapping(value = "/college", method = RequestMethod.GET)
    public ModelAndView getColleges(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("college-creation");
        List<CollegeMasterEntity> collegeList = collegeCreationService.getCollegeList();
        List<ModuleMasterEntity> moduleList =
            moduleService.listAuthorisedModule(sessionUser.getCustomLoginUser().getAllocatedRoleIds());
        List<ModuleMasterEntity> allModuleList = moduleService.listAllModule();
        List<SocietyMaster> societyList = societyCreationService.getAllSociety();
        List<UniversityMaster> universityList = universityAndBoardService.getAllUniversity();
        model.addAttribute("collegeList", collegeList);
        model.addAttribute("societyList", societyList);
        model.addAttribute("moduleList", moduleList);

        model.addAttribute("allModuleList", allModuleList);

        model.addAttribute("universityList", universityList);
        return modelAndView;
    }

    @RequestMapping(value = "/college/add", method = RequestMethod.POST)
    public String addCollege(@ModelAttribute CollegeCreationModel entity, BindingResult result,
        @RequestParam(name = "collegeLogo") MultipartFile collegeLogo, HttpServletRequest request) {
        logger.info("Entity : " + entity);
        String fileName = fileUploadUtil.uploadFile(request, collegeLogo, entity.getOldCollegeLogo(), "college");
        entity.setCollegeLogo(fileName);
        collegeCreationService.addCollege(entity);
        return "redirect:/college";
    }

    @RequestMapping(value = "/college/update", method = RequestMethod.POST)
    public String updateCollege(@ModelAttribute CollegeCreationModel entity, BindingResult result,
        @RequestParam(name = "collegeLogo") MultipartFile collegeLogo, HttpServletRequest request) {
        logger.info("Entity : " + entity + " - Multipart : " + collegeLogo.getOriginalFilename());
        String fileName = fileUploadUtil.uploadFile(request, collegeLogo, entity.getOldCollegeLogo(), "college");
        if (fileName != null) {
            entity.setCollegeLogo(fileName);
            // deleteFile(entity.getOldCollegeLogo());
        } else {
            entity.setCollegeLogo(entity.getOldCollegeLogo());
        }

        collegeCreationService.updateCollege(entity);
        return "redirect:/college";
    }

    @RequestMapping(value = "/college/{college-id}", method = RequestMethod.POST)
    public @ResponseBody CollegeCreationModel getCollegeInformation(@PathVariable(value = "college-id") int collegeId) {
        CollegeCreationModel entity = collegeCreationService.getCollegeInformation(collegeId);
        return entity;
    }

    @RequestMapping(value = "/college/by-society", method = RequestMethod.POST)
    public @ResponseBody List<CollegeMasterEntity> getCollegeBySociety(
        @RequestParam(value = "society-id") int societyId) {
        List<CollegeMasterEntity> list = collegeCreationService.getCollegeBySociety(societyId);
        return list;
    }
}
