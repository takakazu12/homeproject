package jp.co.timepage.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.timepage.dao.TimePageDao;
import jp.co.timepage.form.TimePageForm;
import jp.co.timepage.mybatis.entity.Timepage;
import jp.co.timepage.mybatis.entity.TimepageKey;

@Service
public class TimeLineService {

	@Autowired
	private TimePageDao timePageDao;

	public List<TimePageForm> execute() {

		TimePageForm timeForm = new TimePageForm();
		timeForm.setUserId("1234567890");
		timeForm.setTimeYear("2020");

		TimepageKey timeKey = new TimepageKey();

		BeanUtils.copyProperties(timeForm, timeKey);

		List<Timepage> timepages = timePageDao.selectByPrimaryList(timeKey);

		List<TimePageForm> resultList = convertToForm(timepages);

		return resultList;
	}

	private List<TimePageForm> convertToForm(List<Timepage> timepageList) {

		TimePageForm[] timeForms = new TimePageForm[12];

		for (int i = 0; i < timeForms.length; i++) {

			timeForms[i] = new TimePageForm();
			timeForms[i].setTimeMonth(i+1 + "");
		}

		for (Timepage timePage : timepageList) {

			String strMonth = timePage.getTimeMonth();

			int idx = Integer.parseInt(strMonth);
			BeanUtils.copyProperties(timePage, timeForms[idx -1]);

		}

		return Arrays.asList(timeForms);

	}
}
