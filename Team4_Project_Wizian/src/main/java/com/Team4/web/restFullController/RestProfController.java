package com.Team4.web.restFullController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.web.entity.ProfSchedule;
import com.Team4.web.entity.Professer;
import com.Team4.web.model.ProfCslInsertModel;
import com.Team4.web.service.ProfesserService;

@RestController
public class RestProfController {
	
	@Autowired
	private ProfesserService professerService;

	@PostMapping("/calendarData")
	@ResponseBody
	public List<ProfSchedule> calendarData(@RequestParam("pfNo") String pfNo) {
		return professerService.getProfSchedules(pfNo);
	}
	
	@PostMapping("/pfInfoData")
	@ResponseBody
	public List<Professer> pfInfoData(@RequestParam("pfNo") String pfNo){
		return professerService.getProfData(pfNo);
	}
	
	//ajax로 디비에 데이터 삽입
	@PostMapping("/insertProfCslData")
	@ResponseBody
	public Map<String, Object> insertProfCslData(@RequestBody ProfCslInsertModel cslInsertModel) {
		System.err.println(cslInsertModel);
		Map<String, Object> response = new HashMap<>();
		response.put("redirectUrl", "/profcusl/profComplite"); // 리다이렉션할 URL

	    return response;
	}
}
