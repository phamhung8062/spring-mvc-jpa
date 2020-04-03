package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.service.IBuildingService;
@Service
public class BuildingService implements IBuildingService{
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	
	@Override
	public List<BuildingDTO> findAll(BuildingSeachBuilder filedSearch,Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(filedSearch);
		List<BuildingEntity> buildingEntities =buildingRepository.findAll(properties, pageable, filedSearch);
		return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
		
		/*List<BuildingEntity> buildingEntities =buildingRepository.findAll(pageable).getContent();
		return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());*/
		//return null;
	}
	private Map<String, Object> convertToMapProperties(BuildingSeachBuilder filedSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = BuildingSeachBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				// khac buildingtypes ms dc vo
				if (!field.getName().equals("buildingTypes") && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("areaRent") && !field.getName().startsWith("staffId")) {
					field.setAccessible(true);// cap quyen truy cap cho private
					if (field.get(filedSearch) instanceof String) {
						if (field.getName().equals("buildingArea") || field.getName().equals("numberOfBasement")) {
							if (field.get(filedSearch) != null && StringUtils.isNotEmpty((String) field.get(filedSearch))) {
								properties.put(field.getName().toLowerCase(),Integer.parseInt((String) field.get(filedSearch)));

							}
						} else {
							properties.put(field.getName().toLowerCase(), field.get(filedSearch));
						}
					}

				}
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return properties;
	}
	@Override
	public Map<String, String> getDistricts() {
		Map<String,String> districts=new HashMap<String, String>();
		for(DistrictsEnum item:DistrictsEnum.values() ) {
			districts.put(item.toString(),item.getDistrictvalue());
		}
		return districts;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String > buildingTypes=new HashMap<>();
		for(BuildingTypesEnum item: BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getBuildingTypeValue());
		}
		return buildingTypes;
	}
	
	@Override
	@Transactional
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity =buildingConverter.convertToEntity(buildingDTO);
		StringBuilder result = new StringBuilder("");
		if(buildingDTO.getBuildingTypes().length>0) {
			result.append(buildingDTO.getBuildingTypes()[0]);
			Arrays.stream(buildingDTO.getBuildingTypes())
					.filter((item -> !item.equals(buildingDTO.getBuildingTypes()[0])))
					.forEach(item -> result.append(","+item+""));
		}
		buildingEntity.setType(""+result+"");	
		if (buildingDTO.getAreaRent() != null && StringUtils.isNotEmpty((String) buildingDTO.getAreaRent())) {
			 String rentare = buildingDTO.getAreaRent().toString();
			 String[] words = rentare.split(",");
			 if(words.length>0) {
					for(int i=0;i<words.length;i++) {
						RentAreaEntity areaEntity=new RentAreaEntity();
						areaEntity.setValue(Integer.parseInt(words[i]));
						areaEntity.setBuilding(buildingEntity);
						rentAreaRepository.save(areaEntity);
					}
					
				} 
		}
		return buildingConverter.convertToDTO(buildingRepository.save(buildingEntity));
	}
	@Override
	public BuildingDTO findbyId(Long id) {
		BuildingEntity buildingEntities = buildingRepository.findOne(id);
		BuildingDTO buildingDTO=buildingConverter.convertToDTO(buildingEntities);
		if (buildingEntities.getType() != null && StringUtils.isNotEmpty((String) buildingEntities.getType())) {
			 String type = buildingEntities.getType().toString();		 
			 String[] words = type.split(",");
			 if(words.length>0) {
				 buildingDTO.setBuildingTypes(words);	
			 }
		}
		List<RentAreaEntity> areaEntity=rentAreaRepository.findByBuildingId(id);
		if(areaEntity.size()>0) {
		List<Integer> value=new ArrayList<Integer>();
		for(RentAreaEntity s : areaEntity) {
			value.add(s.getValue());
		}
		StringBuilder result = new StringBuilder("");
		result.append(""+value.get(0)+"");
		for(int i=0;i<value.size();i++) {
			result.append(","+value.get(i)+"");
		}
		buildingDTO.setAreaRent(""+result+"");
		}
		return buildingDTO;
	}
	@Override
	public BuildingDTO update(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=buildingConverter.convertToEntity(buildingDTO);
		StringBuilder result = new StringBuilder("");
		if(buildingDTO.getBuildingTypes().length>0) {
			result.append(buildingDTO.getBuildingTypes()[0]);
			Arrays.stream(buildingDTO.getBuildingTypes())
					.filter((item -> !item.equals(buildingDTO.getBuildingTypes()[0])))
					.forEach(item -> result.append(","+item+""));
		}
		buildingEntity.setType(""+result+"");	
		return buildingConverter.convertToDTO(buildingRepository.save(buildingEntity));
	}
	@Override
	public List<BuildingDTO> findAllUser() {
		List<BuildingEntity> entities= buildingRepository.findAll();
		return entities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	@Override
	public int getTotalItem() {
		return (int) buildingRepository.count();
	}
	@Override
	public void deleteMany(BuildingDTO buildingDTO) {
		Long[] ids= buildingDTO.getIds();
		for(int i=0;i<ids.length;i++) {
			rentAreaRepository.deleteBuilding(ids[i]);
			buildingRepository.delete(ids[i]);
		
		}	
	}
	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingEntity> entities= buildingRepository.findAll();
		return entities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
