package org.forbes.comm.vo;

import lombok.Data;
import org.forbes.comm.constant.CommonConstant;

import java.io.Serializable;

/***
 * Result概要说明：统一返回错误
 * @author Huanghy
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String message = "操作成功！";
	/******登录相关提示信息****/

	/*****公共操作结果信息*****/
	public static final  String COMM_ACTION_MSG = "操作成功";
	public static final  String COMM_ACTION_ERROR_MSG = "操作失败";

	/******查询订单信息****/
	public static final  String ORDER_MSG = "查询所有订单成功";
	public static final  String ORDER_NOT_ERROR_MSG = "查询所有订单失败";

	/******订单编码信息****/
	public static final  String EXISTS_ORDER_SN_MSG = "订单编码已存在";
	public static final  String AVAILABLE_ORDER_SN_MSG = "订单编码可用";


	/**
	 * 返回代码
	 */
	private Integer code = CommonConstant.SC_OK_200;
	private String  bizCode = "";
	
	/**
	 * 返回数据对象 data
	 */
	private T result;

	public Result() {
		
	}
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public void error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
	}

	public void success(String message) {
		this.message = message;
		this.code = CommonConstant.SC_OK_200;
		this.success = true;
	}
	
	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}
	
	/***
	 * error方法慨述:
	 * @param bizCode
	 * @param msg
	 * @return Result<Object>
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 下午4:07:04
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public  void error(String bizCode, String msg) {
		this.bizCode = bizCode;
		this.message = msg;
		this.success = false;
	}
	
	public static Result<Object> ok(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		return r;
	}
	
	public static Result<Object> ok(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}
}

