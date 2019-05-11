package jp.co.timepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.co.timepage.form.TimePageForm;
import jp.co.timepage.service.TimeLineService;

@RestController
@Controller
public class TimeLineInitController {

	@Autowired
	private TimeLineService timeService;


	@RequestMapping("/timeline")
	public ModelAndView test(ModelAndView mav) {

		List<TimePageForm> resultList = timeService.execute();

		mav.addObject("timePages", resultList);
		mav.setViewName("contents/timeLine");

		return mav;
	}

}
