package com.hotelManagement.dao;

import java.util.List;

import com.hotelManagement.entity.StaffMember;

public interface StaffMemberDao {
	public boolean saveStaff(StaffMember staffMember);

	public StaffMember getStaffById(long id);

	public boolean updateStaff(StaffMember staffMember);

	public List<StaffMember> getAllStaff();

	public boolean deleteStaffMember(long id);

}
