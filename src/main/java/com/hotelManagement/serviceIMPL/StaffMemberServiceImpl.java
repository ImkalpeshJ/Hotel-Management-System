package com.hotelManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.dao.StaffMemberDao;
import com.hotelManagement.entity.StaffMember;
import com.hotelManagement.service.StaffMemberService;

@Service
public class StaffMemberServiceImpl implements StaffMemberService {

	@Autowired
	StaffMemberDao dao;

	@Override
	public boolean saveStaff(StaffMember staffMember) {
		return dao.saveStaff(staffMember);
	}

	@Override
	public StaffMember getStaffById(long id) {
		return dao.getStaffById(id);
	}

	@Override
	public boolean updateStaff(StaffMember staffMember) {
		return dao.updateStaff(staffMember);
	}

	@Override
	public List<StaffMember> getAllStaff() {
		return dao.getAllStaff();
	}

	@Override
	public boolean deleteStaffMember(long id) {
		return dao.deleteStaffMember(id);
	}

}
