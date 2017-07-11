
package com.geekcattle.conf.shiro;

import com.geekcattle.conf.LoginEnum;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * author 
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        if(subject.getPrincipal() != null){
            Session session = subject.getSession();
            if(session.getAttribute("loginType").equals(LoginEnum.CUSTOMER.toString())){
                return super.isAccessAllowed(request, response, mappedValue);
            }else{
                return false;
            }
        }else{
            return super.isAccessAllowed(request, response, mappedValue);
        }
    }

    @Override
    public void setLoginUrl(String loginUrl) {
        super.setLoginUrl("/barber/member/login");
    }

    @Override
    public void setSuccessUrl(String successUrl) {
        super.setSuccessUrl("/barber/member/index");
    }
}
