package com.pk.roadproject;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pk.dto.MemberDto;
import com.pk.dto.ReservationDto;
import com.pk.dto.ReviewDto;
import com.pk.service.MemberService;
import com.pk.service.ReservationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	MemberDto memberDto = new MemberDto();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index.tiles";
	}

	  @RequestMapping(value = "/detail", method = RequestMethod.GET)
	  public String detail(Locale locale, Model model) {
		  System.out.println("content2 접속");
		  model.addAttribute("url", "content2" );
		  return "detail.tiles";
	  }
	  
	  //회원유형선택
	  @RequestMapping(value = "/SelectJoin", method = RequestMethod.GET)
	  public String SelectJoin(Locale locale, Model model) {
		  System.out.println("content4 접속");
		  model.addAttribute("url", "content4" );
		  return "SelectJoin.tiles";
	  }
	  
	  //회원가입
	  @RequestMapping(value = "/join", method = {RequestMethod.GET, RequestMethod.POST})
	    public String join(@RequestParam(required = false) String role, Locale locale, Model model) {
	        logger.info("join 접속");
	        
	        model.addAttribute("role", role);
	        
	        return "join.tiles";
	    }
	  @RequestMapping(value = "/join2", method = {RequestMethod.GET, RequestMethod.POST})
	    public String join2(@RequestParam(required = false) String role, Locale locale, Model model) {
	        logger.info("join2 접속");
	        
	        model.addAttribute("role", role);
	        
	        return "join2.tiles";
	    }
	  
	  
	  @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
	    public String index(Locale locale, Model model) {
	        logger.info("index 접속");
	        
	        return "index.tiles";
	    }
	  
	  @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	    public String login(Locale locale, Model model) {
	        logger.info("login 접속");
	        
	        return "login.tiles";
	    }
	  
	  @RequestMapping(value = "admin/adminPage", method = {RequestMethod.GET, RequestMethod.POST})
	    public String adminPage(Locale locale, Model model) {
	        logger.info("adminPage 접속");
	        
	        return "admin/adminPage.tiles";
	    }
	  
	  @RequestMapping(value = "admin/admin_reviewDetail", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_reviewDetail(Locale locale, Model model) {
	        logger.info("admin_reviewDetail 접속");
	        
	        return "admin/admin_reviewDetail.tiles";
	    }
	  
	  @RequestMapping(value = "admin/admin_keyword", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_keyword(Locale locale, Model model) {
	        logger.info("admin_keyword 접속");
	        
	        return "admin/admin_keyword.tiles";
	    }
	  
	  @RequestMapping(value = "admin/admin_keywordDetail", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_keywordDetail(Locale locale, Model model) {
	        logger.info("admin_keywordDetail 접속");
	        
	        return "admin/admin_keywordDetail.tiles";
	    }
	  
	  @RequestMapping(value = "admin/admin_user", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_user(Locale locale, Model model) {
	        logger.info("admin_user 접속");
	        
	        return "admin/admin_user.tiles";
	    }
	  @RequestMapping(value = "admin/admin_userDetail", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_userDetail(Locale locale, Model model) {
	        logger.info("admin_userDetail 접속");
	        
	        return "admin/admin_userDetail.tiles";
	    }
	  @RequestMapping(value = "admin/admin_userDetail2", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_userDetail2(Locale locale, Model model) {
	        logger.info("admin_userDetail2 접속");
	        
	        return "admin/admin_userDetail2.tiles";
	    }
	  
	  @RequestMapping(value = "admin/admin_decl", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_decl(Locale locale, Model model) {
	        logger.info("admin_decl 접속");
	        
	        return "admin/admin_decl.tiles";
	    }
	  @RequestMapping(value = "admin/admin_declDetail", method = {RequestMethod.GET, RequestMethod.POST})
	    public String admin_declDetail(Locale locale, Model model) {
	        logger.info("admin_declDetail 접속");
	        
	        return "admin/admin_declDetail.tiles";
	    }
	  
	  @RequestMapping(value = "/joinFine", method = {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView joinFine(
	            @RequestParam String nickname,
	            @RequestParam String userid,
	            @RequestParam String pass1,
	            @RequestParam String pass2,
	            @RequestParam String addr1,
	            @RequestParam String addr2,
	            @RequestParam(required = false) String tel,
	            @RequestParam(required = false) String role,
	            @RequestParam(required = false) String buisness) throws Exception {
		  logger.info("joinFine 접속");
		  
		  ModelAndView mav = new ModelAndView();
		  int role2 = 0;
		  String password = null;
		  System.out.println(role);
		  System.out.println(userid);
		  System.out.println(nickname);
		  System.out.println(pass1);
		  System.out.println(pass2);
		  System.out.println(addr1);
		  System.out.println(addr2);
		  
		  if(role == null) {
			  role2 = 1;
		  }
		  else {
			  role2 = Integer.parseInt(role);
		  }
	        
		  if(role2 == 1) {
			  if(pass1.equals(pass2)) {
				  System.out.println("??");
				  password = pass1;
				  
				  memberDto.setNickname(nickname);
				  memberDto.setUserid(userid);
				  memberDto.setPassword(password);
				  memberDto.setAddr1(addr1);
				  memberDto.setAddr2(addr2);
				  memberDto.setRole(role2);
				  
				  service.insertDB(memberDto);
				  
			      mav.setViewName("joinFine.tiles");
			  }
			  else {
				  
				  	mav.setViewName("join.tiles"); // 여기서 ModelAndView 객체를 생성하고 뷰 이름을 설정합니다.
				    mav.addObject("alert", "비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
				    mav.addObject("nickname", nickname);
				    mav.addObject("userid", userid);
				    mav.addObject("addr1", addr1);
				    mav.addObject("addr2", addr2);
				    mav.addObject("role", role2);
				    
				    return mav;
				  
			  }
	        

	        
		  }
		  else if(role2 == 2) {
			  
			  if(pass1.equals(pass2)) {
				  System.out.println("??");
				  password = pass1;
				  
				  memberDto.setNickname(nickname);
			      memberDto.setUserid(userid);
			      memberDto.setPassword(password);
			      memberDto.setTel(tel);
			      memberDto.setAddr1(addr1);
			      memberDto.setAddr2(addr2);
			      memberDto.setRole(role2);
			      memberDto.setBuisness(buisness);
				  
				  service.insertDB(memberDto);
				  
			      mav.setViewName("joinFine.tiles");
			  }
			  else {
				  
				  	mav.setViewName("join2.tiles"); // 여기서 ModelAndView 객체를 생성하고 뷰 이름을 설정합니다.
				    mav.addObject("alert", "비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
				    mav.addObject("nickname", nickname);
				    mav.addObject("userid", userid);
				    mav.addObject("tel", tel);
				    mav.addObject("addr1", addr1);
				    mav.addObject("addr2", addr2);
				    mav.addObject("role", role2);
				    
				    return mav;
				  
			  }
		  }
		      
	      return mav;
	    }
	  
	  @RequestMapping(value = "/joinedit", method = {RequestMethod.GET, RequestMethod.POST})
	    public String joinedit(Locale locale, Model model) {
	        logger.info("joinedit 접속");
	        
	        return "joinedit.tiles";
	    }
	  
	  @RequestMapping(value = "/joinDelete", method = {RequestMethod.GET, RequestMethod.POST})
	    public String joineDelete(Locale locale, Model model) {
	        logger.info("joineDelete 접속");
	        
	        return "joinDelete.tiles";
	    }
	  
	  @RequestMapping(value = "/joinDelete_success", method = {RequestMethod.GET, RequestMethod.POST})
	    public String joineDelete_success(Locale locale, Model model) {
	        logger.info("joinDelete_success 접속");
	        
	        return "joinDelete_success.tiles";
	    }
	  
	  @RequestMapping(value = "/selectType", method = {RequestMethod.GET, RequestMethod.POST})
	    public String selectType(Locale locale, Model model) {
	        logger.info("selectType 접속");
	        
	        return "selectType.tiles";
	    }
	  
	  @RequestMapping(value = "/follow", method = {RequestMethod.GET, RequestMethod.POST})
	    public String follow(Locale locale, Model model) {
	        logger.info("follow 접속");
	        
	        return "follow.tiles";
	    }
	  
	  @RequestMapping(value = "/following", method = {RequestMethod.GET, RequestMethod.POST})
	    public String following(Locale locale, Model model) {
	        logger.info("following 접속");
	        
	        return "following.tiles";
	    }
	  
	  @RequestMapping(value = "/myPage", method = {RequestMethod.GET, RequestMethod.POST})
	    public String myPage(Locale locale, Model model) {
	        logger.info("myPage 접속");
	        
	        return "myPage.tiles";
	    }
	  
	  @RequestMapping(value = "/myPage2", method = {RequestMethod.GET, RequestMethod.POST})
	    public String myPage2(Locale locale, Model model) {
	        logger.info("myPage2 접속");
	        
	        return "myPage2.tiles";
	    }
	  
	  @RequestMapping(value = "/myPage3", method = {RequestMethod.GET, RequestMethod.POST})
	    public String myPage3(Locale locale, Model model) {
	        logger.info("myPage3 접속");
	        
	        return "myPage3.tiles";
	    }
	  
	    @Autowired
	    ReservationService reservationService;

	    @RequestMapping(value = "/myPage4", method = {RequestMethod.GET, RequestMethod.POST})
	    public ModelAndView myPage4(Locale locale, Model model ,  HttpSession session) throws Exception {
	    	ModelAndView mav = new ModelAndView();
	    	try {
	            ReservationDto dto = new ReservationDto(); // dto에 필요한 정보를 설정
	            dto.setUserid((String) session.getAttribute("userid"));
	            
	            int result = reservationService.AllCount(dto);
	            int resCnt = reservationService.resCount(dto);
	            int RCnt = reservationService.RCount(dto);
	            int VCnt = reservationService.VCount(dto);
	            int CCnt = reservationService.CCount(dto);
	            
	            List<ReservationDto> resList = reservationService.resList(dto);
	            for(int i =0; i<resList.size(); i++) {
	            	System.out.println(resList.get(i));
	            }
	            mav.setViewName("myPage4.tiles");
	           
	            System.out.println(result);
	            if (result > 0) {
	                logger.info("예약이 있습니다.");
	                session.setAttribute("AllCnt", result);
	                session.setAttribute("resCnt", resCnt);
	                session.setAttribute("RCnt", RCnt);
	                session.setAttribute("VCnt", VCnt);
	                session.setAttribute("CCnt", CCnt);
	                session.setAttribute("resList", resList);

	                
	                System.out.println("총 : "+session.getAttribute("AllCnt"));
	                System.out.println("예약자 정보 : "+session.getAttribute("resList"));
	                mav.addObject("list", resList);
	                
	                
	                return mav; 

	            } else {
	                logger.info("예약이 없습니다.");
	                
	            }
	        } catch (Exception e) {
	            logger.error("에러 발생: " + e.getMessage());
	        }
	        
	        return mav;
	    }
	  
	  
	  @RequestMapping(value = "/map", method = RequestMethod.GET)
	  public String map(Locale locale, Model model) {
		  System.out.println("map 접속");
		  
		  return "map.tiles";
	  }
	  
	  //회원가입
	  @RequestMapping(value = "/addMember", method = RequestMethod.POST)
	    public ModelAndView addMember(
	            @RequestParam String name,
	            @RequestParam String nickname,
	            @RequestParam String userid,
	            @RequestParam String password,
	            @RequestParam String tel,
	            @RequestParam int zipcode,
	            @RequestParam String addr1,
	            @RequestParam String addr2,
	            @RequestParam String birth,
	            @RequestParam String email,
	            @RequestParam(required = false) String role,
	            @RequestParam(required = false) String buisness) throws Exception {
		  
		  int role2 = 0;
		  System.out.println(role);
		  if(role == null) {
			  role2 = 1;
		  }
		  else {
			  role2 = Integer.parseInt(role);
		  }
	        
		  if(role2 == 1) {
	        memberDto.setName(name);
	        memberDto.setNickname(nickname);
	        memberDto.setUserid(userid);
	        memberDto.setPassword(password);
	        memberDto.setTel(tel);
	        memberDto.setZipcode(zipcode);
	        memberDto.setAddr1(addr1);
	        memberDto.setAddr2(addr2);
	        memberDto.setBirth(birth);
	        memberDto.setRole(role2);
	        memberDto.setEmail(email);

	        service.insertDB(memberDto);
		  }
		  else if(role2 == 2) {
		      memberDto.setName(name);
		      memberDto.setNickname(nickname);
		      memberDto.setUserid(userid);
		      memberDto.setPassword(password);
		      memberDto.setTel(tel);
		      memberDto.setZipcode(zipcode);
		      memberDto.setAddr1(addr1);
		      memberDto.setAddr2(addr2);
		      memberDto.setBirth(birth);
		      memberDto.setEmail(email);
		      memberDto.setRole(role2);
		      memberDto.setBuisness(buisness);

		      service.insertDB(memberDto);
		  }

	        ModelAndView modelAndView = new ModelAndView("redirect:/content1");
	        
	        return modelAndView;
	    }
	  
	  //로그인
	  @RequestMapping(value = "/searchMember", method = RequestMethod.POST)
	  public ModelAndView searchMember(
			    @RequestParam(required = false) String userid,
			    @RequestParam(required = false) String password,
			    HttpSession session) throws Exception {
		  
		  
			      
		  		System.out.println(userid);
			    memberDto.setUserid(userid);
			    memberDto.setPassword(password);
			  
			    if (service.searchId(memberDto)) { // 로그인 확인
			        System.out.println("로그인 되었습니다.");
			        MemberDto search = new MemberDto();
		    
			
			        search.setUserid(userid);
			        search = service.searchNick(search);
			        
			        System.out.println(search); // 회원 정보 가져오기
			        String nick = search.getNickname();
			        int role = search.getRole();
			        System.out.println(nick);
			        
			        session.setAttribute("nickname", nick);
			        session.setAttribute("userid", userid);
			        session.setAttribute("role", role);
			        
			        System.out.println("id : "+session.getAttribute("userid")+", nick : "+session.getAttribute("nickname")+", role : "+session.getAttribute("role"));
			 
			    } else {
			        System.out.println("로그인에 실패했습니다.");
			    }

			    ModelAndView modelAndView = new ModelAndView("redirect:/index");
			    return modelAndView;
			}
	  //로그아웃
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public ModelAndView logout(HttpSession session) {
		  
		  session.invalidate();
		  System.out.println("로그아웃 완료");
		  
		  ModelAndView modelAndView = new ModelAndView("redirect:/index");
		  return modelAndView;
	  }
	  
	  @RequestMapping(value = "/recommend", method = RequestMethod.GET)
	  public String recommend(Locale locale, Model model) {
		  System.out.println("recommend 접속");
		  
		  return "recommend.tiles";
	  }
}
