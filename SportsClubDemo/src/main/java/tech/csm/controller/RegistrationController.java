package tech.csm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tech.csm.Util.FIleUpload;
import tech.csm.model.Club;
import tech.csm.model.RegistrationDetails;
import tech.csm.model.Sports;
import tech.csm.service.ClubService;
import tech.csm.service.RegistrationDetailsService;
import tech.csm.service.SportsService;

@Controller
@RequestMapping("/sportsRegForm")
public class RegistrationController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private SportsService sportsService;

	@Autowired
	private RegistrationDetailsService RegistrationDetailsService;

	@GetMapping("/getForm")
	public String RegistrationForm(Model model) {

		List<Club> clubList = clubService.getAllClubs();
		model.addAttribute("clubList", clubList);

		List<RegistrationDetails> applicationList = RegistrationDetailsService.getAllActiveApplication();
		model.addAttribute("applicationList", applicationList);

		return "sportsClubRegistration";
	}

	@PostMapping("registerApplication")
	public String saveApplication(@RequestParam("regId") String regId,@RequestParam("clubId") Club club, @RequestParam("sportsId") Sports sports,
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phoneNo") String phoneNo,
			@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
			@RequestParam("gender") String gender, @RequestParam("file") MultipartFile file) {

		RegistrationDetails regDtls = new RegistrationDetails();
        
		if(regId!="-1") {
			regDtls.setRegId(Integer.parseInt(regId));
			regDtls.setIsActive("Yes");
			}
		regDtls.setClub(club);
		regDtls.setSports(sports);
		regDtls.setName(name);
		regDtls.setEmail(email);
		regDtls.setMobileNo(phoneNo);
		regDtls.setGender(gender);
		regDtls.setImagePath(FIleUpload.UploadFile(file));
		regDtls.setDob(dob);
		System.out.println(regDtls);

		RegistrationDetails rd = RegistrationDetailsService.saveApplication(regDtls);

		return "redirect:./getForm";
	}

	@GetMapping("/updateApplication")
	public String updateAppliation(Model model,@RequestParam("appId") Integer regId) {
		
		RegistrationDetails reg = RegistrationDetailsService.findDetailsById(regId);
		
		
		String status = "update";
		
		List<Club> clubList = clubService.getAllClubs();
		
		model.addAttribute("clubList", clubList);
		model.addAttribute("status", status);

		List<RegistrationDetails> applicationList = RegistrationDetailsService.getAllActiveApplication();
		
		model.addAttribute("applicationList", applicationList);
		model.addAttribute("currAppl", reg);
		
		return "sportsClubRegistration";
	}

	@GetMapping("/getClub")
	public void getClubs(@RequestParam("clubId") Integer clubId, HttpServletResponse resp) throws IOException {

		List<Sports> sportsList = sportsService.getAllSportsById(clubId);

		String re = "<option value='-1'>-select-</option>";
		for (Sports x : sportsList) {

			re = re + "<option value='" + x.getSportsId() + "'>" + x.getSportsName() + " </option>";
		}

		resp.getWriter().print(re);
	}

	@GetMapping("/deleteApplication")
	public String deleteApplication(@RequestParam("appId") Integer regId) {
		
		
		RegistrationDetails currAppl = RegistrationDetailsService.findDetailsById(regId) ;
		
		currAppl.setIsActive("No");
		
	    RegistrationDetails deletedAppl = RegistrationDetailsService.saveApplication(currAppl);
		
		return "redirect:./getForm";
	}

}
