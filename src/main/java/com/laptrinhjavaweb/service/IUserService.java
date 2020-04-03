package com.laptrinhjavaweb.service;
import java.util.List;
import org.springframework.data.domain.Pageable;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findStaff();
	Boolean AssignmentStaf(Long buildingid,Long staffid);
	List<UserDTO> findAll(UserSearchBuilder filedSearch,Pageable pageable);
	UserDTO findbyId(Long id);
	UserDTO save(UserDTO userDTO);
	UserDTO update(UserDTO userDTO);
	void deleteMany(UserDTO userDTO);
	UserDTO findbyName(String name);
	int getTotalItem();
}
