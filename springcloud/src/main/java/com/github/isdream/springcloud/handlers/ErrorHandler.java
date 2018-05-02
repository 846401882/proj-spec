/**
 * Copyrigt (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.handlers;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.isdream.springcloud.cores.HttpConstants;
import com.github.isdream.springcloud.cores.HttpResponse;
import com.github.isdream.springcloud.cores.spi.HttpBodyHandler;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2018年4月28日
 * 
 */
@Component
public class ErrorHandler extends HttpBodyHandler {

	@Override
	protected Object doHandle(Map<String, Object> body) throws Exception {
		throw new Exception(HttpConstants.EXCEPTION_UNKNOWN_REQUEST_URL);
	}

	@Override
	public String getOperation() {
		return "unkown";
	}

}
