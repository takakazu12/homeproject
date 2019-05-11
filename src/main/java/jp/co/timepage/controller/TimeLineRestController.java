package jp.co.timepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.co.timepage.form.TimePageForm;
import jp.co.timepage.service.TimeLineService;

@RestController
@Controller
public class TimeLineRestController {

	@Autowired
	private TimeLineService timeService;


	@RequestMapping("/timerest")
	public ResponseEntity<List<TimePageForm>> test(ModelAndView mav) {

		List<TimePageForm> resultList = timeService.execute();

		mav.addObject("timePages", resultList);
		mav.setViewName("contents/timeLine");

		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}

}
