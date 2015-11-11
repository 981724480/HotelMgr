package com.tianyi.yw.common.tags;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.tianyi.yw.common.utils.Constants;
import com.tianyi.yw.common.utils.StringUtil;
import com.tianyi.yw.model.Function;

public class FunctionButtonTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -873501176437637524L;
	
	private String buttonType="btn";
	
	private String functionCode;
	
	private String onClick="";
	
	private String style="";
	
	private String styleClass="";
	
	private String iconCls="";
	
	private String target="";
	
	private String plain="false";
	
	private String id="";
	
	private String name="";

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public int doEndTag() throws JspException {
		String currentMenuId = (String)pageContext.getSession().getAttribute(Constants.CURRENT_MENU_ID);
		Map<String, Function> userFunctions = (Map<String, Function>)pageContext.getSession().getAttribute(Constants.USER_SESSION_FUNCTION);
		Function func = userFunctions.get(currentMenuId + functionCode);
		if(null == func){
			return TagSupport.EVAL_PAGE;
		}
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String html = "";
		if("btn".equals(buttonType)){
			html = "<input type='button' id='"+id+"' name='"+name+"' value='" + func.getName()+ "' class='" + styleClass + "' style='" + style + "' onclick='"+onClick+"'>";
		}else{
			if(StringUtil.isEmpty(onClick)){
				html = "<a target='"+target+"' id='"+id+"' name='"+name+"' href='"+request.getContextPath() +"/"+func.getUrl()+ "' class='" + styleClass + "' style='" + style +"' iconCls='"+iconCls+"' plain='"+plain+"'>"+func.getName()+"</a>";
			}else{
				html = "<a target='"+target+"' id='"+id+"' name='"+name+"' href='javascript:"+onClick+ "' class='" + styleClass + "' style='" + style +"' iconCls='"+iconCls+"' plain='"+plain+"'>"+func.getName()+"</a>";
			}
		}
		try {
			out.print(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}
}
