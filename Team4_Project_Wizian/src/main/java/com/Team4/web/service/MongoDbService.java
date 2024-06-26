package com.Team4.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.Academy;
import com.Team4.web.mongodbclass.AcademyStudent;
import com.Team4.web.mongodbclass.CounselorMongo;
import com.Team4.web.mongodbclass.CslSch;
import com.Team4.web.mongodbclass.StudentMongo;
import com.Team4.web.mongodbclass.TestClass;
import com.Team4.web.mongodbclass.UsersMongo;
import com.Team4.web.mongodbrepository.AcademyRepo;
import com.Team4.web.mongodbrepository.AcademyStudentRepo;
import com.Team4.web.mongodbrepository.CounselorCustomRepository;
import com.Team4.web.mongodbrepository.CounselorRepo;
import com.Team4.web.mongodbrepository.CslSchRepo;
import com.Team4.web.mongodbrepository.MongoDbRepo;
import com.Team4.web.mongodbrepository.StudentRepoMongo;
import com.Team4.web.mongodbrepository.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoDbService {
    
	@Autowired
    MongoDbRepo mRepo;
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	CounselorRepo counselorRepo;
	
	@Autowired
	AcademyStudentRepo academyStudentRepo;
	
	@Autowired
	AcademyRepo academyRepo;
	
	@Autowired
	CounselorCustomRepository couselorCustomRepo;
	
	@Autowired
	CslSchRepo cslSchRepo;
	
	@Autowired
	StudentRepoMongo studentRepo;
	
    public List<TestClass> getMdbClassByName(String name) {
        return mRepo.findByName(name);
    }
    
    public void setUsersClass(UsersMongo users) {
    	 usersRepo.save(users);
    }
    
    public List<UsersMongo> getUsersClass() {
    	return usersRepo.findAll();
    }
    
	public void setCounselorClass(CounselorMongo counselor) {
		counselorRepo.save(counselor);
	}

	public List<CounselorMongo> getCounselor() {
		return counselorRepo.findAll();
		
	}

	public UsersMongo getMdbClassByUserNo(String userNo) {
		return usersRepo.findByUserNo("1110000001");
	}

	public void setAcademyStudent(AcademyStudent student) {
		academyStudentRepo.save(student);
	}

	public void setAcademy(Academy academy) {
		academyRepo.save(academy);
	}

	public AcademyStudent getStudentByName(String string) {
		return academyStudentRepo.findAllByName(string);
	}

	public Academy getAcademyByName(String name ) {
		return academyRepo.findByName(name);
	}

	public CounselorMongo getCounselorByUserNo(String userNo) {
		UsersMongo users = usersRepo.findByUserNo(userNo);
			//System.out.println(users.getUser_no());
			//System.out.println(couselorCustomRepo.findByUsersUserNo(userNo).getCsl_detail());

		return counselorRepo.findByUsers(users);
	}

	public List<CounselorMongo> getAllCounselor() {
		return counselorRepo.findAll();
	}

	public CounselorMongo getCounselorByCslLoc(String cslLoc) {
		return counselorRepo.findByCslLoc(cslLoc);
	}

	public void setSclSch(CslSch cslSch) {
		cslSchRepo.save(cslSch);
	}

	public void setStudent() {
		UsersMongo users = new UsersMongo();
		users.setNo("10000003");
		users.setSe_cd("50");
		users.setUser_no("5010000003");
		
		UsersMongo users2 = new UsersMongo();
		users2.setNo("10000004");
		users2.setSe_cd("60");
		users2.setUser_no("6010000004");
		
		StudentMongo student = new StudentMongo();
		student.setSt("재학");
		student.setCCd("888");
		student.setName("학생1");
		student.setAddress("이대역");
		student.setTelNo("12345678");
		student.setUsers(users);
		
		StudentMongo student2 = new StudentMongo();
		student2.setSt("재학");
		student2.setCCd("889");
		student2.setName("학생2");
		student2.setAddress("신촌");
		student2.setTelNo("01234567");
		student2.setUsers(users2);
		
		List<UsersMongo> usersList = new ArrayList<>();
		usersList.add(users);
		usersList.add(users2);
		usersRepo.saveAll(usersList);
		
		List<StudentMongo> studentList = new ArrayList<>();
		studentList.add(student);
		studentList.add(student2);
		studentRepo.saveAll(studentList);
		
		
		
		
	}
}
