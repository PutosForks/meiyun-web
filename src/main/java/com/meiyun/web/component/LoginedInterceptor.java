package com.meiyun.web.component;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.meiyun.core.Constants;
import com.meiyun.core.Route;
import com.meiyun.core.annotation.Logined;
import com.meiyun.model.User;
import com.meiyun.web.core.WebController;

/**
 * 用户登录拦截器
 * 
 * @author Administrator
 *
 */
public class LoginedInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginedInterceptor.class);

	// 视图解析完成之后执行
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception e)
			throws Exception {

	}

	// 控制器执行完到达视图之前
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
	}

	// 请求到达控制器之前 
	// object: 下一个节点对象
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		
		// 设置字符编码
		response.setCharacterEncoding(Constants.CHARSET);
		String webPath = request.getContextPath();
		logger.debug("webPath: " + webPath);
		String uri = request.getRequestURI();
		logger.debug("URI: " + uri);
		
		if (object instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) object;
			Method method = handlerMethod.getMethod();
			
			if (method.isAnnotationPresent(Logined.class)) {
				User loginUser = new WebController().getLoginUser(request);
				if (loginUser == null) { // 未登录
					response.sendRedirect(Route.USER_LOGIN + "?redirectUrl=" + uri);
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 判断是否为Ajax请求：已测试通过
	 * @param request
	 * @return
	 */
	/*private boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equalsIgnoreCase(requestType);
	}*/

}
