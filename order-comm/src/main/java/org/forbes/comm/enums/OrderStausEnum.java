package org.forbes.comm.enums;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * UserStausEnum概要说明：用户状态
 * @author Huanghy
 */
public enum OrderStausEnum {

	PENDPAYMENT("1","待付款"),
	GOODRECE("2","待收货"),
	CANCELLED("3","已取消");

	/***编码
	 */
	private String code;

	/***名称
	 */
	private String name;


	/***
	 * existsUserStausEnum方法慨述:
	 * @param code
	 * @return boolean
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 上午11:19:13
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static boolean existsOrderStausEnum(String code){
		return Arrays.asList(OrderStausEnum.values()).stream()
		.filter(orderStaus -> ((OrderStausEnum)orderStaus).getCode().equals(code)).count() > 0 ;
	}


	/***
	 * receUserStaus方法慨述:
	 * @return List<Map<String,String>>
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 上午11:22:07
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static List<Map<String,String>> receUserStaus(){
		return Arrays.asList(OrderStausEnum.values()).stream().map(orderStaus -> {
			Map<String,String> reponseMap = Maps.newHashMap();
			OrderStausEnum ordertStaus = ((OrderStausEnum)orderStaus);
			reponseMap.put("code", ordertStaus.getCode());
			reponseMap.put("name", ordertStaus.getName());
			return reponseMap;
		}).collect(Collectors.toList());
	}

	/***
	 *
	 * 构造函数:
	 * @param code
	 * @param name
	 */
	OrderStausEnum(String code, String name){
		this.code = code;
		this.name = name;
	}

	
	

	/** 
	 * @return code 
	 */
	public String getCode() {
		return code;
	}


	/** 
	 * @param code 要设置的 code 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/** 
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}

}
