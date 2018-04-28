/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月11日
 * @desc   
 */
public abstract class AbstractHandler <M extends AbstractModel> {

	/**
	 * 对前端传入的object进行参数合法性检查，如果不合法，则抛出异常，说明元婴
	 * 如果返回正常，则返回this
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	protected abstract void preHandle(M object) throws Exception;
	
	/**
	 * 对前端传入的对象进行业务逻辑处理，比如对数据库进行操作
	 * 操作完后，会生成返回给前端的对象
	 * 
	 * 该过程如果有任何异常，必须以抛出异常的方式进行处理
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	protected abstract Object doHandle(M object) throws Exception;
	
	/**
	 * 封装成ResponseResult，如果必要，子类也可以继承，进行自己的业务逻辑处理
	 * 
	 * @param object
	 * @return
	 */
	protected ResponseResult postHandle(Object object) {
		ResponseResult result = new ResponseResult(
				ResponseResult.STATUS_SUCCESS, "");
		result.setResult(object);
		return result;
	}
	
	/**
	 * 处理对象，返回给前端
	 * 
	 * @param instance
	 * @return
	 */
	public ResponseResult handle(M instance) {
		try {
			preHandle(instance);
			Object res = doHandle(instance);
			return postHandle(res);
		} catch (Exception ex) {
			return new ResponseResult(
					ResponseResult.STATUS_ERROR, ex.getMessage());
		}
	}
}
