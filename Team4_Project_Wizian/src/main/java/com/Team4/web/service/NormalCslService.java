package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.AttachmentEntity;
import com.Team4.web.entity.CslApplyEntity;
import com.Team4.web.entity.CslScheduleEntity;
import com.Team4.web.entity.CslorEntity;
import com.Team4.web.entity.StudentEntity;
import com.Team4.web.mongodbclass.CslApplyMongo;
import com.Team4.web.mongodbrepository.CslApplyRepoMongo;
import com.Team4.web.repository.AttachmentRepoJpa;
import com.Team4.web.repository.CounselApplyRepoJpa;
import com.Team4.web.repository.CounselorRepoJpa;
import com.Team4.web.repository.CslScheduleRepoJpa;
import com.Team4.web.repository.StudentRepoJpa;

@Service
public class NormalCslService {
	
	@Autowired
	CounselorRepoJpa counselorRepoJpa;
	
	@Autowired
	CslScheduleRepoJpa cslScheduleRepo;
	
	@Autowired
	StudentRepoJpa studentRepoJpa;
	
	@Autowired
	CslApplyRepoMongo cslApplyRepoMongo;
	
	@Autowired
	CounselApplyRepoJpa cslApplyRepoJpa;
	
	@Autowired
	AttachmentRepoJpa attachmentRepoJpa;

	public List<CslorEntity> getJpaCounselorByCareer() {
		
		return counselorRepoJpa.findAllByCate("1");
	}
	
	// 페이징 기능 추가
	public Page<CslorEntity> getJpaCounselorByCate(Pageable pageable , String cate) {
		return counselorRepoJpa.findAllByCate(cate, pageable);
	}

	public List<CslorEntity> getJpaCslorByGender() {
		return counselorRepoJpa.findAllByCate("2");
	}

	public List<CslScheduleEntity> getJpaCslSchduleByCounselor(String cslNo) {
		return cslScheduleRepo.findAllByCounselor(counselorRepoJpa.findById(cslNo));
	}

	public void saveCslApply(CslApplyMongo cslApply) {
		StudentEntity student = studentRepoJpa.findByStudNo(cslApply.getStudNo());
		CslorEntity couselor = counselorRepoJpa.findById(cslApply.getCslorNo()).orElse(null);
		AttachmentEntity attachment = attachmentRepoJpa.findById(cslApply.getAttachmentNo()).orElse(null);
		CslApplyEntity cslApp = new CslApplyEntity();
		cslApp.setCate(cslApply.getCate());
		cslApp.setStudent(student);
		cslApp.setCounselor(couselor);
		cslApp.setStat("1");
		cslApp.setAttachment(attachment);
		
		CslScheduleEntity schedule = cslScheduleRepo.findById(Integer.parseInt(cslApply.getSchNo())).orElse(null);
		schedule.setIsbook("1");
		cslScheduleRepo.save(schedule);
		
		cslApp.setCschedule(schedule);
		cslApp.setCslDetail(cslApply.getCslApplyText());
		cslApplyRepoJpa.save(cslApp);
		
		cslApplyRepoMongo.save(cslApply);
	}

	public Page<CslorEntity> getJpaCounselorByGender(Pageable pageable) {
		return null;
	}
	
	
}
