package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MD5;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private MD5 md5;
	
	@Override
	public List<UserDTO> findStaff() {
		List<UserEntity> userEntities = userRepository.findStaff();
		return userEntities.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	@Override
	public Boolean AssignmentStaf(Long buildingid, Long staffid) {
		List<BuildingEntity> entities=buildingRepository.findAll();
		for(BuildingEntity s:entities) {
			List<UserEntity> entities2=s.getStaffs();
			 for(UserEntity s1:entities2) {
				 if(s.getId()==buildingid && s1.getId()==staffid) {
					 return true;
			 		}
			}
	}
		return false;
}
	@Override
	public List<UserDTO> findAll(UserSearchBuilder filedSearch, Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(filedSearch);
		List<UserEntity> userEntities=userRepository.findAll(properties, pageable, filedSearch);
		return userEntities.stream().map(item -> userConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	private Map<String, Object> convertToMapProperties(UserSearchBuilder filedSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = UserSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
					field.setAccessible(true);// cap quyen truy cap cho private
					properties.put(field.getName().toLowerCase(), field.get(filedSearch));
				}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return properties;
	}
	@Override
	public UserDTO findbyId(Long id) {
		UserEntity userEntity=userRepository.findOne(id);
		UserDTO userDTO= userConverter.convertToDTO(userEntity);
		return userDTO;
	}
	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity=userConverter.convertToEntity(userDTO);
		Long[] role=userDTO.getListroles();
		List<RoleEntity> roles =new ArrayList<>();
		for(int i=0;i<role.length;i++) {
			RoleEntity a= new RoleEntity();
			a.setId(role[i]);
			roles.add(a);	
		}
		userEntity.setRoles(roles);
		//userEntity.setPassword(MD5.getMd5("123456"));
		userEntity.setPassword(BCrypt.hashpw("123456",BCrypt.gensalt(12)));
		userEntity.setStatus(1);
		return userConverter.convertToDTO(userRepository.save(userEntity));
	}
	@Override
	public UserDTO update(UserDTO userDTO) {
		UserEntity userEntity=userConverter.convertToEntity(userDTO);
		UserEntity  a1=userRepository.findOne(userDTO.getId());
		Long[] role=userDTO.getListroles();
		List<RoleEntity> roles =new ArrayList<>();
		for(int i=0;i<role.length;i++) {
			RoleEntity a= new RoleEntity();
			a.setId(role[i]);
			roles.add(a);	
		}
		userEntity.setRoles(roles);
		userEntity.setPassword(a1.getPassword());
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setStatus(1);
		return userConverter.convertToDTO(userRepository.save(userEntity));
		
		
	}
	@Override
	public void deleteMany(UserDTO userDTO) {
		Long[] id= userDTO.getIds();
		for(int i=0;i<id.length;i++) {
			userRepository.delete(id[i]);
		}
	}
	@Override
	public UserDTO findbyName(String name) {
		UserEntity userEntity=userRepository.findOneByUserNameAndStatus(name,1);
		UserDTO userDTO= userConverter.convertToDTO(userEntity);
		return userDTO;
	}
	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}
}
