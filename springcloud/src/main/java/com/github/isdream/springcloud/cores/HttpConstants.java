/**
 * Copyrigt (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since 2018年4月28日
 * 
 */
public class HttpConstants {

	/*****************************************************************
	 * 
	 *                       HTTP Request
	 * 
	 *****************************************************************/
	public final static String HTTP_REQUEST_PATH_INFO = "pathInfo";

	public final static String HTTP_REQUEST_USER_INFO = "userInfo";

	public final static String HTTP_REQUEST_PROXY_INFO = "proxyInfo";

	public final static String HTTP_REQUEST_PARAM_INFO = "paramInfo";
	
	/*****************************************************************
	 * 
	 *                       HTTP Response
	 * 
	 *****************************************************************/
	public final static int HTTP_RESPONSE_STATUS_OK = 200;

	public final static int HTTP_RESPONSE_STATUS_FAILED = 500;
	
	/******************************************************************
	 * 
	 *                       Http Handler Exceptions
	 * 
	 ******************************************************************/
	
	public final static String EXCEPTION_UNSUPPORT_REQUEST_URL = "Unsupport request URL.";
	
	public final static String EXCEPTION_UNKNOWN_REQUEST_URL = "Unknown request URL.";

}
